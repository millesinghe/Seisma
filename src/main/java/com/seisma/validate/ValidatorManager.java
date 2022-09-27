package com.seisma.validate;

import org.apache.log4j.Logger;

import com.seisma.dao.Topic;
import com.seisma.util.JSONReader;

public class ValidatorManager {

	private static Logger logger = Logger.getLogger(ValidatorManager.class);
	
	public void validate() {

		try {
			Topic[] topicList = JSONReader.readTopicJSON();
			
			for (int i = 0; i < topicList.length; i++) {
				Topic topic = topicList[i];
				
				logger.debug("["+i+"] TOPIC : "+ topic.getTopic() + "------------");
				boolean isValidName = new NameValidator().validate(topic);
				boolean isValidDesc = new DescriptionValidator().validate(topic);

				String msg = "";
				if(isValidName && isValidDesc) {
					msg = "["+i+"] PASS\t : "+ topic.getName();
					logger.info(msg);
				}else {
					msg = "["+i+"] FAIL\t : "+ topic.getName();
					logger.warn(msg);
				}
			}
			
		} catch (Exception e) {
			logger.error("ERROR", e);
		}
	}

}
