package com.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.springboot.dao")
@EntityScan("com.springboot.entities")
public class SmartContactManagerApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SmartContactManagerApplication.class, args);
	}
}
