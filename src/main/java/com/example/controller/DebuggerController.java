package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/debug")
public class DebuggerController {
	
	//setup debugger table
	//setup debugger rest endpoint
	//setup debugger issue viewer
	
	
	@RequestMapping(value="/view")
	public String viewDebugger(Map<String, Object> map)
	{
		return "viewdebugger";
	}
	

}
