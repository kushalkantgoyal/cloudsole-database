package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {
	
	public String viewCustomersOnMap(Map<String, Object> map)
	{
		return "showmap";
	}
	
	public String searchCustomerInArea(Map<String, Object> map)
	{
		return "searchmap";
	}
}
