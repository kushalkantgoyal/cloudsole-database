package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/github")
public class GitHubController {
	
	public String uploadGist(Map<String, Object> map)
	{
		return "githubgist";
	}
	
}
