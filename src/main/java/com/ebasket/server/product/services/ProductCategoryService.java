package com.ebasket.server.product.services;

import java.util.List;

import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ProductCategoryNotFoundException;
import com.ebasket.server.product.exception.ProductNotFoundException;

public interface ProductCategoryService {

	public ProductCategory findById(int productId) throws ProductCategoryNotFoundException;

	public List<ProductCategory> findAll();

	public ProductCategory create(ProductCategory productCategory);

	public void delete(int productId) throws ProductNotFoundException;

	public ProductCategory update(ProductCategory productCategory) throws ProductCategoryNotFoundException;

	public long count();

	public void createSampleProductCategory();

}
