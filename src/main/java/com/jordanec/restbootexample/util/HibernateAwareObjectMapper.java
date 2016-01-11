package com.jordanec.restbootexample.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

public class HibernateAwareObjectMapper extends ObjectMapper {
/*
	public HibernateAwareObjectMapper() {

		Hibernate4Module hibernate4Module = new Hibernate4Module();
		//hibernate4Module.configure(Feature., state)
		hibernate4Module.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		hibernate4Module.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		hibernate4Module.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
		hibernate4Module.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
		registerModule(new Hibernate4Module());
	}*/
}