package com.example.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.model.Customer;
import com.example.config.JpaConfiguration;

public class DatabaseService {
	public static void main(String args[]) throws Throwable {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(JpaConfiguration.class.getPackage().getName());
        applicationContext.refresh();

        Log log = LogFactory.getLog(DatabaseService.class);

        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        Customer customer = customerService.createCustomer("Jpa", "Lover");

        Customer retrievedCustomer = customerService.getCustomerById(customer.getId());

        log.info(String.format("customer.id (%s) == retreivedCustomer.id (%s)?  %s",
                customer.getId(), retrievedCustomer.getId(), customer.getId().equals(retrievedCustomer.getId())));

        Customer updatedCustomer = customerService.updateCustomer(customer.getId(), "JPA", "Lover");
        log.info(String.format("updated customer's firstName: %s", updatedCustomer.getFirstName()));

    }
}
