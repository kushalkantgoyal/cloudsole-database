package com.example.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.LoginService;
import com.force.api.QueryResult;

@Controller
@RequestMapping("/apex")
public class ApexController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="create")
	public String createApexClassView(Map<String, Object> map)
	{
		
		return "create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String createApexClass(Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException
	{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		final String type = formData.get("type");
		final String name = formData.get("name");
		final String triggersobject = formData.get("sobject");
		final String triggeroperation = formData.get("operation");

		//final String body = "public class " + name + " {\n\n}";
		
		
		//ApexClass newapexclass = new ApexClass();
		//newapexclass.setName();
		//String id = loginService.LoginToSalesforce().createSObject("ApexClass", newapexclass);
		return "create";
	}
	
	@RequestMapping(value="view")
	public String viewApexClasses(Map<String , Object> map)
	{
		QueryResult<Map> apexClass = loginService.LoginToSalesforce().query("Select Name, ApiVersion, Status from ApexClass");
		QueryResult<Map> apexTrigger = loginService.LoginToSalesforce().query("Select Name, ApiVersion, Status from ApexTrigger");
		QueryResult<Map> apexPage = loginService.LoginToSalesforce().query("Select Name, ApiVersion, Status from ApexPage");
		QueryResult<Map> apexComponent = loginService.LoginToSalesforce().query("Select Name, ApiVersion, Status from ApexComponent");
		
		map.put("apexClass", apexClass.getRecords());
		map.put("apexTrigger", apexTrigger.getRecords());
		map.put("apexPage", apexPage.getRecords());
		map.put("apexComponent", apexComponent.getRecords());
		
		return "view";
	}
	
	@RequestMapping(value="edit")
	public String editApexClass(Map<String, Object> map)
	{
		return "edit";
	}
}
