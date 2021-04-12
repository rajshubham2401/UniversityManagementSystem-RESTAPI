package com.restapi.universitymanagement.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String exceptionMsg)
	{
		super(exceptionMsg);
	}
	
}
