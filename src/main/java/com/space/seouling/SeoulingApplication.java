package com.space.seouling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SeoulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeoulingApplication.class, args);
	}

}
