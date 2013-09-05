package com.example.postgres;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(LocalPostGresDataSourceConfiguration.class.getPackage().getName());
        applicationContext.refresh();
        
        LocalPostGresDataSourceConfiguration newDataSource =applicationContext.getBean(LocalPostGresDataSourceConfiguration.class); 
        System.out.println(newDataSource.dataSource().getConnection().isClosed());
	}

}
