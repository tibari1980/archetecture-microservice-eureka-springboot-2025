package com.atos.cutomerservice.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2835900248050983946L;
	
	private CodeErrors codeErrors;

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(String message, Throwable trace) {
		super(message, trace);
	}

	public EntityNotFoundException(String message, Throwable trace, CodeErrors code) {
		super(message, trace);
		this.codeErrors = code;
	}

	public EntityNotFoundException(String message, CodeErrors code) {
		super(message);
		this.codeErrors = code;
	}

}
