package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.LoginService;

@Controller
@RequestMapping("/about")
public class AboutController {
	
	public List<String> websiteFeatures()
	{
		List<String> featureList = new ArrayList<String>();
		featureList.add("SOQL Expression generator");
		featureList.add("Easy Apex Code Editor with stub on class creation");
		featureList.add("Run, export and view batch jobs easily");
		featureList.add("Manage all data of your enviroment easily and efficiently");
		featureList.add("Easy integration to 3rd party apis");
		featureList.add("Easy integration to integrations tools");
		featureList.add("Easy to get started and easy to use");
		featureList.add("Extended debugging");
		featureList.add("REST interface to Force.com objects");
		return featureList;
	}
	
	@RequestMapping("")
    public String AboutMe(Map<String, Object> map) 
	{	
		 map.put("websiteFeatures", websiteFeatures());
		 return "about";
    }

}
