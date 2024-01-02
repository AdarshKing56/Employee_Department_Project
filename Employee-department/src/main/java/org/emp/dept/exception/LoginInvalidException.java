package org.emp.dept.exception;

public class LoginInvalidException extends RuntimeException {
	public LoginInvalidException(String message) {
		super(message);
	}
}
