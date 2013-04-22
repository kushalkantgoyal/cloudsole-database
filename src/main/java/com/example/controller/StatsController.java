package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
public class StatsController {
	
	@RequestMapping(value="")
	public String returnStatsView(Map<String, Object> map)
	{
		
		return "stats";
	}

}
