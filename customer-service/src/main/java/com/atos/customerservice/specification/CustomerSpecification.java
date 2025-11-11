package com.atos.customerservice.specification;

import org.springframework.data.jpa.domain.Specification;

import com.atos.cutomerservice.entity.CustomerEntity;

import java.time.LocalDate;

public class CustomerSpecification {

    public static Specification<CustomerEntity> hasFirstName(String firstName) {
        return (root, query, cb) -> firstName == null ? null : cb.like(cb.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<CustomerEntity> hasLastName(String lastName) {
        return (root, query, cb) -> lastName == null ? null : cb.like(cb.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%");
    }

    public static Specification<CustomerEntity> hasEmail(String email) {
        return (root, query, cb) -> email == null ? null : cb.equal(cb.lower(root.get("email")), email.toLowerCase());
    }

    public static Specification<CustomerEntity> hasDateOfBirth(LocalDate dateOfBirth) {
        return (root, query, cb) -> dateOfBirth == null ? null : cb.equal(root.get("dateOfBirth"), dateOfBirth);
    }
}
