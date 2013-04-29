package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.LoginService;

@Controller
@RequestMapping("/bulk")
public class BulkController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/new")
	public String createBulkJobView(Map<String, Object> map)
	{
		map.put("sobjects", loginService.LoginToSalesforce().describeGlobal().getSObjects());
		return "newbulkjob";
	}
	
	public String queryforSelectedsObject(Map<String, Object> map)
	{
		//map.put("sObjectquery", value);
		return "newbulkJob";
	}
	
	@RequestMapping(value="/run", method=RequestMethod.POST)
	public String runBulkJob(Map<String, Object> map)
	{
		return "runbulkjob";
	}

}
