package com.spring.validation.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends Exception {
	public IdNotFoundException(String msg) {
		super(msg);
	}
}
