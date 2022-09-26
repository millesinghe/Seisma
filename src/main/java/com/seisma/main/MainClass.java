package com.seisma.main;

import com.seisma.dao.TopicRuleFactory;
import com.seisma.validate.ValidatorManager;

public class MainClass {

	public static void main(String[] args) {
		TopicRuleFactory.getInstance().initTopicConditions();;

		ValidatorManager v = new ValidatorManager();
		v.validate();
		
		System.out.println();
	}

}
