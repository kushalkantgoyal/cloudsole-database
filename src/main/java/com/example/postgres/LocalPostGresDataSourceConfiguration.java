package com.example.postgres;

import javax.sql.DataSource;

public interface LocalPostGresDataSourceConfiguration {
	DataSource dataSource();
}
