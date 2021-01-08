package com.diplomna2m.exeptions;

public class ExistingUserEmailExeption extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	public ExistingUserEmailExeption (String message) {
		super(message);
	}

}
