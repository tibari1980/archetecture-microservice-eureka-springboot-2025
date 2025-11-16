package com.atos.cutomerservice.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atos.cutomerservice.exception.CodeErrors;
import com.atos.cutomerservice.exception.EntityNotFoundException;
import com.atos.cutomerservice.exception.InvalidEntityException;
import com.atos.cutomerservice.utils.UtilsApp;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorsDto> handleException(EntityNotFoundException ex, WebRequest web) {
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		ErrorsDto dto = ErrorsDto.builder()
				.codeErros(ex.getCodeErrors())
				.message(ex.getMessage())
				.httpCode(notFound.value())
				.dateException(UtilsApp.nowFormatted())
				.build();
		return new ResponseEntity<>(dto, notFound);
	}

	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErrorsDto> handleException(InvalidEntityException ex, WebRequest web) {
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ErrorsDto dto = ErrorsDto.builder()
				.codeErros(ex.getCodeErrors())
				.message(ex.getMessage())
				.httpCode(badRequest.value())
				.errors(ex.getListErrors())
				.dateException(UtilsApp.nowFormatted())
				.build();

		return new ResponseEntity<>(dto, badRequest);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String, Object>> handleExceptionTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest webRequest) {
		Map<String, Object> body = new HashMap<>();
		String paramName = ex.getName();
		String requiredType = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "inconnu";
		body.put("error", "Le paramétre `" + paramName + "` doit être de type  " + requiredType + " .");
		body.put("Invalide Value ", ex.getValue());	
		body.put("status code ", 400);
		body.put("Date et heure ", UtilsApp.nowFormatted());
		return ResponseEntity.badRequest().body(body);
	}

	@Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Endpoint not found");
        body.put("path", ex.getRequestURL());
        body.put("Date et heure " , UtilsApp.nowFormatted());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	 

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	        MethodArgumentNotValidException ex,
	        HttpHeaders headers,
	        HttpStatusCode status,
	        WebRequest request) {

	    List<String> errors = ex.getBindingResult()
	                            .getAllErrors()
	                            .stream()
	                            .map(error -> {
	                                if (error instanceof FieldError fieldError) {
	                                    return fieldError.getField() + " : " + fieldError.getDefaultMessage();
	                                } else {
	                                    return error.getDefaultMessage();
	                                }
	                            })
	                            .collect(Collectors.toList());

	    ErrorsDto dto = ErrorsDto.builder()
	            .codeErros(CodeErrors.CUSTOMER_NOT_VALID)
	            .message("Invalide data !!!")
	            .errors(errors)
	            .httpCode(HttpStatus.BAD_REQUEST.value())
	            .dateException(UtilsApp.nowFormatted())
	            .build();

	    return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
	}

	
}
