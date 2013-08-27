package com.example.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(LocalDataSourceConfiguration.class.getPackage().getName());
        applicationContext.refresh();
        
        DataSource newDataSource =applicationContext.getBean(DataSource.class);
       
        System.out.println("Hier: " + newDataSource.getConnection().isClosed());
        newDataSource.getConnection().close();
        
	}

}
