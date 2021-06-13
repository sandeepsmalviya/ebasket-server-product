package com.ecommerce.catalog.server.services;

import java.util.List;

import com.ecommerce.catalog.server.entity.ProductImage;
import com.ecommerce.catalog.server.exception.ProductImageNotFoundException;
import com.ecommerce.catalog.server.exception.ServiceException;

public interface ProductImageService {

	public ProductImage findById(int imageId) throws ProductImageNotFoundException, ServiceException;

	public List<ProductImage> findAll() throws ServiceException;

	public ProductImage create(ProductImage productImage) throws ServiceException;

	public void delete(int imageId) throws ProductImageNotFoundException, ServiceException;

	public ProductImage update(ProductImage productImage) throws ProductImageNotFoundException, ServiceException;

	public long count() throws ServiceException;

}
