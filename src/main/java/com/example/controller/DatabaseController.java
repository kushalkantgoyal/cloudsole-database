package com.example.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.DatabaseService;

@Controller
@RequestMapping("/db")
public class DatabaseController {

	@RequestMapping("")
	public String showDatabase()
	{
		return "insertdb";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertIntoDatabase(Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException
	{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		String firstName = formData.get("firstName");
		String lastName = formData.get("lastName");
		
		DatabaseService dbservice = new DatabaseService();
    	dbservice.setupJPA();
    	dbservice.getCustomerService();
    	dbservice.createCustomer(firstName, lastName);
		return "insertdb";
	}
}
