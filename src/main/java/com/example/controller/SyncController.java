package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.force.api.QueryResult;
import com.force.api.DescribeSObject.Field;

@Controller
@RequestMapping("/sync")
public class SyncController {

	private static List<String> sObjectFieldNames = null;
	private static final String SELECT = "SELECT ";
	private static final String FROM = "FROM ";
	private static QueryResult<Map> res = null;	
	private static Map<String, String> paginationPages =null;
	final static Integer PAGESIZE = 100;
	
	@Autowired
    private LoginService loginService;
	
	@RequestMapping(value="")
	public String syncView(Map<String, Object> map)
	{
		return "sync";
	}
	
	@RequestMapping(value="/query/{sobjectName}", method = RequestMethod.GET)
	public String querySObjects(@PathVariable("sobjectName") String sObjectName, Map<String, Object> map) throws HttpMessageNotReadableException, IOException
	{
		try
		{
			sObjectFieldNames = new ArrayList<String>();
			StringBuilder buildSoqlQuery = new StringBuilder();
			buildSoqlQuery.append(SELECT);
		
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession(false);
			session.setAttribute("currentSObject", sObjectName);
		
			sObjectFieldNames.clear();
			for (Field listOfField : loginService.LoginToSalesforce().describeSObject(sObjectName).getFields())
			{	
				buildSoqlQuery.append(listOfField.getName().concat(", "));
				sObjectFieldNames.add(listOfField.getName().toString());
			}
	
			buildSoqlQuery.deleteCharAt(buildSoqlQuery.length()-2);
		
			buildSoqlQuery.append(FROM);
			buildSoqlQuery.append(sObjectName);
		
			map.put("sobjectFieldNamesSOQL", sObjectFieldNames);
			map.put("sobjectQuery", buildSoqlQuery.toString());
			return "sync";
		} 	catch (Exception e) {
			map.put("error", e.getMessage());
			return "sync";
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/query/{sobjectName}", method = RequestMethod.POST)
	public String querySObjectsReturnView(@PathVariable("sobjectName") String sObjectName, HttpServletRequest request, Map<String, Object> map, HttpServletResponse response) throws HttpMessageNotReadableException, IOException
	{
		try 
		{
			final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(request);
			final Map<String, String> formData = new FormHttpMessageConverter().read(null, inputMessage).toSingleValueMap();
			final String soqlquery = formData.get("soqlquery");
			Map<String, String> unsortedpaginationPages = new HashMap<String, String>();
				
			if (!soqlquery.isEmpty())
			{
				res = new QueryResult<Map>();
				res.setTotalSize(2000);
				res = loginService.LoginToSalesforce().query(soqlquery);
			}

			for (Integer k = 100, pagecounter=Math.abs(res.getTotalSize()/100); k<res.getTotalSize(); k+=PAGESIZE, pagecounter--)
			{
				unsortedpaginationPages.put(pagecounter.toString(), "/login/sync/query/"+ sObjectName +"/" + pagecounter.toString());
			}
			
			paginationPages = new TreeMap<String, String>(unsortedpaginationPages);
			
			map.put("sobjectRecords",res.getRecords().subList(0, (100 > res.getTotalSize()) ? res.getTotalSize() : 100));
			map.put("sobjectFieldNames", res.getRecords().get(0).keySet());
			map.put("pagination", paginationPages);

			return "sync";
		
		} catch (Exception e) {
			map.put("error", e.getMessage());
			return "sync";
		}
	}
	
	@RequestMapping(value="/run", method=RequestMethod.GET)
	public String runSyncJob(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws HttpMessageNotReadableException, IOException
	{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(request);
		final Map<String, String> formData = new FormHttpMessageConverter().read(null, inputMessage).toSingleValueMap();
		
		List<String> recordsToSync = new ArrayList<String>();
		for (Integer k = 0; k<3; k++)
		{
			if (formData.get(k.toString()) != null)
			{
				recordsToSync.add(formData.get(k.toString()));
			}
		}
		
		System.out.println(recordsToSync);
	
		return "sync";
	}
	
}
