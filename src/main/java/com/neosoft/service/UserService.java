package com.neosoft.service;

import java.util.Set;

import com.neosoft.model.User;
import com.neosoft.model.UserRole;

public interface UserService {

	public User  createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	public User getUser(String usernmae);
	
	public void deleteUser(long userId);

	public User update(User user);
}
