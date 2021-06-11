package com.ebasket.server.product.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebasket.server.product.entity.Product;
import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.exception.ServiceException;
import com.ebasket.server.product.services.ProductService;

@RestController
@RequestMapping(value="/api/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	ProductService productService;

	@GetMapping("/info")
	public String helloProducts() {
		logger.error(applicationName + ", productController welcomes you");
		return applicationName + ", productController welcomes you";
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId)
			throws ProductNotFoundException, ServiceException {

		try {
			Product product = productService.findById(productId);
			return new ResponseEntity<>(product, HttpStatus.OK);
			
		} catch (ProductNotFoundException exception) {
			throw exception;
		} catch (ServiceException exception) {
			throw exception;
		}

	}

	@GetMapping("/")
	public ResponseEntity<Product[]> getAllProducts() throws ProductNotFoundException, ServiceException {

		try {
			List<Product> productList = productService.findAll();

			if (productList == null || productList.isEmpty()) {
				Product[] productArray = productList.toArray(new Product[0]);
				return new ResponseEntity<>(productArray, HttpStatus.NO_CONTENT);
			} else {
				Product[] productArray = productList.toArray(new Product[0]);
				return new ResponseEntity<>(productArray, HttpStatus.OK);
			}

		} catch (ServiceException exception) {
			throw exception;
		}

	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId)
			throws ProductNotFoundException, ServiceException {

		try {
			productService.delete(productId);
			return new ResponseEntity<>("Product with id = " + productId + " is deleted", HttpStatus.OK);
			
		} catch (ProductNotFoundException exception) {
			throw exception;
		} catch (ServiceException exception) {
			throw exception;
		}

	}

	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId, @Valid @RequestBody Product product)
			throws ProductNotFoundException, ServiceException {

		try {
			product.setProductId(productId);
			Product productUpdated = productService.update(product);
			return new ResponseEntity<>(product, HttpStatus.OK);
			
		} catch (Exception exception) {
			throw new ProductNotFoundException("Product with id = " + productId + " not found, cant' update",
					exception);
		}

	}

	@PostMapping("/")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product)
			throws ProductNotFoundException, ServiceException {
	
		
		try {
			Product productCreated = productService.create(product);
			return new ResponseEntity<>("Product is created", HttpStatus.CREATED);

		} catch (ServiceException serviceException) {
			throw serviceException;
		}

		
	}

}
