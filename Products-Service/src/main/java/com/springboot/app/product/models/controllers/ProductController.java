package com.springboot.app.product.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.product.models.entity.Product;
import com.springboot.app.product.models.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productsService;
	
	@GetMapping("/getAll")
	public List<Product> getAll(){
		return productsService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Product getByid(@PathVariable Long id) {
		return productsService.findById(id);
	}
}
