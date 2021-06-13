package com.ecommerce.catalog.server.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigApplicationServerInterceptor implements WebMvcConfigurer {
	
	
	@Autowired
	ApplicationServerInterceptor applicationServerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(new ApplicationServerInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(applicationServerInterceptor).addPathPatterns("/**");
	}
}