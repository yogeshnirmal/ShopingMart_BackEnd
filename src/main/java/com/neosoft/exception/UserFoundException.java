package com.neosoft.exception;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User with this username is alreday in the DB...try another one");
	}
	
	public  UserFoundException(String msg) {super(msg);}
}
