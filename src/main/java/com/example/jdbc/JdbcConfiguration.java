package com.example.jdbc;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.service.DataSourceConfiguration;
import com.example.service.LocalDataSourceConfiguration;

@Configuration
@PropertySource("classpath:/services.properties")
@EnableTransactionManagement
@Import( { LocalDataSourceConfiguration.class })
public class JdbcConfiguration {
	
	  @Inject private DataSourceConfiguration dataSourceConfiguration;

	  @Inject private Environment environment;
	  
	  @Bean
	  public JdbcTemplate setupJdbcTemplate() throws Exception {
		  JdbcTemplate jdbcTemplateSetup = new JdbcTemplate(dataSourceConfiguration.dataSource());
		  return jdbcTemplateSetup;
	  }
	 
}
