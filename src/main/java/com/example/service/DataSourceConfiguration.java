package com.example.service;

import javax.sql.DataSource;

public interface DataSourceConfiguration {
    DataSource dataSource() throws Exception;
}
