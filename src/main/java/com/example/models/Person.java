package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Person")
public class Person {

	@Id
	@GeneratedValue
	@Column
	private int personId;
	
	private String name;
	@Column(unique=true)
	private String email;
	
	private String password;
	
}
