package org.demo.controller;

import org.demo.ApplicationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<String> handleConflict(ApplicationException exception) {

		return ResponseEntity.badRequest()
				.contentType(MediaType.APPLICATION_JSON)
				.body(String.format("{\"error\":\"%s\"}", exception.getMessage()));
		
	}

}
