package com.example.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Item")
public class Item {
	
	@Id
	@GeneratedValue
	private int itemId;
	
	private String name;
	
	private String description;
	
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "listId")
	private Lists list;

}
