package com.ecommerce.catalog.server.services;

import java.util.List;

import com.ecommerce.catalog.server.entity.ProductCategory;
import com.ecommerce.catalog.server.exception.ProductCategoryNotFoundException;
import com.ecommerce.catalog.server.exception.ProductNotFoundException;
import com.ecommerce.catalog.server.exception.ServiceException;

public interface ProductCategoryService {

	public ProductCategory findById(int productId) throws ProductCategoryNotFoundException, ServiceException;

	public List<ProductCategory> findAll() throws ServiceException;

	public ProductCategory create(ProductCategory productCategory) throws ServiceException;

	public void delete(int productId) throws ProductCategoryNotFoundException, ServiceException;

	public ProductCategory update(ProductCategory productCategory)
			throws ProductCategoryNotFoundException, ServiceException;

	public long count() throws ServiceException;

	
}
