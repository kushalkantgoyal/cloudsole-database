package com.example.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dbconf")
public class DatabaseConfigController {

	@Inject
	DataSource dataSource;
	
	@RequestMapping("")
	public String showDataBaseDetails(Map<String, Object> map) throws SQLException{
		map.put("connectionStatus", dataSource.getConnection().isClosed());
		//map.put("clientInfo", dataSource.getConnection().getClientInfo());
		//map.put("warnings", dataSource.getConnection().getWarnings());
		//map.put("metadata", dataSource.getConnection().getMetaData().getDriverName());
		//map.put("url", dataSource.getConnection().getMetaData().getURL());
		//map.put("username", dataSource.getConnection().getMetaData().getUserName());
		
		return "dbconf";
	}

}
