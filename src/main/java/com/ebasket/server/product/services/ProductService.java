package com.ebasket.server.product.services;

import java.util.List;

import com.ebasket.server.product.entity.Product;
import com.ebasket.server.product.exception.ProductNotFoundException;

public interface ProductService {

	public Product findById(int productId) throws ProductNotFoundException;

	public List<Product> findAll();

	public Product create(Product product);

	public void delete(int productId) throws ProductNotFoundException;

	public Product update(Product product) throws ProductNotFoundException;

	public long count();

	public void createSampleProducts();

}
