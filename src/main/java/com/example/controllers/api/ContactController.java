package com.example.controllers.api;

import java.util.List;

import com.force.api.QueryResult;
import com.example.model.Contact;
import com.example.service.LoginService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/doc/v1/contact")
@Api(value = "Contact operations", listingClass = "ContactController", basePath = "/v1/contact", description = "All operations for contacts")
public class ContactController {
	
	@Autowired
	LoginService loginService;
	
	@ApiOperation(value = "Find all contacts", notes = "Get all contacts currently available", httpMethod = "GET", responseClass = "Contact", multiValueResponse = true)
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Contact> showAllContacts() {
    	QueryResult<Contact> res = loginService.LoginToSalesforce().query("SELECT FirstName, LastName, AccountId FROM Contact", Contact.class);
        return res.getRecords();
    }
	
    @ApiOperation(value = "Find contact by Id", notes = "Get contacts by specifying Id", httpMethod = "GET", responseClass = "Contact", multiValueResponse = true)
    @ApiErrors(value = { @ApiError(code = 400, reason = "Invalid ID supplied"), @ApiError(code = 404, reason = "Contact not found"), @ApiError(code = 500, reason = "Process error") })
    @RequestMapping(value = "/{contactId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Contact[] findContactById(@ApiParam(internalDescription = "java.lang.string", name = "contactId", required = true, value = "string") @PathVariable String contactId) {
    	Contact contact = loginService.LoginToSalesforce().getSObject("Contact", contactId).as(Contact.class);
        return new Contact[]{contact};
    }

    @ApiOperation(value = "Delete a contact", notes = "Delete a contact with the given ID", httpMethod = "DELETE")
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody String deleteContact(@ApiParam(internalDescription = "java.lang.string", name = "contactId", required = true, value = "string") @PathVariable String contactId) {
    	loginService.LoginToSalesforce().deleteSObject("contact", contactId);
    	return "{status: success}";
    }

    @ApiOperation(value = "Create a contact", notes = "Creates a new contact in salesforce", httpMethod = "PUT", responseClass = "Contact", multiValueResponse = true)
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json" )
    public @ResponseBody String createContactFromJSON(@RequestBody Contact newContact) 
    {	
    	String id = loginService.LoginToSalesforce().createSObject("contact", newContact);
    	return "{ id:" + id + "}";
    }
    
    @ApiOperation(value = "Update a contact", notes = "Update a existing contact in salesforce", httpMethod = "PUT", responseClass = "Contact", multiValueResponse = true)
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(value = "/{contactId}", method = RequestMethod.GET, consumes = "application/json")
    public @ResponseBody String updateContact(@PathVariable String contactId, @RequestBody Contact contact) {
    	loginService.LoginToSalesforce().updateSObject("Contact", contactId, contact);
		return "{status: success}";
    }
    
}
