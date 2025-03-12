package com.spring.validation.exception;

@SuppressWarnings("serial")
public class NotFoundAnyUserException extends Exception {
	public NotFoundAnyUserException(String msg) {
		super(msg);
	}
}
