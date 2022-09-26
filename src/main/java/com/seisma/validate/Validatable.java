package com.seisma.validate;

import com.seisma.dao.Topic;

public interface Validatable {

	boolean validate(Topic topic);
}
