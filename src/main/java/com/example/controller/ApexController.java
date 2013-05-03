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
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.service.ToolingApi;

@Controller
@RequestMapping("/apex")
public class ApexController {
	private static final Logger logger = LoggerFactory.getLogger(ApexController.class);

	List<String> operationTypes = Arrays.asList("Before Insert", "After Insert", "Before Update", "After Update", "Before Delete", "After Delete", "Undelete");
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/new")
	public String apexClassView(Map<String, Object> map)
	{
		map.put("classTypes", ApexUtil.classTypes.values());
		map.put("opertationTypes", operationTypes);
		return "newclass";
	}
	
	@RequestMapping(value="/new/{apexType}", method=RequestMethod.POST)
	public String createApexClass(@PathVariable("apexType") String apexType, Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException
	{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		
		List<String> operationsList = new ArrayList<String>();
	
		Boolean createhandler = false;
		
		if (apexType.equalsIgnoreCase("trigger"))
		{
			if (formData.get("before_insert") != null)
				operationsList.add("before insert");
			if (formData.get("after_insert") != null)
				operationsList.add("after insert");
			if (formData.get("before_update")!="null")
				operationsList.add("before update");
			if (formData.get("after_update") != null)
				operationsList.add("after update");
			if (formData.get("before_delete") != null)
				operationsList.add("before delete");
			if (formData.get("after_delete") != null)
				operationsList.add("after delete");
			if (formData.get("undelete") != null)
				operationsList.add("after undelete");

			if (formData.get("handler") != null)
			{
				createhandler=true;
			}
			
			final String triggername = formData.get("triggername");
			final String sobjectselected = formData.get("sobjectselected");
			
			JSONObject apexTriggerRequest = new JSONObject();
			apexTriggerRequest.put("Name", triggername);
			apexTriggerRequest.put("Body", ApexUtil.triggerStub(triggername, sobjectselected, operationsList, createhandler));
			JSONObject apexTriggerResponse = ToolingApi.post("sobjects/ApexTrigger", apexTriggerRequest);
			
			System.out.println(ApexUtil.triggerStub(triggername, sobjectselected, operationsList, createhandler));
				
			/*if (createhandler)
			{
				JSONObject apexClassRequest = new JSONObject();
				apexClassRequest.put("Name", triggername);
				apexClassRequest.put("Body", ApexUtil.triggerHandler(triggername, sobjectselected, operationsList));
				JSONObject apexClassResponse = ToolingApi.post("sobjects/ApexClass", apexClassRequest);
				
				//System.out.println(ApexUtil.triggerHandler(triggername, sobjectselected, operationsList));
			}
			*/
			return "classes";
		}
		else if (apexType.equalsIgnoreCase("class"))
		{
			final String className = formData.get("className");
			final String classTypeSelected = formData.get("classTypeSelected");
			
			JSONObject apexClassRequest = new JSONObject();
			apexClassRequest.put("Name", className);
			apexClassRequest.put("Body", ApexUtil.classStub(className, classTypeSelected));
			JSONObject apexClassResponse = ToolingApi.post("sobjects/ApexClass", apexClassRequest);
	
			System.out.println(classTypeSelected);
		}
		else if (apexType.equalsIgnoreCase("visualforce"))
		{
			
		}

		else if (apexType.equalsIgnoreCase("component"))
		{
		
		}
		return null;
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
			session.setAttribute("currentId", id);
			
			JSONObject apexClassResponse = ToolingApi.get("sobjects/apex" + session.getAttribute("apexType") + "/"
					+ id, ToolingApi.TOOLING_API);
		
			if (session.getAttribute("apexType").equals("page") || session.getAttribute("apexType").equals("component"))
			{
				map.put("body", apexClassResponse.get("Markup"));
			}
			else
			{	
				map.put("body", apexClassResponse.get("Body"));
			}
		} catch (IOException e) {
			throw new ServletException(e);
		}

		return "classes";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST, value = "/save/{type}/{id}")
	public String updateClassDetail(
			@PathVariable("id") String id, 
			@PathVariable("type") String type,
			HttpServletRequest request, Map<String, Object> map)
			throws IOException {
		
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		String body = formData.get("body");

		try {
			
			JSONObject metadataContainerRequest = new JSONObject();
			
			logger.info("metadataRequest: " + metadataContainerRequest);
			
			metadataContainerRequest.put("Name", "Save"+ type + id);
			JSONObject metadataContainerResponse = ToolingApi.post(
					"sobjects/MetadataContainer", metadataContainerRequest);
			
			logger.info("MetadataContainer id: "
					+ metadataContainerResponse.get("id"));
			
			logger.info("metadataResponse: " + metadataContainerResponse);
			
			JSONObject apexClassMemberRequest = new JSONObject();
			
			apexClassMemberRequest.put("MetadataContainerId",
					metadataContainerResponse.get("id"));
			apexClassMemberRequest.put("ContentEntityId", id);
			apexClassMemberRequest.put("Body", body);
			
			JSONObject apexClassMemberResponse = ToolingApi.post(
					"sobjects/Apex" + type + "Member", apexClassMemberRequest);
			
			logger.info("apexClassMemberResponse: " + apexClassMemberResponse);
			
			JSONObject containerAsyncRequest = new JSONObject();
			containerAsyncRequest.put("MetadataContainerId",
					metadataContainerResponse.get("id"));
			containerAsyncRequest.put("isCheckOnly", false);
			
			JSONObject containerAsyncResponse = ToolingApi.post(
					"sobjects/ContainerAsyncRequest", containerAsyncRequest);
			
			System.out.println("ContainerAsyncRequest id: "
					+ containerAsyncResponse.get("id"));

			logger.info("ContainerAsyncResponse: " + containerAsyncResponse);
			JSONObject result = ToolingApi.get("sobjects/ContainerAsyncRequest/"
							+ containerAsyncResponse.get("id"), ToolingApi.TOOLING_API);
			
			logger.info("Result: " + result);
			String state = (String) result.get("State");
			
			logger.info("State: " + state);
		
			int wait = 1;
			while (state.equals("Queued")) {
				try {
					System.out.println("Sleeping for " + wait + " second(s)");
					Thread.sleep(wait * 10);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}

				wait *= 2;

				result = ToolingApi.get("sobjects/ContainerAsyncRequest/"
						+ containerAsyncResponse.get("id"), ToolingApi.TOOLING_API);
				state = (String) result.get("State");
			}

			ToolingApi.delete("sobjects/MetadataContainer/"
					+ metadataContainerResponse.get("id"));
			
			if (state.equals("Completed")) 
			{
				map.put("body", body);
				map.put("result", "Successful");
				return "classes";
			} else {
				map.put("body", body);
				String errormessage = (String) result.get("ErrorMsg");
				if (errormessage != null)
				{
					JSONArray parsedErrorsMsg = (JSONArray) JSONValue
							.parse(errormessage);
					map.put("result", parsedErrorsMsg);
				}
				String compilerErrors = (String) result.get("CompilerErrors");
				if (compilerErrors != null) {
					JSONArray parsedErrors = (JSONArray) JSONValue
							.parse(compilerErrors);
					map.put("result", parsedErrors);
				}
				return "classes";
			}
		} catch (RuntimeException e) {
			map.put("result", "Exception: " + e.getMessage()); // TODO: better looking error
			return "classes";
		}
	}
}
