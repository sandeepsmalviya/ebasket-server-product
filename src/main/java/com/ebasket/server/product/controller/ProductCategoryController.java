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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ProductCategoryNotFoundException;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.exception.ServiceException;
import com.ebasket.server.product.services.ProductCategoryService;

@RestController
@RequestMapping(value = "/api/productcategory")
public class ProductCategoryController {

	private static final Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	ProductCategoryService productCategoryService;

	@GetMapping("/info")
	public String helloProductCategory() {
		logger.error(applicationName + ", ProductCategoryController welcomes you");
		return applicationName + ", ProductCategoryController welcomes you";
	}

	@GetMapping("/{productCategoryId}")
	public ResponseEntity<ProductCategory> getProductCategory(@PathVariable int productCategoryId)
			throws ProductCategoryNotFoundException, ServiceException {

		try {
			ProductCategory productCategory = productCategoryService.findById(productCategoryId);
			return new ResponseEntity<>(productCategory, HttpStatus.OK);
			
		} catch (ProductCategoryNotFoundException exception) {
			throw exception;
		} catch (ServiceException exception) {
			throw exception;
		}

	}

	@GetMapping("/")
	public ResponseEntity<ProductCategory[]> getAllProducts() throws ProductNotFoundException, ServiceException {

		try {
			List<ProductCategory> productCategoryList = productCategoryService.findAll();

			if (productCategoryList == null || productCategoryList.isEmpty()) {
				ProductCategory[] productCategoryArray = productCategoryList.toArray(new ProductCategory[0]);
				return new ResponseEntity<>(productCategoryArray, HttpStatus.NO_CONTENT);
			} else {
				ProductCategory[] productCategoryArray = productCategoryList.toArray(new ProductCategory[0]);
				return new ResponseEntity<>(productCategoryArray, HttpStatus.OK);
			}

		} catch (ServiceException exception) {
			throw exception;
		}

	}

	@DeleteMapping("/{productCategoryId}")
	public ResponseEntity<String> deleteProductCategory(@PathVariable int productCategoryId)
			throws ProductCategoryNotFoundException, ServiceException {

		try {
			productCategoryService.delete(productCategoryId);
			return new ResponseEntity<>("Product with id = " + productCategoryId + " is deleted", HttpStatus.OK);
			
		} catch (ProductCategoryNotFoundException exception) {
			throw exception;
		} catch (ServiceException exception) {
			throw exception;
		}

	}

	@PutMapping("/{productCategoryId}")
	public ResponseEntity<ProductCategory> updateProduct(@PathVariable int productCategoryId,
			@Valid @RequestBody ProductCategory productCategory)
			throws ProductCategoryNotFoundException, ServiceException {

		try {
			productCategory.setCategoryId(productCategoryId);
			ProductCategory productCategoryUpdated = productCategoryService.update(productCategory);
			return new ResponseEntity<>(productCategoryUpdated, HttpStatus.OK);
			
		} catch (ProductCategoryNotFoundException exception) {
			throw exception;
		} catch (ServiceException exception) {
			throw exception;
		}

	}

	@PostMapping("/")
	public ResponseEntity<String> createProduct(@Valid @RequestBody ProductCategory productCategory)
			throws ServiceException {

		try {
			ProductCategory productCategoryCreated = productCategoryService.create(productCategory);
			return new ResponseEntity<>("ProductCategory is created", HttpStatus.CREATED);

		} catch (ServiceException serviceException) {
			throw serviceException;
		}

	}

}
