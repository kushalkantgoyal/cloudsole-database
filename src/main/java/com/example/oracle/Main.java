package com.example.oracle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(LocalOracleDataSourceConfiguration.class.getPackage().getName());
        applicationContext.refresh();
        
        LocalOracleDataSourceConfiguration newDataSource =applicationContext.getBean(LocalOracleDataSourceConfiguration.class); 
	}

}
