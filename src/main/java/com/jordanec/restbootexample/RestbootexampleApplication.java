package com.jordanec.restbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.model.ConfederacionRepository;
//Tell Spring to automatically inject any dependencies that are marked in
//our classes with @Autowired
@EnableAutoConfiguration
//Tell Spring to automatically create a JPA implementation of our
//VideoRepository
@EnableJpaRepositories(basePackages = "com.jordanec.restbootexample.model")//ConfederacionRepository.class
//Tell Spring that this object represents a Configuration for the
//application
//@Configuration
//Tell Spring to turn on WebMVC (e.g., it should enable the DispatcherServlet
//so that requests can be routed to our Controllers)
@EnableWebMvc
@EntityScan(basePackages="com.jordanec.restbootexample.model")
//Tell Spring to go and scan our controller package (and all sub packages) to
//find any Controllers or other components that are part of our applciation.
//Any class in this package that is annotated with @Controller is going to be
//automatically discovered and connected to the DispatcherServlet.
@EnableTransactionManagement
@ComponentScan(basePackages="com.jordanec.restbootexample")
@SpringBootApplication()//exclude={HibernateJpaAutoConfiguration.class})
public class RestbootexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestbootexampleApplication.class, args);
	}
}
