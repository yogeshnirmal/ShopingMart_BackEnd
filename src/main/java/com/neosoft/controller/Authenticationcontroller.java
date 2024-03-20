package com.neosoft.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.config.JwtUtils;
import com.neosoft.model.JwtRequest;
import com.neosoft.model.JwtResponse;
import com.neosoft.model.User;
import com.neosoft.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class Authenticationcontroller {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	//generate token
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Usernot found");
		}
		
	// authenticate
		
		UserDetails userDetails= this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
	String token=this.jwtUtils.generateToken(userDetails);
	return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	private void authenticate(String username,String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		} catch (DisabledException e) {
			throw new Exception("User Desable"+e.getMessage());
		}catch (BadCredentialsException e) {
			throw new Exception("invalid credentials"+e.getMessage());
		}
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal)
	{
		return (User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
}
