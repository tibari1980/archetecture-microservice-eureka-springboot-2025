package com.atos.cutomerservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Handle specific exception Customer Not found exception
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorsDetails> handleCustomerNotFound(CustomerNotFoundException ex, WebRequest webRequest) {

		ErrorsDetails errorDetails = new ErrorsDetails(LocalDateTime.now(), ex.getMessage(),
				webRequest.getDescription(false), "CUSTOMER_NOT_FOUND");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// Hanle a generic exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorsDetails> handleGenericException(Exception ex, WebRequest webRequest) {
		ErrorsDetails errorsDetails = new ErrorsDetails(LocalDateTime.now(), ex.getMessage(),
				webRequest.getDescription(false), "INTERNAL_SERVER_ERROR");

		return new ResponseEntity<>(errorsDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
