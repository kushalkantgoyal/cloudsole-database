package com.example.config;

import javax.sql.DataSource;

/**
 * handles configuring the datasource per environment
 *
 * @author Thys Michels
 */
public interface DataSourceConfiguration {
    DataSource dataSource() throws Exception;
}
