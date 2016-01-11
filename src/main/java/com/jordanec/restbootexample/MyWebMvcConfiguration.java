package com.jordanec.restbootexample;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

@Configuration
@EnableWebMvc
public class MyWebMvcConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //Here we add our custom-configured HttpMessageConverter
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
	}
	
    public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();

        //mapper.configure(MapperFeature.);
        //mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        //mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
        //Registering Hibernate4Module to support lazy objects
        Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.configure(Feature.FORCE_LAZY_LOADING, true);
        
        mapper.registerModule(hibernate4Module);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        messageConverter.setObjectMapper(mapper);
        return messageConverter;

    }
	
    /*
	@Bean
	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = myObjectMapper();
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}
	
	@Primary
	@Bean
	public ObjectMapper myObjectMapper() {
		return new HibernateAwareObjectMapper();
	}*/
	
}
