package com.seisma.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.seisma.dao.TopicConfig;
import com.seisma.util.JSONReader;

public class TopicRuleFactory {

	private static TopicRuleFactory trf;
	
	private Map<String, TopicConfig> mapTopicConfig;

	private static Logger logger = Logger.getLogger(TopicRuleFactory.class);
	
	private TopicRuleFactory() {
		this.initTopicConditions();
	}
	
	public static TopicRuleFactory getInstance() {
		if(trf == null) {
			trf = new TopicRuleFactory();
		}
		return trf;
	}
	
	public void initTopicConditions() {
		logger.debug("initializing the config topic json");
		
		mapTopicConfig = new HashMap<String, TopicConfig>();
		try {
			TopicConfig[] topicConfigList = JSONReader.getConfigMeta();

			logger.trace("config list is with "+topicConfigList.length+" config records");
			for(TopicConfig topicCfg : topicConfigList){
				mapTopicConfig.put(topicCfg.getTopic(), topicCfg);
				logger.debug(topicCfg.getName()+ " -> Added to the map");
			}
		} catch (Exception e) {
			logger.error("ERROR : {} ", e);
		}
	}
	
	public TopicConfig getTopic(String topic) {
		return mapTopicConfig.get(topic);
	}
	
	

	
}
