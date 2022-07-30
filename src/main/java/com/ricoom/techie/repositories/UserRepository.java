package com.ricoom.techie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricoom.techie.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
			User  findUserByusername(String username);
}
