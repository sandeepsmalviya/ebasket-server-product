package com.ecommerce.catalog.server.delegates;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ecommerce.catalog.server.entity.Product;
import com.ecommerce.catalog.server.exception.ProductNotFoundException;
import com.ecommerce.catalog.server.exception.ServiceException;
import com.ecommerce.catalog.server.repository.h2.ProductRepositoryH2;
import com.ecommerce.catalog.server.repository.mongo.ProductRepositoryMongo;

@Service
public class ProductRepositoryDelegate {

	@Autowired
	ProductRepositoryH2 productRepositoryH2;
	
	@Autowired
	ProductRepositoryMongo productRepositoryMongo;

	public Product findById(int productId) {

		try {
			
			return productRepositoryH2.findById(productId).get();
		} catch (NoSuchElementException exception) {
			throw new ProductNotFoundException("Product with id = " + productId + " not found", exception);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}

	}

	public List<Product> findByProductNameJPA(String productName) {

		List<Product> list = new ArrayList<>();
		List<Product> products = productRepositoryH2.findByProductName(productName);		
		return list;
	}
	
	
	public List<Product> findByProductName(String productName) {

		List<Product> list = new ArrayList<>();
		List<Product> products = productRepositoryH2.findAll();
		for (Product product : products) {
			if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
				list.add(product);
			}
		}
		return list;
	}

	public List<Product> findAll() throws ServiceException {

		try {
			return productRepositoryH2.findAll();
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	public Product create(Product product) throws ServiceException {

		try {
			return productRepositoryH2.save(product);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	public void delete(int productId) throws ProductNotFoundException, ServiceException {

		try {
			productRepositoryH2.deleteById(productId);
		} catch (NoSuchElementException elementException) {
			throw new ProductNotFoundException("Product with id = " + productId + " not found, cant' delete",
					elementException);
		} catch (EmptyResultDataAccessException elementException) {
			throw new ProductNotFoundException(
					"Product with id = " + productId + " not found, and its empty, cant' delete", elementException);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	public Product update(Product product) throws ProductNotFoundException, ServiceException {

		try {
			return productRepositoryH2.saveAndFlush(product);
		} catch (NoSuchElementException elementException) {
			throw new ProductNotFoundException("Product with id = " + product + " not found, cant' update",
					elementException);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	public long count() throws ServiceException {

		try {
			return productRepositoryH2.count();
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

}
