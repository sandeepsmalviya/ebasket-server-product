package com.ebasket.server.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebasket.server.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
