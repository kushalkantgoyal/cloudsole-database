package com.example.ioc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.jpa.JpaConfiguration;
import com.example.model.Customer;
import com.example.service.CustomerService;

public class IoCMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(JpaConfiguration.class.getPackage().getName());
        applicationContext.refresh();
        
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer createCustomer = (Customer) context.getBean("createCustomer");
		//customerService.createCustomer(createCustomer);
		
		Customer createConstructorCustomer = (Customer) context.getBean("createCustomerFromConstructor");
		//customerService.createCustomer(createConstructorCustomer);
		
		Customer createPropertyCustomer = (Customer) context.getBean("createCustomerProperty");
		//customerService.createCustomer(createPropertyCustomer);
		
		//Customer newCustomerFromJavaConfig = context.getBean("newCustomer", Customer.class);
		//System.out.println(newCustomerFromJavaConfig.getFirstName());
		
		
	}
}
