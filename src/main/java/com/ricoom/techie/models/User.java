package com.ricoom.techie.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String username;
	@Size(min = 4)
	private String password;
	@Email
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	private List<Role> roles;
     @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Product> products;
	

	
	
	

}
