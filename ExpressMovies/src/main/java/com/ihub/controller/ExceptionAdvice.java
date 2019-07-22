package com.ihub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ihub.model.MovieNotFoundException;
import com.ihub.model.DirectorNotFoundException;
import com.ihub.model.ExceptionResponse;

@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ExceptionResponse> mapException(MovieNotFoundException e)
	{
		ExceptionResponse ex1=new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		return new ResponseEntity<ExceptionResponse>(ex1, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(DirectorNotFoundException.class)
	public ResponseEntity<ExceptionResponse> directorException(DirectorNotFoundException d)
	{
		ExceptionResponse ex2=new ExceptionResponse(HttpStatus.NOT_FOUND.value(), d.getMessage());
		return new ResponseEntity<ExceptionResponse>(ex2, HttpStatus.NOT_FOUND);
	}

}
