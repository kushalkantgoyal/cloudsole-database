package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping(value="/view")
	public String fileView(Map<String, Object> map)
	{
		return "viewfiles";
	}
}
