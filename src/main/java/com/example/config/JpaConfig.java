package com.example.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpaConfig {
	
	public AnnotationConfigApplicationContext setupJPA()
	{
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("default");
		applicationContext.scan(JpaConfiguration.class.getPackage().getName());
		applicationContext.refresh();
		return applicationContext;
	}
}
