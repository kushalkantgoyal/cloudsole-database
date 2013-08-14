package com.example.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/hibernateContext.xml");
		HibernateDaoImpl hibernatedao = ctx.getBean("HibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println(hibernatedao.getCustomerCount());
	}

}
