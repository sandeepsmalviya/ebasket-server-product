package com.ecommerce.catalog.server.repository.h2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.catalog.server.entity.Product;

@Repository
public interface ProductRepositoryH2 extends JpaRepository<Product, Integer> {
	public List<Product> findByProductName(String productName);
}
