package com.atos.cutomerservice.mapper;

import com.atos.cutomerservice.dto.CustomerDTO;
import com.atos.cutomerservice.dto.CustomerRequest;
import com.atos.cutomerservice.dto.CustomerResponse;
import com.atos.cutomerservice.entity.CustomerEntity;

public class CustomerMapper {

	public static CustomerDTO mapToCustomerDTO(CustomerEntity e) {

		return CustomerDTO.builder().code(e.getCode()).lastName(e.getLastName()).firstName(e.getFirstName())
				.email(e.getEmail()).address(e.getAddress()).phone(e.getPhone()).createdAt(e.getCreatedAt())
				.updateAt(e.getUpdateAt()).dateOfBirth(e.getDateOfBirth()).build();
	}

	public static CustomerResponse mapToCustomerResponse(CustomerDTO e) {

		return CustomerResponse.builder().code(e.getCode()).lastName(e.getLastName()).firstName(e.getFirstName())
				.email(e.getEmail()).address(e.getAddress()).phone(e.getPhone()).createdAt(e.getCreatedAt())
				.updateAt(e.getUpdateAt()).dateOfBirth(e.getDateOfBirth()).build();
	}

	public static CustomerDTO mapCustomerRequestToCustomerDto(CustomerRequest e) {
		return CustomerDTO.builder().code(e.getCode()).lastName(e.getLastName()).firstName(e.getFirstName())
				.email(e.getEmail()).address(e.getAddress()).phone(e.getPhone()).createdAt(e.getCreatedAt())
				.updateAt(e.getUpdateAt()).dateOfBirth(e.getDateOfBirth()).build();
	}
}
