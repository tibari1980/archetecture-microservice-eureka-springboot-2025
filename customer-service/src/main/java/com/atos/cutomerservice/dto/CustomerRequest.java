package com.atos.cutomerservice.dto;

import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

	@JsonIgnore
	private Long code;
	@NotBlank(message = "First name is mandatory")
	@Size(min = 3, max = 50, message = "First name  must be between 3 an  50 characters")
	@Pattern(regexp = "^[\\p{L}0-9 ]+$", message = "Doit contenir uniquement lettres (y compris accents), chiffres et espaces")
	private String firstName;
	@NotBlank(message = "Last name is mandatory !!")
	@Size(min = 3, max = 50, message = "Last name must be between  3 and  50 characters")

	@Pattern(regexp = "^[\\p{L}0-9 ]+$", message = "Doit contenir uniquement lettres (y compris accents), chiffres et espaces")
	private String lastName;
	@NotNull(message = "Date of birth is mandatory")
	@Past(message = "Date of birth must be in the past !!")
	private LocalDate dateOfBirth;
	@NotBlank(message = "Address is mandatory !!")
	@Size(min = 10, max = 255, message = "Address must be between 10 and  255 characters!!!")
	private String address;
	@NotBlank(message = "Email is mandatory !!!")
	@Email(message = "Email should be valid !!!!")
	@Size(min = 2, max = 100, message = "Email must be between 2 and  100 characters !!!")
	private String email;
	@NotNull(message = "Age is mandatory")
	@Min(value = 0, message = "Age must be positive !!!")
	@Max(value = 150, message = "Age must be realistic")
	@Column(name = "AGE", nullable = false)
	private Integer age;
	@NotBlank(message = "Phone number is mandatory !!!")
	@Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Numéro invalide (doit respecter E.164, ex: +33625491640)")
	private String phone;


	@JsonIgnore
	private String uid;
	@JsonIgnore

	private Instant createdAt;
	@JsonIgnore
	private Instant updateAt;

}
