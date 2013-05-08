package com.example.service;
import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.config.JpaConfiguration;

@Service
public class DatabaseService {
		
		private AnnotationConfigApplicationContext applicationContext;
		private CustomerService customerService;
		private Customer customer;
	
		public AnnotationConfigApplicationContext setupJPA()
		{
			applicationContext = new AnnotationConfigApplicationContext();
			applicationContext.getEnvironment().setActiveProfiles("default");
			applicationContext.scan(JpaConfiguration.class.getPackage().getName());
			applicationContext.refresh();
			return applicationContext;
		}

		Log log = LogFactory.getLog(DatabaseService.class);

		public CustomerService getCustomerService()
		{
			customerService = applicationContext.getBean(CustomerService.class);
			return customerService;
		}
			
		public Customer createCustomer(String name, String lastname)
		{
			customer = customerService.createCustomer(name, lastname);
			log.info(String.format("updated customer's firstName: %s", customer.getFirstName()));
			return customer;
		}

		public void findCustomerById(Customer existingCustomer)
		{
			Customer retrievedCustomer = customerService.getCustomerById(existingCustomer.getId());
			log.info(String.format("updated customer's firstName: %s", retrievedCustomer.getFirstName()));
		}
        
		public void updateCustomer(Customer existingCustomer)
		{
			Customer updatedCustomer = customerService.updateCustomer(existingCustomer.getId(), "Poes", "Klap");
			log.info(String.format("updated customer's firstName: %s", updatedCustomer.getFirstName()));
		}
  
}
