package com.example.spring_data;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.model.Customer;

@EnableJpaRepositories
public interface CustomerCRUDRepository extends CrudRepository<Customer, Long>, QueryDslPredicateExecutor<Customer>{

}
