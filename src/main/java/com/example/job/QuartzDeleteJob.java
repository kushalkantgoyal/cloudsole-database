package com.example.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.jpa.JpaConfiguration;
import com.example.model.Customer;
import com.example.service.CustomerService;

public class QuartzDeleteJob implements Job  {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		  
	        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
	        applicationContext.getEnvironment().setActiveProfiles("default");
	        applicationContext.scan(JpaConfiguration.class.getPackage().getName());
	        applicationContext.refresh();
	        CustomerService customerService = applicationContext.getBean(CustomerService.class);
	        
	        List<Customer> listOfCustomersToDelete = customerService.getPaginatedCustomer(0, 2);
	        customerService.deleteCustomers(listOfCustomersToDelete);
	}
}
