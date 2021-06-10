package com.ebasket.server.product.services.impl.h2;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebasket.server.product.entity.Product;
import com.ebasket.server.product.exception.ProductNotFoundException;
import com.ebasket.server.product.repository.ProductRepository;
import com.ebasket.server.product.services.ProductService;

@Service
@Transactional
public class ProductServiceImplH2 implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void createSampleProducts() {

		Product honey = new Product();
		honey.setProductName("Honey");
		productRepository.save(honey);

		Product almond = new Product();
		almond.setProductName("Almond");
		productRepository.save(almond);

	}

	@Override
	public Product findById(int productId) throws ProductNotFoundException {

		try {

		} catch (NoSuchElementException exception) {
			throw new ProductNotFoundException("Product with id = " + productId + " not found", exception);
		} catch (Exception exception) {
			throw exception;
		}
		return productRepository.findById(productId).get();
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();

	}

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(int productId) throws ProductNotFoundException {
		productRepository.deleteById(productId);

	}

	@Override
	public Product update(Product product) throws ProductNotFoundException {
		return productRepository.saveAndFlush(product);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

}
