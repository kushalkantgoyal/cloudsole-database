package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
    Customer updateCustomer(long id, String fn, String ln);
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers(String query);
    Customer createCustomer(String fn, String ln);
}
