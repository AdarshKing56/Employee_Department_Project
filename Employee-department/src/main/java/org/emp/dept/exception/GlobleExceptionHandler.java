package org.emp.dept.exception;

import org.emp.dept.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler {
	ResponseStructure<String> structure=new ResponseStructure<>();

	@ExceptionHandler(LoginInvalidException.class)
	public ResponseEntity<ResponseStructure<String>> handleLIE(LoginInvalidException exception) {
		structure.setMessage(exception.getMessage());
		structure.setData("Invalid Department Login");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidEmployeeException.class)
	public ResponseEntity<ResponseStructure<String>> handleIBE(InvalidEmployeeException exception) {
		structure.setMessage(exception.getMessage());
		structure.setData("Invalid Employee Login");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
