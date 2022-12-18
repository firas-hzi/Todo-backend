package com.example.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Lists;
import com.example.models.Person;
import com.example.repositories.ListRepository;
import com.example.repositories.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ListService {

	private ListRepository listRepository;
	private PersonRepository personRepository;
	
	public Lists createList(Lists list) {
		list.setCreateDate(LocalDateTime.now());
		
		return listRepository.save(list);
	}

	public List<Lists> getAllList(Integer personId) {
		Person person = personRepository.findById(personId).get();
	
		return listRepository.findAllByPerson(person);
	}

}
