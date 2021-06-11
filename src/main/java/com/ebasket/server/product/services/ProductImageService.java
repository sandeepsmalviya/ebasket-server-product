package com.ebasket.server.product.services;

import java.util.List;

import com.ebasket.server.product.entity.ProductImage;
import com.ebasket.server.product.exception.ProductImageNotFoundException;
import com.ebasket.server.product.exception.ServiceException;

public interface ProductImageService {

	public ProductImage findById(int imageId) throws ProductImageNotFoundException, ServiceException;

	public List<ProductImage> findAll() throws ServiceException;

	public ProductImage create(ProductImage productImage) throws ServiceException;

	public void delete(int imageId) throws ProductImageNotFoundException, ServiceException;

	public ProductImage update(ProductImage productImage) throws ProductImageNotFoundException, ServiceException;

	public long count() throws ServiceException;

}
