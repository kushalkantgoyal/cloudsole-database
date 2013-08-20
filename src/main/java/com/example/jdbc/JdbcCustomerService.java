package com.example.jdbc;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Customer;
import com.example.service.CustomerService;

@Repository
@Qualifier("jdbcRepository")
@Transactional(readOnly = true)
public class JdbcCustomerService implements CustomerService{

	@Override
	public Customer updateCustomer(long id, String fn, String ln) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> updateCustomers(List<Customer> customersToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomer(String fn, String ln) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer createCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(long id, Customer updateCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> bulkCreate(List<Customer> customers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findCustomerByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomers(List<Customer> customerToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getPaginatedCustomer(Integer currentPage,
			Integer totalPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getPaginationSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomersFromMap(Map<String, String> mapOfCustomers) {
		// TODO Auto-generated method stub
		
	}

}
