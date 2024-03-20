package com.neosoft.exception;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException() {
		super("Username not found in db");
	}
	
	public  UserNotFoundException(String msg) {super(msg);}
}


