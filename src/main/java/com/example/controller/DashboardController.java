package com.example.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.LoginService;
import com.example.util.GraphMapper;
import com.force.api.QueryResult;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	LoginService loginToSalesforce;
	
	@RequestMapping("")
	public String returnDashboardView(Map<String, Object> map)
	{
		//new opportunities
		Integer queryCountOppResult = loginToSalesforce.LoginToSalesforce().query("Select count() from Opportunity where CreatedDate=Today").getTotalSize();
		
		//total amount from opportunities today
		QueryResult<Map> queryTotalAmountOpportunities = loginToSalesforce.LoginToSalesforce().query("Select sum(amount) from Opportunity where CreatedDate=Today"); 
		
		//total cases open today
		Integer queryNewOpenCaseToday = loginToSalesforce.LoginToSalesforce().query("Select count() from Case where CreatedDate=Today and Status='New'").getTotalSize();
		
		//total cases closed today
		Integer queryNewClosedCaseToday = loginToSalesforce.LoginToSalesforce().query("Select count() from Case where CreatedDate=Today and Status='Closed'").getTotalSize();
		
		//total new leads today
		Integer queryNewLeadsToday = loginToSalesforce.LoginToSalesforce().query("Select count() from Lead where CreatedDate=Today").getTotalSize();
		
		//new contacts today
		Integer queryNewContactToday = loginToSalesforce.LoginToSalesforce().query("Select count() from Contact where CreatedDate=Today").getTotalSize();
				
		map.put("queryCountOppResult", queryCountOppResult);
		map.put("queryNewOpenCaseToday", queryNewOpenCaseToday);
		map.put("queryNewClosedCaseToday", queryNewClosedCaseToday);
		map.put("queryNewLeadsToday", queryNewLeadsToday);
		map.put("queryNewContactToday", queryNewContactToday);
		if (queryTotalAmountOpportunities.getRecords().get(0).values().toArray()[1]!=null)
			map.put("queryTotalAmountOppResult", new BigDecimal(String.valueOf(queryTotalAmountOpportunities.getRecords().get(0).values().toArray()[1])).toPlainString());
		else
			map.put("queryTotalAmountOppResult", new BigDecimal(String.valueOf(0)).toPlainString());
		
		//Logins Today
		Integer queryLoginsToday = loginToSalesforce.LoginToSalesforce().query("Select count() from LoginHistory where LoginTime=Today").getTotalSize();
		
		//Chatter Posts
		Integer queryChatterPostsToday = loginToSalesforce.LoginToSalesforce().query("Select count() from FeedItem where CreatedDate=Today").getTotalSize();
				
		//Chatter Comments/Likes
		Integer queryChatterCommentsToday = loginToSalesforce.LoginToSalesforce().query("Select count() from FeedComment where CreatedDate=Today").getTotalSize();
			
		//Total Emails
		//Integer queryEmailToday = loginToSalesforce.LoginToSalesforce().query("Select count() from EmailMessage where CreatedDate=Today").getTotalSize();
		
		//Total Tasks
		Integer queryTasksToday = loginToSalesforce.LoginToSalesforce().query("Select count() from Task where CreatedDate=Today").getTotalSize();
		
		//Total Documents
		Integer queryDocumentToday = loginToSalesforce.LoginToSalesforce().query("Select count() from Document where CreatedDate=Today").getTotalSize();
		
		map.put("queryLoginsToday", queryLoginsToday);
		map.put("queryChatterPostsToday", queryChatterPostsToday);
		map.put("queryChatterCommentsToday", queryChatterCommentsToday);
		//map.put("queryEmailToday", queryEmailToday);
		map.put("queryTasksToday", queryTasksToday);
		map.put("queryDocumentToday", queryDocumentToday);
		
		QueryResult<Map> queryOpportunityOpenToday = loginToSalesforce.LoginToSalesforce().query("Select CreatedDate, StageName from Opportunity where CreatedDate=Today");
		
		Map<String, String> opportunityMap = new HashMap<String, String>();
		
		for (int oppcounter = 0; oppcounter< queryOpportunityOpenToday.getTotalSize(); oppcounter++)
		{
			opportunityMap.put(String.valueOf(queryOpportunityOpenToday.getRecords().get(oppcounter).values().toArray()[1]), String.valueOf(queryOpportunityOpenToday.getRecords().get(oppcounter).values().toArray()[2]));
		}
		
		
		//2013-04-21T07:00:00.000Z
		Map<Integer, Integer> openOpportunities = new HashMap<Integer, Integer>();
		Map<Integer, Integer> closedOpportunities = new HashMap<Integer, Integer>();
		
		for (String groupopp : opportunityMap.keySet())
		{
			if (opportunityMap.get(groupopp).equalsIgnoreCase("Open"))
			{
				if (openOpportunities.isEmpty())
				{
					openOpportunities.put(Integer.valueOf(groupopp.substring(11, 13)), 1);
				}
				else if (openOpportunities.get(Integer.valueOf(groupopp.substring(11, 13))) == null)
				{
					openOpportunities.put(Integer.valueOf(groupopp.substring(11, 13)), 1);
				}
				else if (openOpportunities.get(Integer.valueOf(groupopp.substring(11, 13))) != null)
				{
					openOpportunities.put(Integer.valueOf(groupopp.substring(11, 13)), openOpportunities.get(Integer.valueOf(groupopp.substring(11, 13)))+1);
				}
			}
			else if (opportunityMap.get(groupopp).contains("Close"))
			{
				if (closedOpportunities.isEmpty())
				{
					closedOpportunities.put(Integer.valueOf(groupopp.substring(11, 13)), 1);
				}
				else if (closedOpportunities.get(Integer.valueOf(groupopp.substring(11, 13))) == null)
				{
					closedOpportunities.put(Integer.valueOf(groupopp.substring(11, 13)), 1);
				}
				else if (closedOpportunities.get(Integer.valueOf(groupopp.substring(11, 13))) != null)
				{
					closedOpportunities.put(Integer.valueOf(groupopp.substring(11, 13)), closedOpportunities.get(Integer.valueOf(groupopp.substring(11, 13)))+1);
				}
			}
		}
		
		map.put("OpenOppGraph", GraphMapper.lineGraphBuilder(openOpportunities));
		map.put("ClosedOppGraph",GraphMapper.lineGraphBuilder(closedOpportunities));
		
		return "dashboard";
	}


	@RequestMapping("/developer")
	public String returnTechnicalDashboardView(Map<String, Object> map)
	{
		//API calls
		
		//Apex Class
		
		//Visualforce Classes
		
		//Components
		
		//Scheduled Jobs
		
		//Batch Jobs
		
		//Streaming Clients
		
		return "techdashboard";
	}
	
}
