package com.seisma.main;

import org.apache.log4j.Logger;

import com.seisma.validate.ValidatorManager;

public class MainClass {

	private static Logger logger = Logger.getLogger(MainClass.class);

	public static void main(String[] args) {
		
		logger.info("Starting the Application");
		TopicRuleFactory.getInstance();;

		logger.info("Starting to validate the Topic JSON");
		ValidatorManager v = new ValidatorManager();
		v.validate();

		logger.info("Validation Completed");
	}

}
