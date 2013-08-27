package com.example.spring_data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public  class JpaCustomerRepository implements CustomerRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
