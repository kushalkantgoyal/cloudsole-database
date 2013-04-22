package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.LoginService;
import com.force.api.QueryResult;

@Controller
@RequestMapping("/apex")
public class ApexController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="create")
	public String createApexClass(Map<String, Object> map)
	{
		
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
