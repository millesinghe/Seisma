package com.seisma.dao;

import java.util.HashMap;
import java.util.Map;

import com.seisma.util.JSONReader;

public class TopicRuleFactory {

	private static TopicRuleFactory trf;
	
	private Map<String, TopicConfig> mapTopicConfig;
	
	private TopicRuleFactory() {}
	
	public static TopicRuleFactory getInstance() {
		if(trf == null) {
			trf = new TopicRuleFactory();
		}
		return trf;
	}
	
	public void initTopicConditions() {
		mapTopicConfig = new HashMap<String, TopicConfig>();
		try {
			TopicConfig[] topicConfigList = JSONReader.getConfigMeta();
			
			for(TopicConfig topicCfg : topicConfigList){
				mapTopicConfig.put(topicCfg.getTopic(), topicCfg);
			}
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TopicConfig getTopic(String topic) {
		return mapTopicConfig.get(topic);
	}
	
	

	
}
