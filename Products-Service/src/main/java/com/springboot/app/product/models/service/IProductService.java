package com.springboot.app.product.models.service;

import java.util.List;

import com.springboot.app.product.models.entity.Product;

public interface IProductService {
	
	public List<Product> findAll();
	public Product findById(Long id);
}
