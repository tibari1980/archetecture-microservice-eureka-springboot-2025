package com.atos.cutomerservice.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.customerservice.service.CustomerService;
import com.atos.cutomerservice.dto.CustomerDTO;
import com.atos.cutomerservice.entity.CustomerEntity;
import com.atos.cutomerservice.exception.CodeErrors;
import com.atos.cutomerservice.exception.EntityNotFoundException;
import com.atos.cutomerservice.mapper.CustomerMapper;
import com.atos.cutomerservice.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

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
	public CustomerDTO findCustomerById(Long customerId) {
		log.info("Inside getCustomerById of CustomerServiceImpl, Customer Code: {}", customerId);

		// Récupération sécurisée du client
		CustomerEntity customerEntity = customerRepository.findByCode(customerId)
				.orElseThrow(() -> new EntityNotFoundException(
						"Customer with id `" + customerId + "` not found in our database",
						CodeErrors.CUSTOMER_NOT_FOUND));

		log.info("Customer found with id: {}, customer: {}", customerId, customerEntity);
		// Conversion Entity -> DTO
		return CustomerMapper.mapToCustomerDTO(customerEntity);
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

	@Override
	public List<CustomerDTO> getAllCustomersByFirstNameOrLastNameContaining(String partialLastNameOrFirstName, int page,
			int limit) {

		log.info(
				"Inside method GetAllCustomersByFirstNameOrLastNameContaining of CustomerServiceImpl   partialLastNameOrFirstName : {} ,  page : {} , limit : {}",
				partialLastNameOrFirstName, page, limit);

		page = (page > 0) ? page + 1 : page;
		Pageable pageable = PageRequest.of(page, limit, Sort.by("code").ascending());
		Page<CustomerEntity> pageCustomers = customerRepository
				.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(partialLastNameOrFirstName,
						partialLastNameOrFirstName, pageable);
		List<CustomerEntity> lstCutomers = pageCustomers.getContent();
		List<CustomerDTO> lstCustomerDtos = lstCutomers.stream().map(CustomerMapper::mapToCustomerDTO)
				.collect(Collectors.toList());

		log.info("Customers find successfully   size : {}", lstCustomerDtos.size());
		return lstCustomerDtos;
	}

}
