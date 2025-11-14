package com.atos.cutomerservice.entity;

import java.time.Instant;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMERS", uniqueConstraints = { @UniqueConstraint(columnNames = "EMAIL") })

public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
	@Column(name = "CODE", nullable = false)
	private Long code;
	@NotBlank(message = "First name is mandatory")
	@Size(min = 3, max = 50, message = "First name  must be between 3 an  50 characters")
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	//@NotBlank(message = "Last name is mandatory !!")
	@Size(min = 3, max = 50, message = "Last name must be between  3 and  50 characters")
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@NotNull(message = "Date of birth is mandatory")
	@Past(message = "Date of birth must be in the past !!")
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private Date dateOfBirth;
	@NotBlank(message = "Address is mandatory !!")
	@Size(min = 10, max = 255, message = "Address must be between 10 and  255 characters!!!")
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	@NotBlank(message = "Email is mandatory !!!")
	@Email(message = "Email should be valid !!!!")
	@Size(min = 2, max = 100, message = "Email must be between 2 and  100 characters !!!")
	@Column(name = "EMAIL", nullable = false,unique = true)
	private String email;
	@NotNull(message = "Age is mandatory")
	@Min(value = 0, message = "Age must be positive !!!")
	@Max(value = 150, message = "Age must be realistic")
	@Column(name = "AGE", nullable = false)
	private Integer age;
	@NotBlank(message = "Phone number is mandatory !!!")
	@Pattern(regexp = "\\+?[0-9]{7,15}", message = "Phone number must be valid")

	@Column(name = "PHONE", nullable = false)
	private String phone;
	@Column(name = "UID")
	private String uid;
	@CreationTimestamp
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	private Instant createdAt;
	@UpdateTimestamp
	@Column(name = "UPDATED_AT")
	private Instant updateAt;



}
