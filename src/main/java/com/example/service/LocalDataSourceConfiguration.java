package com.example.service;

import java.sql.Driver;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.example.service.DataSourceConfiguration;

@PropertySource("classpath:/services.properties")
@Configuration
@Profile("default")
public class LocalDataSourceConfiguration implements DataSourceConfiguration {


    @Inject
    private Environment environment;

    @Bean
    public DataSource dataSource() throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setPassword(environment.getProperty("dataSource.password"));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.user"));
        dataSource.setDriverClassName(environment.getPropertyAsClass("dataSource.driverClass", Driver.class).getName());
        return dataSource;
    }
}