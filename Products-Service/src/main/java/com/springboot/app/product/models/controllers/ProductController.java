package com.springboot.app.product.models.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.product.models.entity.Product;
import com.springboot.app.product.models.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductService productsService;
	
	@GetMapping("/getAll")
	public List<Product> getAll(){
		return productsService.findAll().stream().map(product->{
			product.setPort(port);
			return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/get/{id}")
	public Product getByid(@PathVariable Long id) {
		Product product = productsService.findById(id);
		product.setPort(port);
		return productsService.findById(id);
	}
}
