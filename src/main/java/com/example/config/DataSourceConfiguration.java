package com.example.config;

import javax.sql.DataSource;

public interface DataSourceConfiguration {
    DataSource dataSource() throws Exception;
}
