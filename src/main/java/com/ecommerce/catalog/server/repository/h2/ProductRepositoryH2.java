package com.ecommerce.catalog.server.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.catalog.server.entity.Product;

@Repository
public interface ProductRepositoryH2 extends JpaRepository<Product, Integer> {

}
