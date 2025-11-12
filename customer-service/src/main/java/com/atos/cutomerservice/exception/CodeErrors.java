package com.atos.cutomerservice.exception;

public enum CodeErrors {

	CUSTOMER_NOT_FOUND(1000),
	CUSTOMER_NOT_VALID(1001);

	private int code;

	private CodeErrors(int code) {
		this.code = code;
	}

	int getCode() {
		return this.code;
	}
}
