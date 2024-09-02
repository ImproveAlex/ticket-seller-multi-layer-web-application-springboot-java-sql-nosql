package com.tiw8205.cha8205;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Cha8205Application {

	public static void main(String[] args) {
		SpringApplication.run(Cha8205Application.class, args);
	}

	@Bean
	public RestTemplate resTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
