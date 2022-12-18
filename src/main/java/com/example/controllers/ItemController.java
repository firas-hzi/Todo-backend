package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Item;
import com.example.services.ItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/items")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ItemController {
	
	private ItemService itemService;
	
	@PostMapping("/")
	public Item createList(@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	@GetMapping("/{listId}")
	public List<Item> getAllItems(@PathVariable Integer listId){
	return itemService.getAllItems(listId);
	}
	
	@DeleteMapping("/{itemId}")
	public Integer removeItem(@PathVariable Integer itemId){
	return itemService.removeItem(itemId);
	}

}
