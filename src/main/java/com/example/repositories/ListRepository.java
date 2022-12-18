package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.models.Person;
import com.example.models.Lists;

@Repository
public interface ListRepository extends JpaRepository<Lists, Integer> {

	
	List<Lists> findAllByPerson(Person person);
}
