package com.seisma.validate;

import org.apache.log4j.Logger;

import com.seisma.dao.Topic;
import com.seisma.dao.TopicConfig;
import com.seisma.main.TopicRuleFactory;

public class NameValidator implements Validatable {
	
	private static Logger logger = Logger.getLogger(NameValidator.class);

	public boolean validate(Topic topic) {
		String curTopic = topic.getTopic();
		
		TopicConfig configTopicObj = TopicRuleFactory.getInstance().getTopic(curTopic);
		boolean retValue = false; 
		if (configTopicObj != null) {
			String configName = configTopicObj.getName();
			logger.debug("expected : \t "+ configName + " - actual " + curTopic  );
			retValue = configName.equals(topic.getName());
		}
		return retValue;
	}

}
