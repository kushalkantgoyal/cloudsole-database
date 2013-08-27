package com.example.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.CustomerService;

public class Main {

	public static void main(String[] args) {
		 	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
	        applicationContext.getEnvironment().setActiveProfiles("default");
	        applicationContext.scan(JdbcConfiguration.class.getPackage().getName());
	        applicationContext.refresh();
	        
	        CustomerService customerService = applicationContext.getBean(CustomerService.class);
	        System.out.println(customerService.getCustomerById(new Long(14)));
	}

}
