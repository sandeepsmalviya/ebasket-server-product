package com.ecommerce.catalog.server.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ecommerce.catalog.server.config.ApplicationServerProperties;
import com.ecommerce.catalog.server.entity.Product;
import com.ecommerce.catalog.server.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/product")
@Slf4j
public class ProductController {

	@Autowired
	ApplicationServerProperties applicationProperties;

	@Autowired
	ProductService productService;

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId) {

		Product product = productService.findById(productId);
		 return new ResponseEntity<>(product, HttpStatus.OK);
		//return ApplicationResponseBuilder.buildResponse(product);
	}

	@GetMapping("/")
	public ResponseEntity<Product[]> getAllProducts() {

		List<Product> productList = productService.findAll();

		if (productList == null || productList.isEmpty()) {
			Product[] productArray = productList.toArray(new Product[0]);
			// return new ResponseEntity<>(productArray, HttpStatus.NO_CONTENT);
			return ApplicationResponseBuilder.buildResponse(productArray, HttpStatus.NO_CONTENT);
		} else {
			Product[] productArray = productList.toArray(new Product[0]);

			// return new ResponseEntity<>(productArray, HttpStatus.OK);
			return ApplicationResponseBuilder.buildResponse(productArray, HttpStatus.OK);
		}

	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) {

		productService.delete(productId);
		return new ResponseEntity<>("Product with id = " + productId + " is deleted", HttpStatus.OK);

	}

	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId, @Valid @RequestBody Product product) {

		product.setProductId(productId);
		Product productUpdated = productService.update(product);
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	@PostMapping("/")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {

		Product productCreated = productService.create(product);
		return new ResponseEntity<>(productCreated, HttpStatus.CREATED);

	}

}
