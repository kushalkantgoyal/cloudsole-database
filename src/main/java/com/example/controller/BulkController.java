package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bulk")
public class BulkController {
	
	public String createBulkJob(Map<String, Object> map)
	{
		
		return "createbulkjob";
	}

}
