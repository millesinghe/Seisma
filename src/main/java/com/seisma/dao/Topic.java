package com.seisma.dao;

public class Topic {

	private String topic;
	private String name;
	private String description;
	
	public Topic() {}
	
	public Topic(String topic, String name, String description) {
		this.topic = topic;
		this.name = name;
		this.description = description;
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
