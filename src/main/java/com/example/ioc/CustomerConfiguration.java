package com.example.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.Customer;

@Configuration
public class CustomerConfiguration {

		@Bean(name="newCustomer")
		public Customer newCustomer(){
			Customer newCustomer = new Customer();
			newCustomer.setFirstName("ConfigFName");
			newCustomer.setLastName("ConfigLName");
			return newCustomer;
		}
}
