package com.seisma.validate;

import java.util.List;

import com.seisma.dao.Topic;
import com.seisma.dao.TopicConfig;
import com.seisma.dao.TopicRuleFactory;
import com.seisma.dao.TopicRules;

public class DescriptionValidator implements Validatable {

	public boolean validate(Topic topic) {
		String curTopic = topic.getTopic();
		int currTopicDescLength = topic.getDescription().length();
		
		TopicConfig conf = TopicRuleFactory.getInstance().getTopic(curTopic);
		List<TopicRules> ruleList = conf.getRules();

		boolean returnRes = true;
		
		for(TopicRules rule : ruleList) {
			if (rule.getType().equalsIgnoreCase(Condition.LESS.toString())) {
				returnRes = (currTopicDescLength < Integer.parseInt(rule.getValue()));
			}else if(rule.getType().equalsIgnoreCase(Condition.MORE.toString())){ 
				returnRes = (currTopicDescLength > Integer.parseInt(rule.getValue()));
			}
			
			if (!returnRes) {return false;}
		}
		return returnRes;
	}

}
