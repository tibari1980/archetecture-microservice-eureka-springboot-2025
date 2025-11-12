package com.atos.cutomerservice.exception;

import java.util.List;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private CodeErrors codeErrors;
	@Getter
	private List<String> listErrors;

	public InvalidEntityException(String message) {
		super(message);
	}

	public InvalidEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEntityException(String message, Throwable cause, CodeErrors code) {
		super(message, cause);
		this.codeErrors = code;
	}

	public InvalidEntityException(String message, Throwable cause, CodeErrors code, List<String> errors) {
		super(message, cause);
		this.codeErrors = code;
		this.listErrors = errors;
	}

}
