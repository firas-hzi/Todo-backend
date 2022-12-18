package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Item;
import com.example.models.Lists;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	List<Item> findAllByList(Lists list);

}
