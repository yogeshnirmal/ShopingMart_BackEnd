package com.neosoft.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	
	private String authority;
	

//
//	public Authority(String roleName) {
//		// TODO Auto-generated constructor stub
//	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}


	public Authority(String authority) {
		super();
		this.authority = authority;
	}
	

}
