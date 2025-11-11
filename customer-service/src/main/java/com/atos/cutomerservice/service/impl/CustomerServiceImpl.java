package com.atos.cutomerservice.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atos.customerservice.service.CustomerService;
import com.atos.cutomerservice.dto.CustomerDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO addCustomer(CustomerDTO customerDTO) {
         
		return null;
	}

	@Override
	public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO) {
		  
		return null;
	}

	@Override
	public void deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<CustomerDTO> findCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Page<CustomerDTO> findAllCustomers(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerDTO> searchCustomers(String firstName, String lastName, String email, LocalDate dateOfBirth,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
