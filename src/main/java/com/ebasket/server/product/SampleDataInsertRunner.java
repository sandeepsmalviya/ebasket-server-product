package com.ebasket.server.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ebasket.server.product.entity.Product;
import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ServiceException;
import com.ebasket.server.product.services.ProductCategoryService;
import com.ebasket.server.product.services.ProductService;

@Component
public class SampleDataInsertRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SampleDataInsertRunner.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ProductService productService;

	@Autowired
	ProductCategoryService productCategoryService;

	@Override
	public void run(String... args) throws Exception {

//		ResponseEntity<String> re = restTemplate.getForEntity("http://localhost:8080/productcategory/filldb",
//				String.class);
//		logger.debug(re.getBody());

		createSampleProductCategory();
		createSampleProducts();

	}

	public void createSampleProducts() throws ServiceException {

		// Product 1
		Product honey = new Product();
		honey.setProductName("Honey");
		productService.create(honey);

		// Product 2
		Product almond = new Product();
		almond.setProductName("Almond");
		productService.create(almond);

		// Product 3
		Product electricSwitch = new Product();
		electricSwitch.setProductName("Electric Switch");

		ProductCategory productCategory = ProductCategory.builder().categoryName("Electricals")
				.categoryDescription("Electricals and Wires").build();
		List<ProductCategory> categoryList = new ArrayList<>();
		categoryList.add(productCategory);
		electricSwitch.setProductCategory(productCategory);
		productService.create(electricSwitch);

		// Product 4
		Product fiberSwitch = new Product();
		fiberSwitch.setProductName("Fiber Switch");

		ProductCategory productCategory2 = ProductCategory.builder().categoryName("Fibers")
				.categoryDescription("Fibers and Materials").build();
		List<Product> productList = new ArrayList<>();
		productList.add(fiberSwitch);
		productCategory2.setProductList(productList);
		productCategoryService.create(productCategory2);

	}

	public void createSampleProductCategory() throws ServiceException {

		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryName("Electronics");
		productCategory.setCategoryDescription("Electromics Devices and Appliances");
		productCategoryService.create(productCategory);

		ProductCategory productCategory2 = ProductCategory.builder().categoryName("Fruits")
				.categoryDescription("Healthy and Fresh Fruits").build();
		productCategoryService.create(productCategory2);

	}

}
