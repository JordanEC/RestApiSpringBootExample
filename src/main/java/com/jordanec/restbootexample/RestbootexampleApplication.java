package com.jordanec.restbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "com.jordanec.restbootexample.repository")
@EntityScan(basePackages = "com.jordanec.restbootexample.model")
@EnableTransactionManagement
@ComponentScan
@SpringBootApplication
public class RestbootexampleApplication{

	public static void main(String[] args) {
		SpringApplication.run(RestbootexampleApplication.class, args);
	}

}
