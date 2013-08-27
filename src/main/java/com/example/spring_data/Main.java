package com.example.spring_data;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.model.Customer;

public class Main {
	
	public static void main(String[] args) {
		 	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
	        applicationContext.getEnvironment().setActiveProfiles("default");
	        applicationContext.scan(JpaCustomerConfiguration.class.getPackage().getName());
	        applicationContext.refresh();

	        CustomerCRUDRepository cr = applicationContext.getBean(CustomerCRUDRepository.class);
	        System.out.println(cr.count());
	        //cr.delete(new Long(224));
	        Customer newCustomer = new Customer("DataJpaFName", "DataJpaLName");
	        cr.save(newCustomer);
	        System.out.println(cr.findAll());
	        System.out.println(cr.exists(new Long(224)));
	        System.out.println(cr.findOne(new Long(14)));
	}
}
