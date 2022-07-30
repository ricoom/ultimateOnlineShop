package com.ricoom.techie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricoom.techie.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
			Role findRoleByroleName(String rolename);
}
