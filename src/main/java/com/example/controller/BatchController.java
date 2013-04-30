package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.LoginService;

@Controller
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/job")
	public String createBulkJobView(Map<String, Object> map)
	{
		map.put("sobjects", loginService.LoginToSalesforce().describeGlobal().getSObjects());
		return "newbatchjob";
	}
	
	public String queryforSelectedsObject(Map<String, Object> map)
	{
		//map.put("sObjectquery", value);
		return "querybatchjob";
	}
	
	@RequestMapping(value="/run", method=RequestMethod.POST)
	public String runBulkJob(Map<String, Object> map)
	{
		return "runbatchjob";
	}

}
