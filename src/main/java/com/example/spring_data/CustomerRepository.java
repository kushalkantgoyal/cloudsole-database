package com.example.spring_data;

import org.springframework.data.repository.Repository;

import com.example.model.Customer;

public interface CustomerRepository extends Repository<Customer, Long> {
	Customer findOne(Long id);
	Customer findByLastName(String lastName);
	Customer findByFirstName(String firstName);
	Customer findById(Long id);
}
