package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.service.LoginService;
import com.example.util.ApexUtil;
import com.force.api.QueryResult;
import com.force.sdk.oauth.context.ForceSecurityContextHolder;
import com.example.service.ToolingApi;

@Controller
@RequestMapping("/apex")
public class ApexController {
	
	List<String> operationTypes = Arrays.asList("Before Insert", "After Insert", "Before Update", "After Update", "Before Delete", "After Delete", "Undelete");
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/new")
	public String apexClassView(Map<String, Object> map)
	{
		map.put("classTypes", ApexUtil.classTypes.values());
		map.put("opertationTypes", operationTypes);
		
		//create trigger with template or without.
		//create trigger with or without Handler
		//create visualforce templates
		return "newclass";
	}
	
	
	
	@RequestMapping(value="/new/{apexType}", method=RequestMethod.POST)
	public String createApexClass(@PathVariable("apexType") String apexType, Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException
	{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		final String type = formData.get("type");
		final String name = formData.get("name");
		final String triggersobject = formData.get("sobject");
		final String triggeroperation = formData.get("operation");

		//final String body = "public class " + name + " {\n\n}";
		
		
		//ApexClass newapexclass = new ApexClass();
		//newapexclass.setName();
		//String id = loginService.LoginToSalesforce().createSObject("ApexClass", newapexclass);
		return "newclass";
	}
	
	@RequestMapping(value="/view")
	public String viewApexClasses(Map<String , Object> map)
	{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(false); //create a new session
		
		QueryResult<Map> apexClass = loginService.LoginToSalesforce().query("Select Id, Name, ApiVersion, Status from ApexClass");
		
		session.setAttribute("apexClass", apexClass.getRecords());
		session.setAttribute("apexType", "class");
		
		return "classes";
	}
	
	@RequestMapping(value="/view/{type}", method=RequestMethod.GET)
	public String viewApexTypes(@PathVariable("type") String type, Map<String , Object> map)
	{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(false); //create a new session
		
		if (type.equalsIgnoreCase("class"))
		{
			QueryResult<Map> apexClass = loginService.LoginToSalesforce().query("Select Id, Name, ApiVersion, Status from ApexClass");
			session.setAttribute("apexClass", apexClass.getRecords());
			session.setAttribute("apexType", "class");
		}
		else if (type.equalsIgnoreCase("trigger"))
		{
			QueryResult<Map> apexTrigger = loginService.LoginToSalesforce().query("Select Id, Name, ApiVersion, Status from ApexTrigger");
			session.setAttribute("apexClass", apexTrigger.getRecords());
			session.setAttribute("apexType", "trigger");
		}
		else if (type.equalsIgnoreCase("page"))
		{
			QueryResult<Map> apexPage = loginService.LoginToSalesforce().query("Select Id, Name, ApiVersion from ApexPage");
			session.setAttribute("apexClass", apexPage.getRecords());
			session.setAttribute("apexType", "page");
		}
		else if (type.equalsIgnoreCase("component"))
		{
			QueryResult<Map> apexComponent = loginService.LoginToSalesforce().query("Select Id, Name, ApiVersion from ApexComponent");
			session.setAttribute("apexClass", apexComponent.getRecords());
			session.setAttribute("apexType", "component");
		}
		
		return "classes";
	}
	
	@RequestMapping(value="/view/{type}/{id}", method = RequestMethod.GET)
	public String getClassDetail(@PathVariable("id") String id, Map<String, Object> map) throws ServletException {
		try 
		{	
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession(false); //create a new session
		
			JSONObject apexClassResponse = ToolingApi.get("sobjects/apex" + session.getAttribute("apexType") + "/"
					+ id, ToolingApi.TOOLING_API);
			
			System.out.println(apexClassResponse.toJSONString());
			
			map.put("body", apexClassResponse.get("Body"));
		} catch (IOException e) {
			throw new ServletException(e);
		}

		return "classes";
	}

}
