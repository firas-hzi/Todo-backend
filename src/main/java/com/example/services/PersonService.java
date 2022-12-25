package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.models.Person;
import com.example.repositories.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class PersonService {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private PersonRepository personRepository;
	
	
	public Person register(Person person) {
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		return personRepository.save(person);
	}
	
	public Person login(String email, String password) {
		Person person = personRepository.findByEmail(email);
		//System.out.println("aaaaaaaaaaaaaaa "+  passwordEncoder.matches(password,person.getPassword()));
		if(!passwordEncoder.matches(password,person.getPassword())) {
			return null;
		}
		else return person;
	}

}
