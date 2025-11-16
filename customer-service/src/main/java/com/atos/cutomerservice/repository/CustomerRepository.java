package com.atos.cutomerservice.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.cutomerservice.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	
	 Page<CustomerEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
	            String firstNamePart, 
	            String lastNamePart, 
	            Pageable pageable
	    );
      //search customer by id
	Optional<CustomerEntity> findByCode(final Long code);
	
} 
