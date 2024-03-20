package com.neosoft.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.exception.UserFoundException;
import com.neosoft.model.User;
import com.neosoft.model.UserRole;
import com.neosoft.repository.RoleRepository;
import com.neosoft.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=
		this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
		//	System.out.println("user is alreday here");
			throw new UserFoundException();
		}
		else {
			//create user
			for(UserRole ur:userRoles ) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user); 
		}
		return local;
	}

	//geting user by user name
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

}
