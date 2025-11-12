package com.atos.cutomerservice.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atos.cutomerservice.exception.EntityNotFoundException;
import com.atos.cutomerservice.exception.InvalidEntityException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorsDto> handleException(EntityNotFoundException ex, WebRequest web) {
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		ErrorsDto dto = ErrorsDto.builder()
				.codeErros(ex.getCodeErrors())
				.message(ex.getMessage())
				.httpCode(notFound.value()).build();
		return new ResponseEntity<>(dto, notFound);
	}

	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErrorsDto> handleException(InvalidEntityException ex, WebRequest web) {
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ErrorsDto dto = ErrorsDto.builder().codeErros(ex.getCodeErrors()).message(ex.getMessage())
				.httpCode(badRequest.value()).errors(ex.getListErrors()).build();

		return new ResponseEntity<>(dto, badRequest);
	}
}
