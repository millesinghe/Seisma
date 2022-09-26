package com.seisma.validate;

import com.seisma.dao.Topic;
import com.seisma.dao.TopicRuleFactory;

public class NameValidator implements Validatable {

	public boolean validate(Topic topic) {
		String curTopic = topic.getTopic();
		return (TopicRuleFactory.getInstance().getTopic(curTopic).getName()).equals(topic.getName());
	}

}
