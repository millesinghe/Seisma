package com.seisma.validate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.seisma.dao.Topic;
import com.seisma.main.TopicRuleFactory;

public class NameValidatorTest{
	
	private TopicRuleFactory configTopic = TopicRuleFactory.getInstance();
	
	@Test
	@DisplayName("Test Topic-A Name")
	void validateTopicAName() {
		
		String topicId = "A";
		String topicName = "a";
		String topicDesc = "qwertyuioplkjhg";
		
		Topic topicA = new Topic(topicId, topicName, topicDesc);
		
		assertEquals(true,new NameValidator().validate(topicA));
	}
	
	@Test
	@DisplayName("Test Topic-B Name")
	void validateTopicBName() {
		
		String topicId = "B";
		String topicName = "b";
		String topicDesc = "qwertyuioplkjhg";
		
		Topic topicB = new Topic(topicId, topicName, topicDesc);
		
		assertEquals(true,new NameValidator().validate(topicB));
	}
	
	@Test
	@DisplayName("Test Topic-A Name Incorrect")
	void validateTopicAIncorrectName() {
		
		String topicId = "A";
		String topicName = "b";
		String topicDesc = "qwertyuioplkjhg";
		
		Topic topicA = new Topic(topicId, topicName, topicDesc);
		
		assertEquals(false,new NameValidator().validate(topicA));
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
