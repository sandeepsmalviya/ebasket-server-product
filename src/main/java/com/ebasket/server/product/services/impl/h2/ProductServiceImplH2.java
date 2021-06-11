package com.ebasket.server.product.services.impl.h2;

import java.util.List;
import java.util.NoSuchElementException;

//import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebasket.server.product.entity.Product;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.exception.ServiceException;
import com.ebasket.server.product.repository.ProductRepository;
import com.ebasket.server.product.services.ProductService;

@Service
@Transactional(rollbackFor = ProductNotFoundException.class)
//@Transactional
public class ProductServiceImplH2 implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImplH2.class);

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product findById(int productId) throws ProductNotFoundException, ServiceException {

		try {
			return productRepository.findById(productId).get();
		} catch (NoSuchElementException exception) {
			throw new ProductNotFoundException("Product with id = " + productId + " not found", exception);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public List<Product> findAll() throws ServiceException {

		try {
			return productRepository.findAll();
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public Product create(Product product) throws ServiceException {

		try {
			return productRepository.save(product);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public void delete(int productId) throws ProductNotFoundException, ServiceException {

		try {
			productRepository.deleteById(productId);
		} catch (NoSuchElementException elementException) {
			throw new ProductNotFoundException("Product with id = " + productId + " not found, cant' delete",
					elementException);
		} catch (EmptyResultDataAccessException elementException) {
			throw new ProductNotFoundException(
					"Product with id = " + productId + " not found, and its empty, cant' delete", elementException);
		} catch (Exception exception) {
			logger.error("My Error = " + exception.toString());
			throw new ServiceException(exception);
		}
	}

	@Override
	public Product update(Product product) throws ProductNotFoundException, ServiceException {

		try {
			return productRepository.saveAndFlush(product);
		} catch (NoSuchElementException elementException) {
			throw new ProductNotFoundException("Product with id = " + product + " not found, cant' update",
					elementException);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public long count() throws ServiceException {

		try {
			return productRepository.count();
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}
}
