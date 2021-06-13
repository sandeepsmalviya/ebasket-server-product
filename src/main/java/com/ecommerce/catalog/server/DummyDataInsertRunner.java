package com.ecommerce.catalog.server;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.catalog.server.entity.Product;
import com.ecommerce.catalog.server.entity.ProductCategory;
import com.ecommerce.catalog.server.entity.ProductImage;
import com.ecommerce.catalog.server.exception.ServiceException;
import com.ecommerce.catalog.server.services.ProductCategoryService;
import com.ecommerce.catalog.server.services.ProductService;

@Component
public class DummyDataInsertRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DummyDataInsertRunner.class);

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
		createSampleProducts1();
		createSampleProducts2();
		
		createSampleProducts3();
		createSampleProducts4();

	}

	public void createSampleProducts1() throws ServiceException {

		// Product 1
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setCategoryName("detached category");

		ProductImage productImage1 = new ProductImage();
		productImage1.setImageName("testImage.jpg");
		productImage1.setImageDescription("Thumbnail image");

		Product honey = new Product();
		honey.setProductName("Honey");
		honey.setProductCategory(productCategory1);
		honey.setProductImage(productImage1);
		productService.create(honey);

	}

	public void createSampleProducts2() throws ServiceException {

		// Product 1
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setCategoryName("detached category2");

		ProductImage productImage1 = new ProductImage();
		productImage1.setImageName("testImage2.jpg");
		productImage1.setImageDescription("Thumbnail image2");

		Product almond = new Product();
		almond.setProductName("Almond");
		almond.setProductCategory(productCategory1);
		almond.setProductImage(productImage1);
		productService.create(almond);

	}

	public void createSampleProducts3() throws ServiceException {
		// Product 3
		Product electricSwitch = new Product();
		electricSwitch.setProductName("Electric Switch");

		ProductCategory productCategory = ProductCategory.builder().categoryName("Electricals")
				.categoryDescription("Electricals and Wires").build();
		List<ProductCategory> categoryList = new ArrayList<>();
		categoryList.add(productCategory);

		ProductImage productImage3 = new ProductImage();
		productImage3.setImageName("testImage3.jpg");
		productImage3.setImageDescription("Thumbnail image3");

		electricSwitch.setProductCategory(productCategory);
		electricSwitch.setProductImage(productImage3);
		productService.create(electricSwitch);


	}
	public void createSampleProducts4() throws ServiceException {

			// Product 4
		Product fiberSwitch = new Product();
		fiberSwitch.setProductName("Fiber Switch");
		
		
		ProductImage productImage3 = new ProductImage();
		productImage3.setImageName("testImage4.jpg");
		productImage3.setImageDescription("Thumbnail image4");
		
		fiberSwitch.setProductImage(productImage3);

		ProductCategory productCategory2 = ProductCategory.builder().categoryName("Fibers")
				.categoryDescription("Fibers and Materials").build();
		List<Product> productList = new ArrayList<>();
		productList.add(fiberSwitch);
	//	productCategory2.setProductList(productList);
		
		fiberSwitch.setProductCategory(productCategory2);
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
