package com.seisma.dao;

import java.util.List;

public class TopicConfig {

	private String topic;
	private String name;
	private List<TopicRules> rules;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TopicRules> getRules() {
		return rules;
	}
	public void setRules(List<TopicRules> rules) {
		this.rules = rules;
	}
	
	
}
