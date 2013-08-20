package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.CustomerService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	@Qualifier("jpaRepository")
	CustomerService customerService;
	
	@RequestMapping("")
	public String showDashboard(Map<String, Object> map){
		map.put("totalAmountOfCustomers", customerService.getTotalRecords());
		return "dashboard";
	}
}
