package org.emp.dept.exception;

public class InvalidEmployeeException extends RuntimeException {
	public InvalidEmployeeException(String message) {
		super(message);
	}
}
