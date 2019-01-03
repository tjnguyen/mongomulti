package com.example.demo.exception;



public class DataAccessException extends RuntimeException
{
	
	public DataAccessException(String message)
	{
	   super(message);
	}

	
	public DataAccessException(String message, Throwable t)
	{
	   super(message, t);
	}

}
