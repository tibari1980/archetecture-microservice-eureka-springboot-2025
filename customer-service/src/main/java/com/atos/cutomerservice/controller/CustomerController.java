package com.atos.cutomerservice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.cutomerservice.dto.CustomerResponse;

public interface CustomerController {

	// http://localhost:8082/api/v1/customers/all?partialLastNameOrFirstName=tiba
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerResponse>> getAllCustomers(
			@RequestParam(name = "partialLastNameOrFirstName", required = false, defaultValue = "") String partialLastNameOrFirstName,
			@RequestParam(name = "page", defaultValue = "0") final int page,
			@RequestParam(name = "limit", defaultValue = "10") final int limit);

}
