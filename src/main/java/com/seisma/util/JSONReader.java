package com.seisma.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seisma.dao.Topic;
import com.seisma.dao.TopicConfig;

public class JSONReader {

	private static JSONReader reader;

	private static Logger logger = Logger.getLogger(JSONReader.class);

	private static final String filenameRule = "topicrules.json";

	private static final String filenameTopic = "topic.json";

	private static Object readJSON(String fileName, Class<?> classType) {
		try {
			logger.info("loaded the " + fileName + " file");
			File file = reader.getFileFromResource(fileName);
			return new ObjectMapper().readValue(file, classType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private File getFileFromResource(String fileName) throws URISyntaxException {

		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return new File(resource.toURI());
		}

	}

	public static TopicConfig[] getConfigMeta() throws JsonParseException, JsonMappingException, IOException {
		logger.info("loading the config meta file.");
		TopicConfig[] listTopics = null;
		if (reader == null) {
			reader = new JSONReader();
			listTopics = (TopicConfig[]) readJSON(filenameRule,
					TopicConfig[].class);
		}
		return listTopics;

	}

	public static Topic[] readTopicJSON() throws JsonParseException, JsonMappingException, IOException {
		logger.info("loading the topic json file.");
		Topic[] listTopics = (Topic[]) readJSON(filenameTopic,
				Topic[].class);
		return listTopics;
	}

}
