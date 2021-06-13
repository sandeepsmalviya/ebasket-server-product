package com.ecommerce.catalog.server.exception;

public class ProductCategoryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductCategoryNotFoundException() {
		super();

	}

	public ProductCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ProductCategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public ProductCategoryNotFoundException(String message) {
		super(message);

	}

	public ProductCategoryNotFoundException(Throwable cause) {
		super(cause);

	}

}
