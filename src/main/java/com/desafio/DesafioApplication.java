package com.desafio;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("springshop-public").packagesToScan("com.desafio").build();
	}

	@Bean
	public RestTemplate getresttemplate() {
		return new RestTemplate();
	}
}
