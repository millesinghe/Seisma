package com.seisma.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seisma.dao.Topic;
import com.seisma.dao.TopicConfig;

public class JSONReader {
	
	private static JSONReader reader;
	
	private static ObjectMapper mapper;

	private static TopicConfig[] listTopics;
	
	private static Object readJSON(String filePath, Class<?> classType) {
		try {
			return mapper.readValue(new File(filePath), classType);
		} catch (Exception e) {
			e.printStackTrace();
		};
		return null;
	} 
	
	public static TopicConfig[] getConfigMeta() throws JsonParseException, JsonMappingException, IOException {
		TopicConfig[] listTopics = null;
		if (reader == null){
			reader =  new JSONReader();
			mapper = new ObjectMapper();
			listTopics = (TopicConfig[]) readJSON("E:\\Workspace\\TopicApp\\src\\main\\resources\\topicrules.json",TopicConfig[].class );
		}
		return listTopics;
		 
	}
	
	public static Topic[] readTopicJSON() throws JsonParseException, JsonMappingException, IOException {
		Topic[] listTopics = (Topic[]) readJSON("E:\\Workspace\\TopicApp\\src\\main\\resources\\topic.json",Topic[].class );
		return listTopics;
		 
	}

}
