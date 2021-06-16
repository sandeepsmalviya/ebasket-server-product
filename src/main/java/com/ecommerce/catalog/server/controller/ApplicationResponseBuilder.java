package com.ecommerce.catalog.server.controller;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class ApplicationResponseBuilder {

	public static <T> ResponseEntity buildResponse(T t, HttpStatus httpStatus) {
			return new ResponseEntity<T>(t,httpStatus);
	}

}
