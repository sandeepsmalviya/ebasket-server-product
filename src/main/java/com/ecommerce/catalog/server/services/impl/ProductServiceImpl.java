package com.ecommerce.catalog.server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.catalog.server.delegates.ProductRepositoryDelegate;
import com.ecommerce.catalog.server.entity.Product;
import com.ecommerce.catalog.server.exception.ProductNotFoundException;
import com.ecommerce.catalog.server.exception.ServiceException;
import com.ecommerce.catalog.server.services.ProductService;

@Service
@Transactional(rollbackFor = ProductNotFoundException.class)
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepositoryDelegate productRepositoryDelegate;

	public List<Product> findByQuery(String name) {
		return productRepositoryDelegate.findByProductName(name);
	}

	@Override
	public Product findById(int productId) {
		return productRepositoryDelegate.findById(productId);
	}

	@Override
	public List<Product> findAll() throws ServiceException {
		return productRepositoryDelegate.findAll();
	}

	@Override
	public Product create(Product product) throws ServiceException {
		return productRepositoryDelegate.create(product);
	}

	@Override
	public void delete(int productId) throws ProductNotFoundException, ServiceException {
		productRepositoryDelegate.delete(productId);
	}

	@Override
	public Product update(Product product) throws ProductNotFoundException, ServiceException {
		return productRepositoryDelegate.update(product);
	}

	@Override
	public long count() throws ServiceException {

		return productRepositoryDelegate.count();

	}
}
