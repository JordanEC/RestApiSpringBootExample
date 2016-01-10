package com.jordanec.restbootexample;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.repository.ConfederacionRepository;

//Tell Spring to automatically inject any dependencies that are marked in
//our classes with @Autowired
@EnableAutoConfiguration
// Tell Spring to automatically create a JPA implementation of our
// VideoRepository
@EnableJpaRepositories(basePackages = "com.jordanec.restbootexample.repository") // ConfederacionRepository.class
// Tell Spring that this object represents a Configuration for the
// application
@Configuration
// Tell Spring to turn on WebMVC (e.g., it should enable the DispatcherServlet
// so that requests can be routed to our Controllers)
@EnableWebMvc
@EntityScan(basePackages = "com.jordanec.restbootexample.model")
// Tell Spring to go and scan our controller package (and all sub packages) to
// find any Controllers or other components that are part of our applciation.
// Any class in this package that is annotated with @Controller is going to be
// automatically discovered and connected to the DispatcherServlet.
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jordanec.restbootexample")
@SpringBootApplication() // exclude={HibernateJpaAutoConfiguration.class})
public class RestbootexampleApplication/* extends WebMvcConfigurationSupport */{

	public static void main(String[] args) {
		SpringApplication.run(RestbootexampleApplication.class, args);
	}
/*
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(customJackson2HttpMessageConverter());
		super.addDefaultHttpMessageConverters(converters);
	}

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