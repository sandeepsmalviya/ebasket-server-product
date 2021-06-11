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
import com.ebasket.server.product.entity.ProductCategory;
import com.ebasket.server.product.exception.ProductCategoryNotFoundException;
import com.ebasket.server.product.exception.ServiceException;
import com.ebasket.server.product.repository.ProductCategoryRepository;
import com.ebasket.server.product.services.ProductCategoryService;

@Service
@Transactional(rollbackFor = ProductCategoryNotFoundException.class)
public class ProductCategoryServiceImplH2 implements ProductCategoryService {

	private static final Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImplH2.class);

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Override
	public ProductCategory findById(int productCategoryId) throws ProductCategoryNotFoundException, ServiceException {

		try {
			return productCategoryRepository.findById(productCategoryId).get();
		} catch (NoSuchElementException exception) {
			throw new ProductCategoryNotFoundException("ProductCategory with id = " + productCategoryId + " not found", exception);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public List<ProductCategory> findAll() throws ServiceException {

		try {
			return productCategoryRepository.findAll();
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public ProductCategory create(ProductCategory productCategory) throws ServiceException {

		try {
			return productCategoryRepository.save(productCategory);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public void delete(int productCategoryId) throws ProductCategoryNotFoundException, ServiceException {

		try {
			productCategoryRepository.deleteById(productCategoryId);
		} catch (NoSuchElementException elementException) {
			throw new ProductCategoryNotFoundException("ProductCategory with id = " + productCategoryId + " not found, cant' delete",
					elementException);
		} catch (EmptyResultDataAccessException elementException) {
			throw new ProductCategoryNotFoundException(
					"ProductCategory with id = " + productCategoryId + " not found, and its empty, cant' delete", elementException);
		} catch (Exception exception) {
			logger.error("My Error = " + exception.toString());
			throw new ServiceException(exception);
		}
	}

	@Override
	public ProductCategory update(ProductCategory productCategory) throws ProductCategoryNotFoundException, ServiceException {

		try {
			return productCategoryRepository.saveAndFlush(productCategory);
		} catch (NoSuchElementException elementException) {
			throw new ProductCategoryNotFoundException("ProductCategory with id = " + productCategory + " not found, cant' update",
					elementException);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}

	@Override
	public long count() throws ServiceException {

		try {
			return productCategoryRepository.count();
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}
}
