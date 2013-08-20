package com.example.hibernate;

import java.util.Properties;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.service.DataSourceConfiguration;
import com.example.service.LocalDataSourceConfiguration;

@Configuration
@PropertySource("classpath:/services.properties")
@EnableTransactionManagement
@Import( { LocalDataSourceConfiguration.class })
public class HibernateConfiguration {
	
	 @Inject private DataSourceConfiguration dataSourceConfiguration;

	 @Inject private Environment environment;
	 
	 @Bean
	 public LocalSessionFactoryBean setupSessionFactory() throws Exception {
		  LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
		  localSessionFactory.setDataSource(dataSourceConfiguration.dataSource());
		  localSessionFactory.setPackagesToScan("com.example.model");
		  Properties hibernateProperties = new Properties();
		  hibernateProperties.setProperty("dialect", environment.getProperty("dataSource.dialect"));
		  localSessionFactory.setHibernateProperties(hibernateProperties);
		  return localSessionFactory;
	  }

}
