package com.neosoft;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.neosoft.exception.UserFoundException;
import com.neosoft.model.Role;
import com.neosoft.model.User;
import com.neosoft.model.UserRole;
import com.neosoft.service.UserService;

@SpringBootApplication
public class FinanceBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FinanceBackendApplication.class, args);
	}

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		try {
//		System.out.println("Strating code");
//		
//		User user=new User();
//     	user.setFirstName("Yogesh");
//    	user.setLastName("Nirmal");
//     	user.setUsername("Yogesh3020");
//     	user.setPassword(this.bCryptPasswordEncoder.encode("Ascii#3020"));
//     	user.setEmail("Yogesh@gmail.com");
//     	
//     	Role role1=new Role();
//     	role1.setRoleId(11L);
//     	role1.setRoleName("ADMIN");
//     	
//     	Set<UserRole> userRoleSet=new HashSet<>();
//     	UserRole userRole=new UserRole();
//     	userRole.setRole(role1);
//     	userRole.setUser(user);
//     	
//     	userRoleSet.add(userRole);
//     	
//     	User user1=this.userService.createUser(user, userRoleSet);
//     	System.out.println(user1.getUsername());
//		
//		}catch(UserFoundException e) {
//			e.printStackTrace();
//		}
//		
	}	

}
