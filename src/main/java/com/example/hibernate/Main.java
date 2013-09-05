package com.example.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.CustomerService;


public class Main {
	public static void main(String[] args) {
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/hibernateContext.xml");
		HibernateDaoImpl hibernatedao = ctx.getBean("HibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println(hibernatedao.getCustomerCount());*/
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(HibernateConfiguration.class.getPackage().getName());
        applicationContext.refresh();
        
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        //System.out.println(customerService.getAllCustomers());
        //System.out.println(customerService.getCustomerById(new Long(14)));
        System.out.println(customerService.createCustomer("HibernateFName", "HibernateLName"));
        //customerService.deleteCustomer(new Long(226));
        customerService.updateCustomer(new Long(225), "PName", "PLastName");
	}

}
