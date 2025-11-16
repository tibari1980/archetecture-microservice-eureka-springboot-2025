package com.atos.cutomerservice.dto;

import java.time.Instant;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomerResponse {

	private Long code;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String address;
	private String email;
	private Integer age;
	private String phone;
	private String uid;
	private Instant createdAt;

	private Instant updateAt;

}
