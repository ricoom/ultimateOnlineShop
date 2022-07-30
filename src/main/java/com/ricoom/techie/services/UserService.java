package com.ricoom.techie.services;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ricoom.techie.models.Role;
import com.ricoom.techie.models.User;
import com.ricoom.techie.repositories.RoleRepository;
import com.ricoom.techie.repositories.UserRepository;
import com.ricoom.techie.userservicesInt.UserFunctions;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService, UserFunctions  {
   private UserRepository userrepository;
   private RoleRepository rolerepository;
   
   
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userrepository.findUserByusername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
	
		return new MyUserdetails(user) ;
	}

	@Override
	public User UserRegistration(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRoles(Arrays.asList(new Role(null, "ROLE_USER")));
		
		return userrepository.save(user);
	}

	
	
	@Override
	public void createRole(String rolename) {
		Role role=rolerepository.findRoleByroleName(rolename);
		if(role==null) {
			rolerepository.save(new Role(null, rolename));
		}else {
		 throw new RuntimeException("role exists");
		}
		
	}
	
	@Override
	public void asignRole(String username, String rolename) {
		Role role=rolerepository.findRoleByroleName(rolename);
		User user=userrepository.findUserByusername(username);
		
		user.getRoles().add(role);
		
	}

	
	
	

}
