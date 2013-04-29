package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/metadata")
public class MetadataController {
	
	@RequestMapping(value="/view")
	public String viewMetadata(Map<String, Object> map)
	{
		return "viewmetadata";
	}
	
	@RequestMapping(value="/download")
	public String downloadMetadata(Map<String, Object> map)
	{
		return "viewmetadata";
	}

}
