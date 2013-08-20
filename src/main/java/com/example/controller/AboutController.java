package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/about")
public class AboutController {
	
	public List<String> websiteFeatures()
	{
		List<String> featureList = new ArrayList<String>();
		featureList.add("CRUD Operations Database");
		featureList.add("Easy Find");
		featureList.add("Query from Web");
		featureList.add("Run Quartz Job");
		featureList.add("Dashboard");
		featureList.add("Solr Search");
		featureList.add("Pagination");
		featureList.add("Upload CSV");
		featureList.add("CSV Generator");
		featureList.add("PDF Generator");
		featureList.add("Atom Feed");
		featureList.add("RSS Feed");
		
		return featureList;
	}
	
	@RequestMapping("")
    public String AboutThisProject(Map<String, Object> map) 
	{	
		 map.put("websiteFeatures", websiteFeatures());
		 return "about";
    }

}
