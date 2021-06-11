package com.ebasket.server.product.services;

import java.util.List;

import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ProductCategoryNotFoundException;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.exception.ServiceException;

public interface ProductCategoryService {

	public ProductCategory findById(int productId) throws ProductCategoryNotFoundException, ServiceException;

	public List<ProductCategory> findAll() throws ServiceException;

	public ProductCategory create(ProductCategory productCategory) throws ServiceException;

	public void delete(int productId) throws ProductCategoryNotFoundException, ServiceException;

	public ProductCategory update(ProductCategory productCategory)
			throws ProductCategoryNotFoundException, ServiceException;

	public long count() throws ServiceException;

	
}
