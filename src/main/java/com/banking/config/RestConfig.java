package com.banking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfig {
	
	@Value("${Jwt.url}")
	private String URL;

	@Bean
	public WebClient getWebClient() {
		return WebClient.builder().baseUrl(URL).build();
	}
}
