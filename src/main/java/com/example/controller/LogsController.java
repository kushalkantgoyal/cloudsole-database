package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logs")
public class LogsController {
	
	public String LogsView(Map<String, Object> map)
	{
		return "logsview";
	}
	
}
