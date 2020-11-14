package com.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.service.ItemService;

@RestController
@Qualifier("ItemServiceFeign")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("getItems")
	public List<Item> getItems(){
		return itemService.findAll();
	}
	
	
	@GetMapping("getById/{id}/quantity/{quantity}")
	public Item details(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
	}

}
