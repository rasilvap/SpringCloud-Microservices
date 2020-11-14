package com.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.app.item.clientes.ProductClientRest;
import com.springboot.app.item.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductClientRest productClientRest;

	@Override
	public List<Item> findAll() {		
		return productClientRest.getAll().stream().map(p-> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(productClientRest.getByid(id), quantity);
	}

}
