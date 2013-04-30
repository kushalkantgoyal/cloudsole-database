package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/github")
public class GitHubController {
	
	public String newGist(Map<String, Object> map)
	{
		return "githubgist";
	}
	
	public String viewGist(Map<String, Object> map)
	{
		return "viewgists";
	}
	
	
}
