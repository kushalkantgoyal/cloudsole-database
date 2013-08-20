package com.example.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.example.model.Customer;

public interface CustomerService {
    Customer updateCustomer(long id, String fn, String ln);
    List<Customer> updateCustomers(List<Customer> customersToUpdate);
    Customer getCustomerById(long id);
    Collection<Customer> getAllCustomers();
    Customer createCustomer(String fn, String ln);
    void deleteCustomer(long id);
    Customer createCustomer(Customer newCustomer);
    Customer updateCustomer(long id, Customer updateCustomer);
    List<Customer> bulkCreate(List<Customer> customers);
    List<Customer> findCustomerByQuery(String query);
    void deleteCustomers(List<Customer> customerToDelete);
    List<Customer> getPaginatedCustomer(Integer currentPage, Integer totalPerPage);
    int getTotalRecords();
	List<String> getPaginationSequence();
	void createCustomersFromMap(Map<String, String> mapOfCustomers);
	
}
