package com.ricoom.techie.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ricoom.techie.models.User;

public class MyUserdetails implements UserDetails {
	
	private User user;
	
	private List<SimpleGrantedAuthority> authorities;
	
	
	

	public MyUserdetails(User user) {
		
		this.user = user;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		authorities=new ArrayList<>();
		user.getRoles().forEach(role->authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
