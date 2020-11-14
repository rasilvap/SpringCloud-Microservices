package com.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.app.item.models.Product;

@FeignClient(name = "servicio-products")
public interface ProductClientRest {
	
	@GetMapping("/getAll")
	public List<Product> getAll();
	
	@GetMapping("/get/{id}")
	public Product getByid(@PathVariable Long id);

}
