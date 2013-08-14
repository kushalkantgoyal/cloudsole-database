package com.example.service;

import java.util.Collection;
import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
    Customer updateCustomer(long id, String fn, String ln);
    Customer getCustomerById(long id);
    Collection<Customer> getAllCustomers();
    Customer createCustomer(String fn, String ln);
    void deleteCustomer(long id);
    Customer createCustomer(Customer newCustomer);
    Customer updateCustomer(long id, Customer updateCustomer);
    List<Customer> bulkCreate(List<Customer> customers);
}
