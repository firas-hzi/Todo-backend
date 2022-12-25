package com.example.controllers;

import java.util.LinkedHashMap;
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
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ItemController {
	
	private ItemService itemService;
	
	@PostMapping("/")
	public Item createList(@RequestBody LinkedHashMap<String, String> body) {
		
		return itemService.createItem(body.get("name"), body.get("description"), Double.parseDouble(body.get("price")), Integer.parseInt(body.get("listId")));
	}
	
	@GetMapping("/{listId}")
	public List<Item> getAllItems(@PathVariable Integer listId){
		System.out.println("list id sssssssssss "+listId);
	return itemService.getAllItems(listId);
	}
	
	@DeleteMapping("/{itemId}")
	public void removeItem(@PathVariable Integer itemId){
	 itemService.removeItem(itemId);
	}

}
