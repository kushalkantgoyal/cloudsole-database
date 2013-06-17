package com.example.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.LoginService;
import com.example.service.ToolingApi;

@Controller
@RequestMapping("/logs")
public class LogsController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="")
	public String LogsView(Map<String, Object> map)
	{
		map.put("logs", loginService.LoginToSalesforce().query("SELECT Id, StartTime FROM ApexLog ORDER BY StartTime"));
		return "logs";
	}
	
	@RequestMapping("/{id}")
	public String getLogDetail(@PathVariable("id") String id,
			Map<String, Object> map) throws ServletException {
		try {
			String body = ToolingApi.getFile(id);
			map.put("body", body);
		} catch (IOException e) {
			throw new ServletException(e);
		}

		return "logDetail";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String deleteApexLog(@PathVariable("id") String id,
			Map<String, Object> map) throws ServletException {
		try {
			ToolingApi.delete("sobjects/ApexLog/" + id);
		} catch (IOException e) {
			throw new ServletException(e);
		}

		return "OK";
	}
	
}
