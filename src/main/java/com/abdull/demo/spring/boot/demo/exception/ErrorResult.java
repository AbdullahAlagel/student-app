package com.abdull.demo.spring.boot.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class ErrorResult {

	private HttpStatus status;
	private String path;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime timestamp;
	private String type;
	private String message;

	
	public ErrorResult(HttpStatus status, String path, String type, String errorMessage) {
		this.status = status;
		this.path = path;
		this.timestamp = LocalDateTime.now();
		this.type = type;
		this.message = errorMessage;
	}
	
}
