package com.openclassrooms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	private String mail;
	
	private String password;
}
