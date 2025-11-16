package com.atos.cutomerservice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.cutomerservice.dto.CustomerRequest;
import com.atos.cutomerservice.dto.CustomerResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public interface CustomerController {

	// http://localhost:8082/api/v1/customers/all?partialLnOrFn=tiba
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerResponse>> getAllCustomers(
			@RequestParam(name = "partialLnOrFn", required = false, defaultValue = "") String partialLastNameOrFirstName,
			@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "10") final int limit);

	// localhost:8082/api/v1/customers/findByCode/2 (200) OK
	// localhost:8082/api/v1/customers/findByCode/100 (404) ressource not found
	// localhost:8082/api/v1/customers/findByCode/100/alber/lyna:lunu (4040)
	// endpoint not found
	@GetMapping(value = "/findByCode/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponse> getCustomerByCode(
			@PathVariable @Positive(message = "Customer  ID must be greater than zero") Long code);

	
	// http://localhost:8082/api/v1/customers/
		@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest customerRequest);
}
