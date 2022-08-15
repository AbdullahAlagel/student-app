package com.abdull.demo.spring.boot.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResult> handleStudentNotFoundException(StudentNotFoundException ex,
			WebRequest request) {
		String error = ex.getMessage();
		return buildResponseEntity(request, HttpStatus.BAD_REQUEST, "Error_1000", error);
	}
	
	private ResponseEntity<ErrorResult> buildResponseEntity(WebRequest request, HttpStatus status, String type,
			String errorMessage) {
		String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		ErrorResult error = new ErrorResult(status, path, type, errorMessage);
		return new ResponseEntity<ErrorResult>(error, status);
	}
	
}
