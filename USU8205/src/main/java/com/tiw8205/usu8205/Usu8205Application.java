package com.tiw8205.usu8205;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Usu8205Application {

	public static void main(String[] args) {
		SpringApplication.run(Usu8205Application.class, args);
	}

	@Bean
	public RestTemplate resTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
