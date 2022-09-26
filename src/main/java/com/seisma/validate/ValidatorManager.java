package com.seisma.validate;

import com.seisma.dao.Topic;
import com.seisma.util.JSONReader;

public class ValidatorManager {

	public void validate() {

		try {
			Topic[] topicList = JSONReader.readTopicJSON();
			
			for (int i = 0; i < topicList.length; i++) {
				Topic topic = topicList[i];
				
				boolean isValidName = new NameValidator().validate(topic);
				boolean isValidDesc = new DescriptionValidator().validate(topic);
				
				String msg = "";
				if(isValidName && isValidDesc) {
					msg = "["+i+"] \t- PASS\t : "+ topic.getName();
				}else {
					msg = "["+i+"] \t- FAIL\t : "+ topic.getName();
				}
				System.out.println(msg);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--- END ---");
	}

}
