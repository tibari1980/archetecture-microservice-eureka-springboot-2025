package com.atos.cutomerservice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.cutomerservice.dto.CustomerResponse;

import jakarta.validation.constraints.Positive;

public interface CustomerController {

	// http://localhost:8082/api/v1/customers/all?partialLnOrFn=tiba
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerResponse>> getAllCustomers(
			@RequestParam(name = "partialLnOrFn", required = false, defaultValue = "") String partialLastNameOrFirstName,
			@RequestParam(name = "page", defaultValue = "0") final int page,
			@RequestParam(name = "limit", defaultValue = "10") final int limit);



          
	@GetMapping(value="/findByCode/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponse> getCustomerByCode(@PathVariable( "code") 
	@Positive(message = "Customer  ID must be greater than zero") Long code);
}
