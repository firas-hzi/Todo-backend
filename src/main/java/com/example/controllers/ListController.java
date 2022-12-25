package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.models.Lists;
import com.example.services.ListService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/lists")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ListController {
	
	private ListService listService;
	
	
	@PostMapping("/")
	public Lists createList(@RequestBody Lists list) {
		return listService.createList(list);
	}
	
	@GetMapping("/{personId}")
	public List<Lists> getAllList(@PathVariable Integer personId){
	return listService.getAllList(personId);
	}
}
