package com.ebasket.server.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
	@Autowired
	RestTemplate restTemplate;

	@Override
	public void run(String... args) throws Exception {

		ResponseEntity<String> re = restTemplate.getForEntity("http://localhost:8080/productcategory/filldb",
				String.class);
		logger.debug(re.getBody());

	}

}
