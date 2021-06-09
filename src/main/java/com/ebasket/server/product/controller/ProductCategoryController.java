package com.ebasket.server.product.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ProductCategoryNotFoundException;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.services.ProductCategoryService;

@RestController
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;

	@GetMapping("/productcategory/test")
	public String helloProductsCategory() {
		return "Hello, From Products";
	}

	@GetMapping("/productcategory/filldb")
	public String filldb() {
		productCategoryService.createSampleProductCategory();
		return "Data filled successfully in products cateory";
	}

	@GetMapping("/productcategory/{productCategoryId}")
	public ResponseEntity<ProductCategory> getProduct(@PathVariable int productCategoryId)
			throws ProductCategoryNotFoundException {
		ProductCategory productCategory = productCategoryService.findById(productCategoryId);
		return new ResponseEntity<>(productCategory, HttpStatus.OK);

	}

	@GetMapping("/productcategory/")
	public ResponseEntity<ProductCategory[]> getAllProducts() throws ProductNotFoundException {
		List<ProductCategory> productCategoryList = productCategoryService.findAll();

		ProductCategory[] productCategoryArray = productCategoryList.toArray(new ProductCategory[0]);
		return new ResponseEntity<>(productCategoryArray, HttpStatus.OK);

	}

	@DeleteMapping("/productcategory/{productCategoryId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productCategoryId) throws ProductNotFoundException {
		productCategoryService.delete(productCategoryId);
		return new ResponseEntity<>("ProductCategory is deleted successfully", HttpStatus.OK);

	}

	@PutMapping("/productcategory/{productCategoryId}")
	public ResponseEntity<String> updateProduct(@PathVariable int productId,
			@Valid @RequestBody ProductCategory productCategory) throws ProductCategoryNotFoundException {
		ProductCategory productCategoryUpdated = productCategoryService.update(productCategory);
		return new ResponseEntity<>("ProductCategory is updated successfully", HttpStatus.OK);

	}

	@PostMapping("/productcategory/")
	public ResponseEntity<String> createProduct(@Valid @RequestBody ProductCategory productCategory)
			throws ProductCategoryNotFoundException {
		ProductCategory productCategoryCreated = productCategoryService.update(productCategory);
		return new ResponseEntity<>("ProductCategory is created successfully", HttpStatus.CREATED);
	}

}
