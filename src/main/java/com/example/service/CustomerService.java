package com.example.service;


import com.example.model.Customer;

public interface CustomerService {
    Customer updateCustomer(long id, String fn, String ln);

    Customer getCustomerById(long id);

    Customer createCustomer(String fn, String ln);
}
