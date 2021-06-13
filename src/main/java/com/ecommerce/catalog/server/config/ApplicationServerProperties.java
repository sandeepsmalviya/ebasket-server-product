package com.ecommerce.catalog.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@Setter
@Getter
@NoArgsConstructor
public class ApplicationServerProperties {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("{spring.datasource.url}")
	private String dataSourceUrl;

	
	@Value("${logging.file.name}")
	private String loggingFileName;
}
