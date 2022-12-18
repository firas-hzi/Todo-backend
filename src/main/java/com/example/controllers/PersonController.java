package com.example.controllers;

import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Person;
import com.example.services.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/persons")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class PersonController {
	
	private PersonService personService;

	@PostMapping("/register")
	public Person register(@RequestBody Person person) {
		return personService.register(person);
	}
	
	@PostMapping("/login")
	public Person login(@RequestBody LinkedHashMap<String,String> body) {
		System.out.println("inside login person constoller");
		return personService.login(body.get("email"), body.get("password"));
	}
}
