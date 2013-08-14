package com.example.jdbc;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.JdbcDoaImpl;
import com.example.model.Customer;

public class Main {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(JdbcDoaImpl.class.getPackage().getName());
        applicationContext.refresh();*/
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/jdbcContext.xml");
		JdbcDoaImpl jdbcdao = ctx.getBean("JdbcDaoImpl", JdbcDoaImpl.class);
		
       // JdbcDoaImpl jdbcdao = applicationContext.getBean(JdbcDoaImpl.class);
		//Customer customer = jdbcdao.getCustomer(14);
		//System.out.println(customer.getFirstName());
		//System.out.println(jdbcdao.getCustomerCount());
		//System.out.println(jdbcdao.getCustomerFName(14));
		//System.out.println(jdbcdao.getCustomerForId(14));
		//System.out.println(jdbcdao.getAllCustomers().size());
		
		jdbcdao.insertCustomerNP(new Customer("sd", "asd"));
		//jdbcdao.createLeadTable();
		
	}
}
