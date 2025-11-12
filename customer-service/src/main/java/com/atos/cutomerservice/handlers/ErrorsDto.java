package com.atos.cutomerservice.handlers;

import java.util.List;

import com.atos.cutomerservice.exception.CodeErrors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorsDto {

	private Integer httpCode;
	private CodeErrors codeErros;
	private String message;
	private List<String> errors;
}
