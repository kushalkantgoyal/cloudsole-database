package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@RequestMapping(value="/new")
	public String createNewMail(Map<String, Object> map){
		return "newmail";
	}
	
	@RequestMapping(value="")
	public String viewMail(Map<String, Object> map){
		return "mailbox";
	}

}
