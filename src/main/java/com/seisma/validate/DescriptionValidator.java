package com.seisma.validate;

import java.util.List;

import org.apache.log4j.Logger;

import com.seisma.dao.Topic;
import com.seisma.dao.TopicConfig;
import com.seisma.dao.TopicRuleFactory;
import com.seisma.dao.TopicRules;

public class DescriptionValidator implements Validatable {

	private static Logger logger = Logger.getLogger(DescriptionValidator.class);

	public boolean validate(Topic topic) {
		String curTopic = topic.getTopic();
		int currTopicDescLength = topic.getDescription().length();
		
		logger.debug("Desc length \t: "+currTopicDescLength);
		TopicConfig conf = TopicRuleFactory.getInstance().getTopic(curTopic);
		List<TopicRules> ruleList = conf.getRules();
		logger.debug("Rules Count \t: "+ruleList.size());
		
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
