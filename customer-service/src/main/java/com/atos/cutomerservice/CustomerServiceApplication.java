package com.atos.cutomerservice;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atos.cutomerservice.entity.CustomerEntity;
import com.atos.cutomerservice.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		
		return args->{
			
			for(int i=1 ;i<50;i++) {
				CustomerEntity entity=CustomerEntity.builder()
						.firstName("Custimer tibari "+i)
						.lastName("Customer Last Name"+i)
						.age (50)
						.dateOfBirth(Date.from(LocalDate.of(1990, 5, 20).atStartOfDay(ZoneId.systemDefault()).toInstant()))
						.createdAt(Instant.now())
						.updateAt(Instant.now())
                        .phone("+33625491640")
                        .email("tibarinewdzign"+i+"@gmail.com")
                        .address(i+"1 place des alpes 78008 Paris ")
                        .uid(UUID.randomUUID().toString())
							
						.build();
				customerRepository.save(entity);
				System.out.println("Customer is : "+entity.toString());
			}
		};
	}
}
