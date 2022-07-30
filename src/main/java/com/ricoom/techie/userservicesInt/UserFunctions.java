package com.ricoom.techie.userservicesInt;

import com.ricoom.techie.models.User;

public interface UserFunctions {
	
	public User UserRegistration(User user);
	public void asignRole(String username, String role);
	public void createRole(String rolename);

}
