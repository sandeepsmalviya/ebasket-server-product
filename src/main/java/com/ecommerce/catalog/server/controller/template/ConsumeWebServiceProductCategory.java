package com.ecommerce.catalog.server.controller.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.catalog.server.entity.Product;

@RestController
public class ConsumeWebServiceProductCategory {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/template/productcategory/{productId}")
	public Product getProduct(@PathVariable int productId) {
		ResponseEntity<Product> re = restTemplate.getForEntity("http://localhost:8080/productcategory/" + productId,
				Product.class);
		return re.getBody();
	}

	@GetMapping(value = "/template/productcategory")
	public Product[] getProductList() {
		ResponseEntity<Product[]> re1 = restTemplate.getForEntity("http://localhost:8080/productcategory/", Product[].class);
		return re1.getBody();

	}

	@DeleteMapping(value = "/template/productcategory/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		ResponseEntity<String> re = restTemplate.exchange("http://localhost:8080/productcategory/" + productId,
				HttpMethod.DELETE, null, String.class);
		return re.getBody();
	}

	@PutMapping(value = "/template/productcategory/{productId}")
	public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product);
		ResponseEntity<Product> re = restTemplate.exchange("http://localhost:8080/productcategory/" + productId,
				HttpMethod.PUT, requestEntity, Product.class);
		return re.getBody();
	}

	@PostMapping(value = "/template/productcategory/")
	public Product createProduct(@RequestBody Product product) {
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product);
		ResponseEntity<Product> re = restTemplate.exchange("http://localhost:8080/productcategory/", HttpMethod.POST,
				requestEntity, Product.class);
		return re.getBody();
	}

}
