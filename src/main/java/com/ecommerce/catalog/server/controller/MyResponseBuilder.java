package com.ecommerce.catalog.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class MyResponseBuilder {

	public static <T> ResponseEntity getBuildResponse(T t, HttpStatus httpStatus) {
		
		log.debug("My Response Builder is called ... ");
		return new ResponseEntity<T>(t, httpStatus);
	}

}
