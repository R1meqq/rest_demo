package com.example.rest_demo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({ "com.example.rest_demo.repository",
				 "com.example.rest_demo.service",
		         "com.example.rest_demo.controller",
})
@SpringBootApplication
@EnableJpaRepositories({"com.example.rest_demo.repository"})
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

}
