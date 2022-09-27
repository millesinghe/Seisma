package com.seisma.validate;

import org.apache.log4j.Logger;

import com.seisma.dao.Topic;
import com.seisma.main.TopicRuleFactory;

public class NameValidator implements Validatable {
	
	private static Logger logger = Logger.getLogger(NameValidator.class);

	public boolean validate(Topic topic) {
		String curTopic = topic.getTopic();
		String configName = TopicRuleFactory.getInstance().getTopic(curTopic).getName();
		logger.debug("expected : \t "+ configName + " - actual " + curTopic  );
		return configName.equals(topic.getName());
	}

}
