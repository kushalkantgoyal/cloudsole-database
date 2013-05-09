package com.example.controllers.api;

import java.util.List;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.LoginService;
import com.force.api.ApiException;
import com.force.api.QueryResult;
import com.example.model.Lead;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/api/v1/leads")
@Api(description="Lead operations", listingClass="LeadController", basePath="/api/v1/lead", value="Lead operations")
public class LeadController 
{
	@Autowired
	LoginService loginService;
	
	 @ApiOperation(value = "Find all leads", notes = "Get all leads currently available", httpMethod = "GET", responseClass = "Lead", multiValueResponse = true)
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Lead> showAllLeads() {
	    	QueryResult<Lead> res = loginService.LoginToSalesforce().query("SELECT LastName, FirstName, Salutation, Name, RecordTypeId, Title, Company, Street, City, State, PostalCode, Country, Phone, Email, Website, Description, LeadSource, Status, Industry, Rating, AnnualRevenue, NumberOfEmployees, OwnerId, HasOptedOutOfEmail, IsConverted, ConvertedDate, ConvertedAccountId, ConvertedContactId, ConvertedOpportunityId, IsUnreadByOwner, CreatedDate, CreatedById, LastModifiedDate, LastModifiedById, SystemModstamp, LastActivityDate, Jigsaw, JigsawContactId, ConnectionReceivedId, ConnectionSentId, EmailBouncedReason, EmailBouncedDate FROM Lead", Lead.class);
	        return res.getRecords();
	 }
	
	 @ExceptionHandler(Exception.class)
	 @ApiOperation(value = "Find lead by Id", notes = "Get lead by specifying Id", httpMethod = "GET", responseClass = "Lead", multiValueResponse = true)
	 @ApiErrors(value = { @ApiError(code = 400, reason = "Invalid id supplied"), @ApiError(code = 404, reason = "Lead not found"), @ApiError(code = 500, reason = "Process error") })
	 @RequestMapping(value = "/{leadId}", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Lead[] findLeadById(@ApiParam(internalDescription = "java.lang.string", name = "leadId", required = true, value = "string") @PathVariable String leadId) throws ApiException, NotFoundException 
	 {
		 try
		 {
			 Lead lead = loginService.LoginToSalesforce().getSObject("Lead", leadId).as(Lead.class);
			 if (lead != null)
			 {
				 return new Lead[]{lead};
			 }
			 else
			 {
				 throw new NotFoundException("Could not find Lead");
			 }
		 }
		 catch(ApiException e)
		 {
			 throw new ApiException(404, "something went wrong");
		 }
	 }
	
	 @ApiOperation(value = "Delete a lead", notes = "Remove a specific lead with the given ID", httpMethod = "DELETE")
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(value = "/{leadId}", method = RequestMethod.DELETE, produces = "application/json")
	 public @ResponseBody String deleteLead(@ApiParam(internalDescription = "java.lang.string", name = "leadId", required = true, value = "string") @PathVariable String leadId) {
		 	loginService.LoginToSalesforce().deleteSObject("lead", leadId);
	    	return "{status: success}";
	 }
	 
	 @ApiOperation(value = "Create a lead using Param", notes = "Creates a new lead in salesforce using Param", httpMethod = "POST")
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody String createLeadFromParamName(@ApiParam(internalDescription = "java.lang.string", value="string", name = "LastName", required = false) @RequestParam(required = true) String lastName, 
			 											 @ApiParam(internalDescription = "java.lang.string", value="string", name = "Email", required = false) @RequestParam(required = true) String email,
			 											 @ApiParam(internalDescription = "java.lang.string", value="string", name = "Status", required = false) @RequestParam(required = true) String status,
			 											 @ApiParam(internalDescription = "java.lang.string", value="string", name = "Company", required = false) @RequestParam(required = true) String company) 
	 {	
			Lead newLead = new Lead();
			newLead.setLastName(lastName);
			newLead.setEmail(email);
			newLead.setCompany(company);
			newLead.setLeadStatus(status);
	    	String id = loginService.LoginToSalesforce().createSObject("Lead", newLead);
	    	return "{id:" + id +"}";
	 }
	 
	 @ApiOperation(value = "Update Lead", notes = "Update a existing Lead", httpMethod = "POST") 
	 @RequestMapping(value = "/{leadId}", method = RequestMethod.POST, consumes = "application/json")
     public @ResponseBody String updateAccount(@PathVariable String leadId, @RequestBody Lead lead) {
		 	loginService.LoginToSalesforce().updateSObject("Lead", leadId, lead);
			 return "{status: success}";
	}
	 
	 @ApiOperation(value = "Create a lead using JSON", notes = "Creates a new lead in salesforce", httpMethod = "POST")
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	 public @ResponseBody String createAccountFromJSON(@RequestBody Lead newLead) 
	 {	
		 String id = loginService.LoginToSalesforce().createSObject("Lead", newLead);
	     return "{id:" + id +"}";
	 }
	
}
