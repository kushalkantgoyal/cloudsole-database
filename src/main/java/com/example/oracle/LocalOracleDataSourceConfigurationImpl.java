package com.example.oracle;

import java.sql.Driver;

import javax.inject.Inject;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@PropertySource("classpath:/services.properties")
@Configuration
@Profile("default")
public class LocalOracleDataSourceConfigurationImpl implements LocalOracleDataSourceConfiguration{

	@Inject
	private Environment environment;
	
	@Override
	public OracleDataSource dataSource() throws Exception {
		 OracleDataSource dataSource = new OracleDataSource();
	     dataSource.setPassword(environment.getProperty("oracle.dataSource.password"));
	     dataSource.setURL(environment.getProperty("oracle.dataSource.url"));
	     dataSource.setUser(environment.getProperty("oracle.dataSource.username"));
	     dataSource.setDriverType(environment.getPropertyAsClass("oracle.dataSource.driverClass", Driver.class).getName());
		return dataSource;
	}

}
