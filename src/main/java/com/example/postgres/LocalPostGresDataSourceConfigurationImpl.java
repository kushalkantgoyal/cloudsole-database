package com.example.postgres;

import java.sql.Driver;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@PropertySource("classpath:/services.properties")
@Configuration
@Profile("default")
public class LocalPostGresDataSourceConfigurationImpl implements LocalPostGresDataSourceConfiguration{

	@Inject
	private Environment environment;
	
	@Override
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setPassword(environment.getProperty("postgres.dataSource.password"));
	    dataSource.setUrl(environment.getProperty("postgres.dataSource.url"));
	    dataSource.setUsername(environment.getProperty("postgres.dataSource.user"));
	    dataSource.setDriverClassName(environment.getPropertyAsClass("postgres.dataSource.driverClass", Driver.class).getName());
	    return dataSource;
	}
}
