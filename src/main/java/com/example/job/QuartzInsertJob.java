package com.example.job;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.jpa.JpaConfiguration;
import com.example.model.Customer;
import com.example.service.CustomerService;

public class QuartzInsertJob implements Job  {


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		  List<Customer> createDummyCustomers = new ArrayList<Customer>();
	        for (int k = 0; k < 5; k++){
	        	Customer dummy = new Customer();
	        	dummy.setFirstName("BatchFName"+k);
	        	dummy.setLastName("BatchLName"+k);
	        	createDummyCustomers.add(dummy);
	       }

	        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
	        applicationContext.getEnvironment().setActiveProfiles("default");
	        applicationContext.scan(JpaConfiguration.class.getPackage().getName());
	        applicationContext.refresh();
	        CustomerService customerService = applicationContext.getBean(CustomerService.class);
	        
	        customerService.bulkCreate(createDummyCustomers);
	}
}
