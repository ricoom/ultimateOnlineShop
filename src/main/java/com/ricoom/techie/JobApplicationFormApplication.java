package com.ricoom.techie;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricoom.techie.models.User;
import com.ricoom.techie.services.UserService;

@SpringBootApplication
public class JobApplicationFormApplication implements CommandLineRunner {
    @Autowired
	private UserService userservice;
    
	public static void main(String[] args) {
		SpringApplication.run(JobApplicationFormApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userservice.createRole("ROLE_ADMIN");
		userservice.createRole("ROLE_USER");
		
		userservice.UserRegistration(new User(null, "admin", "admin", "ericmwaniki20@gmail.com", new ArrayList<>(),new ArrayList<>()));
		userservice.asignRole("admin", "ROLE_ADMIN");
		
	}

}
