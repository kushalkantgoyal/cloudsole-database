package com.example.oracle;

import javax.sql.DataSource;

public interface LocalOracleDataSourceConfiguration {
	 DataSource dataSource() throws Exception;
}
