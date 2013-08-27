package com.example.hibernate;

import java.util.Properties;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.config.DataSourceConfiguration;
import com.example.config.LocalDataSourceConfiguration;

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
	 
	  @Bean
	  public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception {
		  return new DataSourceTransactionManager(dataSource);
	  }
}
