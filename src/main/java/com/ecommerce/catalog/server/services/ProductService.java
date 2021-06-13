package com.ecommerce.catalog.server.services;

import java.util.List;

import com.ecommerce.catalog.server.entity.Product;
import com.ecommerce.catalog.server.exception.ProductNotFoundException;
import com.ecommerce.catalog.server.exception.ServiceException;

public interface ProductService {

	public Product findById(int productId) throws ProductNotFoundException, ServiceException;

	public List<Product> findAll() throws ServiceException;

	public Product create(Product product) throws ServiceException;

	public void delete(int productId) throws ProductNotFoundException, ServiceException;

	public Product update(Product product) throws ProductNotFoundException, ServiceException;

	public long count() throws  ServiceException;


}
