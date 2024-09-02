package com.tiw8205.admin8205;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Admin8205Application {

    public static void main(String[] args) {
        SpringApplication.run(Admin8205Application.class, args);
    }

    @Bean
    public RestTemplate resTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
