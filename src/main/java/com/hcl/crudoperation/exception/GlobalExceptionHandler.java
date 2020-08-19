package com.hcl.crudoperation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(EmployeeNotFoundException employeeNotFoundException,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(employeeNotFoundException.getMessage(),
				HttpStatus.NOT_FOUND.value(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(NullPointerException.class)
//	public ResponseEntity<ErrorResponse> globalExceptionHandler(NullPointerException nullPointerException,
//			WebRequest request) {
//		ErrorResponse errorResponse = new ErrorResponse(nullPointerException.getMessage(), HttpStatus.NOT_FOUND.value(),
//				request.getDescription(false));
//		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	}

}
