package com.ebasket.server.product.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ebasket.server.product.EbasketServerProductApplication;
import com.ebasket.server.product.entity.Product;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.services.ProductService;

@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	
	
	@Value("${spring.application.name}")
	private String applicationName;
	

	@Autowired
	ProductService productService;
	

	@GetMapping("/product/test")
	public String hellpProducts() {
		logger.error(applicationName + ", welcomes you");
		return "Hello, From Products";
	}

	@GetMapping("/product/filldb")
	public String filldb() {
		productService.createSampleProducts();
		return "Data filled successfully in products";
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId) throws ProductNotFoundException {
		Product product = productService.findById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	@GetMapping("/product/")
	public ResponseEntity<Product[]> getAllProducts() throws ProductNotFoundException {
		List<Product> productList = productService.findAll();
		Product[] productArray = productList.toArray(new Product[0]);
		return new ResponseEntity<>(productArray, HttpStatus.OK);

	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) throws ProductNotFoundException {
		productService.delete(productId);
		return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);

	}

	@PutMapping("/product/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable int productId, @Valid @RequestBody Product product)
			throws ProductNotFoundException {
		Product productUpdated = productService.update(product);
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);

	}

	@PostMapping("/product/")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) throws ProductNotFoundException {
		Product productCreated = productService.update(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

}
