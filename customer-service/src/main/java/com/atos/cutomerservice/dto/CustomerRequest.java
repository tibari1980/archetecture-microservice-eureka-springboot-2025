package com.atos.cutomerservice.dto;

import java.time.Instant;
import java.util.Date;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

	@Transient
	private Long code;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String address;
	private String email;
	private Integer age;
	private String phone;
	private String uid;
	
	@Transient
	private Instant createdAt;
    @Transient
	private Instant updateAt;

}
