package com.example.beanfactory;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Main {

	public static void main(String[] args) {
		//CustomerImp c = new CustomerImp();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/factory.xml"));
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
		context.registerShutdownHook();
		Customer c = context.getBean("customerWithAccountAutoWired", Customer.class);
		c.customer();
	}
}
