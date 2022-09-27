package com.seisma.validate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.seisma.dao.Topic;
import com.seisma.main.TopicRuleFactory;

public class DescriptionValidatorTest{
	
	private TopicRuleFactory configTopic = TopicRuleFactory.getInstance();
	
	@Test
	@DisplayName("Test Topic-A Desc more than 10")
	void validateTopicAMoreDesc10() {
		
		String topicId = "A";
		String topicName = "a";
		String topicDesc = "12345678910111213";
		
		Topic topicA = new Topic(topicId, topicName, topicDesc);
		
		assertEquals(true,new DescriptionValidator().validate(topicA));
	}
	
	@Test
	@DisplayName("Test Topic-A Desc less than 10")
	void validateTopicADesc10() {
		
		String topicId = "A";
		String topicName = "a";
		String topicDesc = "1234";
		
		Topic topicA = new Topic(topicId, topicName, topicDesc);
		
		assertEquals(false,new DescriptionValidator().validate(topicA));
	}
	
	@Test
	@DisplayName("Test Topic-B Desc less than 40")
	void validateTopicBDesc10() {
		
		String topicId = "A";
		String topicName = "a";
		String topicDesc = "1234";
		
		Topic topicB = new Topic(topicId, topicName, topicDesc);
		
		assertEquals(false,new DescriptionValidator().validate(topicB));
	}
	
	@Test
	@DisplayName("Test Topic-C Name Out of Scope")
	void validateTopicC() {
		
		String topicId = "C";
		String topicName = "c";
		String topicDesc = "qwertyuioplkjhg";
		
		Topic topicA = new Topic(topicId, topicName, topicDesc);
		
		assertEquals(false,new NameValidator().validate(topicA));
	}

}
