package com.ihub.model;

import org.springframework.stereotype.Component;

@Component
public class MovieNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public MovieNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public MovieNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
