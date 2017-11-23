package com.learn.hateoas.springhateos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javassist.NotFoundException;

public class AbstractController<T> {

	@ExceptionHandler(value=NotFoundException.class)
	public ResponseEntity<T> notFoundHandler(NotFoundException ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<T> internalErrorHandler(Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<T>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
