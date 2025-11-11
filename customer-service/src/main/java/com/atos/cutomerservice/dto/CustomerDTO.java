package com.atos.cutomerservice.dto;

import java.time.Instant;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class CustomerDTO {

	private Long code;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String address;
	private String email;
	private Integer age;
	private String phone;
	private String uid;
	private Instant createdAt;

	private Instant updateAt;

}
