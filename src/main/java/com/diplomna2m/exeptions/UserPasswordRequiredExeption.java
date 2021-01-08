package com.diplomna2m.exeptions;

public class UserPasswordRequiredExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserPasswordRequiredExeption(String message ){
		super(message);
	}
}
