package com.example.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.force.api.QueryResult;
import com.example.model.Account;
import com.example.service.LoginService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/doc/v1/account")
@Api(value = "Account operations", listingClass = "AccountController", basePath = "/v1/account", description = "All operations for accounts")
public class AccountController {
	
	@Autowired
	LoginService loginService;
	
	 @ApiOperation(value = "Find all accounts", notes = "Get all account currently available", httpMethod = "GET", responseClass = "Account", multiValueResponse = true)
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Account> showAllAccounts() {
	    	QueryResult<Account> res = loginService.LoginToSalesforce().query("SELECT Name FROM Account", Account.class);
	        return res.getRecords();
	 }
	
	@ApiOperation(value = "Find account by Id", notes = "Get account by specifying Id", httpMethod = "GET", responseClass = "Account", multiValueResponse = true)
	@ApiErrors(value = { @ApiError(code = 400, reason = "Invalid ID supplied"), @ApiError(code = 404, reason = "Account not found") })
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Account[] findAccountById(@ApiParam(internalDescription = "java.lang.string", name = "accountId", required = true, value = "string") @PathVariable String accountId) {
    	Account account = loginService.LoginToSalesforce().getSObject("account", accountId).as(Account.class);
        return new Account[]{account};
    }
	
	@ApiOperation(value = "Delete a account", notes = "Delete a specific account with the given ID", httpMethod = "DELETE")
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody String deleteAccount(@ApiParam(internalDescription = "java.lang.string", name = "accountId", required = true, value = "string") @PathVariable String accountId) {
    	loginService.LoginToSalesforce().deleteSObject("account", accountId);
    	return "{status: success}";
    }
	
	@ApiOperation(value = "Create a account using Param", notes = "Creates a new account in salesforce using Param", httpMethod = "GET")
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String createAccountFromParamName(@ApiParam(internalDescription = "java.lang.string", value="string", name = "Name", required = false) @RequestParam(required = true) String Name) 
    {	
		Account newAccount = new Account();
		newAccount.setName(Name);
    	String id = loginService.LoginToSalesforce().createSObject("Account", newAccount);
    	return "{id:" + id +"}";
    }
	
	@ApiOperation(value = "Create a account", notes = "Creates a new account in salesforce", httpMethod = "GET")
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public @ResponseBody String createAccountFromJSON(@RequestBody Account newAccount) 
    {	
    	String id = loginService.LoginToSalesforce().createSObject("Account", newAccount);
    	return "{id:" + id +"}";
    }
	
	@ApiOperation(value = "Update Account", notes = "Update a existing Account", httpMethod = "GET") 
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET, consumes = "application/json")
	 public @ResponseBody String updateAccount(@PathVariable String accountId, @RequestBody Account account) {
		 loginService.LoginToSalesforce().updateSObject("Account", accountId, account);
		 return "{status: success}";
	 }
}
