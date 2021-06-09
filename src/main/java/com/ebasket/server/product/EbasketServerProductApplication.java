package com.ebasket.server.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EbasketServerProductApplication {

	private static final Logger logger = LoggerFactory.getLogger(EbasketServerProductApplication.class);
	
	
	
	@Value("${spring.application.name}")
	private String applicationName;
	

	public static void main(String[] args) {
		SpringApplication.run(EbasketServerProductApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		logger.debug(applicationName + " is running product sample data filling job");
		return args -> {
			ResponseEntity<String> re = restTemplate.getForEntity("http://localhost:8080/product/filldb", String.class);
			logger.debug(re.getBody());
		};
	}

}
