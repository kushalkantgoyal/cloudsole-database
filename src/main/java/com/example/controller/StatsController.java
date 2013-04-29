package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
public class StatsController {
	
	//run dynamic stats in line and donut chart
	
	@RequestMapping(value="")
	public String returnStatsView(Map<String, Object> map)
	{
		
		return "stats";
	}

}
