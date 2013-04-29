package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController 
{
	@RequestMapping(value="/setup")
	public String setupTest(Map<String, Object> map)
	{
		return "viewtest";
	}
	
	@RequestMapping(value="/run")
	public String runTest(Map<String, Object> map)
	{
		return "runtest";
	}
}
