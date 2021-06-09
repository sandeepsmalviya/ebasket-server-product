package com.ebasket.server.product.services.impl.h2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ProductCategoryNotFoundException;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.repository.ProductCategoryRepository;
import com.ebasket.server.product.services.ProductCategoryService;

@Service
public class ProductCategoryServiceImplH2 implements ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Override
	public void createSampleProductCategory() {

		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryName("Electronics");
		productCategory.setCategoryDescription("Electromics Devices and Appliances");
		productCategoryRepository.saveAndFlush(productCategory);

		ProductCategory productCategory2 = ProductCategory.builder().categoryName("Fruits")
				.categoryDescription("Healthy and Fresh Fruits").build();
		productCategoryRepository.saveAndFlush(productCategory2);

	}

	@Override
	public ProductCategory findById(int categoryId) throws ProductCategoryNotFoundException {
		return productCategoryRepository.findById(categoryId).get();
	}

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();

	}

	@Override
	public ProductCategory create(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	@Override
	public void delete(int categoryId) throws ProductNotFoundException {
		productCategoryRepository.deleteById(categoryId);

	}

	@Override
	public ProductCategory update(ProductCategory productCategory) throws ProductCategoryNotFoundException {
		return productCategoryRepository.saveAndFlush(productCategory);
	}

	@Override
	public long count() {
		return productCategoryRepository.count();
	}

}
