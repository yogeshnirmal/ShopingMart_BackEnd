package com.neosoft.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.neosoft.model.Role;
import com.neosoft.model.User;
import com.neosoft.model.UserRole;
import com.neosoft.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		//encoding pasword with bCryptPasswordEncoder
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles= new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(12L);
		role.setRoleName("NORMAL");
	
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping("/updateProduct/{id}")
	public User updateUser(@RequestBody User user ,@PathVariable  long userId) {
		user.setId(userId); //calling data
		User ur=userService.update(user);
		return ur;
	}
}
