package com.ebasket.server.product.services;

import java.util.List;

import com.ebasket.server.product.entity.Product;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.exception.ServiceException;

public interface ProductService {

	public Product findById(int productId) throws ProductNotFoundException, ServiceException;

	public List<Product> findAll() throws ServiceException;

	public Product create(Product product) throws ServiceException;

	public void delete(int productId) throws ProductNotFoundException, ServiceException;

	public Product update(Product product) throws ProductNotFoundException, ServiceException;

	public long count() throws ServiceException, ServiceException;


}
