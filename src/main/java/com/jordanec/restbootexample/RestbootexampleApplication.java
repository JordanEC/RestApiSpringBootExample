package com.jordanec.restbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.jordanec.restbootexample.repository") // ConfederationRepository.class
@EntityScan(basePackages = "com.jordanec.restbootexample.model")
@EnableTransactionManagement
@ComponentScan//basePackages = "com.jordanec.restbootexample")
@SpringBootApplication // exclude={HibernateJpaAutoConfiguration.class})
public class RestbootexampleApplication/* extends WebMvcConfigurationSupport */{

	public static void main(String[] args) {
		SpringApplication.run(RestbootexampleApplication.class, args);
	}
/*
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(customJackson2HttpMessageConverter());
		super.addDefaultHttpMessageConverters(converters);
	}*/

}
/*
class HibernateAwareObjectMapper extends ObjectMapper {

	public HibernateAwareObjectMapper() {
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		this.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
		this.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
		
		registerModule(new Hibernate4Module());
	}
}*/