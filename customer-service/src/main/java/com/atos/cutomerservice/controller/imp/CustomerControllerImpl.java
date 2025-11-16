package com.atos.cutomerservice.controller.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.customerservice.service.CustomerService;
import com.atos.cutomerservice.controller.CustomerController;
import com.atos.cutomerservice.dto.CustomerDTO;
import com.atos.cutomerservice.dto.CustomerRequest;
import com.atos.cutomerservice.dto.CustomerResponse;
import com.atos.cutomerservice.mapper.CustomerMapper;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping(value = "/api/v1/customers")
@Slf4j
@Validated
public class CustomerControllerImpl implements CustomerController {

	@Autowired
	private CustomerService customerService;

	@Override
	public ResponseEntity<List<CustomerResponse>> getAllCustomers(String partialLastNameOrFirstName, int page,
			int limit) {
		log.info(
				"Inside method getAllCustomers in CustomerControllerImpl : PatialLastNameOrµFirstName : {}  , page : {}   , limit  : {} ",
				partialLastNameOrFirstName, page, limit);
		;
		List<CustomerDTO> lstCustomerDTOs = customerService
				.getAllCustomersByFirstNameOrLastNameContaining(partialLastNameOrFirstName, page, limit);
		if (lstCustomerDTOs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		List<CustomerResponse> lstCustomersResponse = lstCustomerDTOs.stream()
				.map(CustomerMapper::mapToCustomerResponse).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(lstCustomersResponse);
	}

	@Override
	public ResponseEntity<CustomerResponse> getCustomerByCode(Long code) {
		log.info("Inside method getCustomerByCode of CustomerControllerImpl  Code : {}", code);

		if (code == null) {
			log.error("Customer Id not valid, code: {}", code);
			return ResponseEntity.badRequest().build(); // HTTP 400
		}

		// Appel service (peut lever EntityNotFoundException, géré par
		// @RestControllerAdvice
		CustomerDTO dto = customerService.findCustomerById(code);
		CustomerResponse response = CustomerMapper.mapToCustomerResponse(dto);

		return ResponseEntity.ok(response); // HTTP 200
	}

	@Override
	public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest cu) {

		log.info("CustomerControllerImp.createCustomer() called with payload : {}  ",cu);
		CustomerDTO dto=customerService.addCustomer(CustomerMapper.mapToCustomerDTO(cu));
		System.out.println("Hello mec");
		
		return null;
	}

}
