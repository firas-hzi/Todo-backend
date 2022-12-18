package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Item;
import com.example.models.Lists;
import com.example.repositories.ItemRepository;
import com.example.repositories.ListRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ItemService {
	
private ItemRepository itemRepository;
private ListRepository listRepository;	

	public Item createItem(String name, String description, Double price, Integer listId) {
		Lists list = listRepository.findById(listId).get();
		Item item = new Item();
		item.setDescription(description);
		item.setName(name);
		item.setPrice(price);
		item.setList(list);
		return itemRepository.save(item);
	}

	public List<Item> getAllItems(Integer listId) {
		System.out.println("inside itemservice listId "+listId);
		Lists list =  listRepository.findById(listId).get();
		
		
		return itemRepository.findAllByList(list);
	}

	public void removeItem(Integer itemId) {
		
		Item item =itemRepository.findById(itemId).get();
		  itemRepository.delete(item);
		
	}

}
