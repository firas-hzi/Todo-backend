package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.models.Person;
import com.example.repositories.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class PersonService {

	private PersonRepository personRepository;
	
	
	public Person register(Person person) {
		
		return personRepository.save(person);
	}
	
	public Person login(String email, String password) {
		Person person = personRepository.findByEmail(email);
		
		if(!person.getPassword().equals(password)) {
			return null;
		}
		else return person;
	}

}
