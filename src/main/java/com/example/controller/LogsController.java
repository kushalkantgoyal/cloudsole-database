package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.LoginService;

@Controller
@RequestMapping("/logs")
public class LogsController {
	
	@Autowired
	LoginService loginService;
	
	public String LogsView(Map<String, Object> map)
	{
		return "logsview";
	}
	
}
