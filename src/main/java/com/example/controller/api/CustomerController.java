package com.example.controller.api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/api/v1/customer")
@Api(value = "Customer operations", listingClass = "CustomerController", basePath = "/api/v1/customer", description = "All operations for customers")
public class CustomerController {
	
	@Autowired
	@Qualifier("jpaRepository")
	private CustomerService customerService;
	
	 @ApiOperation(value = "Find all customers", notes = "Get all customers currently available", httpMethod = "GET", responseClass = "Customer", multiValueResponse = true)
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Collection<Customer> showAllCustomers() {
	        return customerService.getAllCustomers();
	}
	 
	 @ApiOperation(value = "Find customer by Id", notes = "Get customer by specifying Id", httpMethod = "GET", responseClass = "Customer", multiValueResponse = true)
	 @ApiErrors(value = { @ApiError(code = 400, reason = "Invalid ID supplied"), @ApiError(code = 404, reason = "Customer not found") })
	 @RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Customer findCustomerById(@ApiParam(internalDescription = "java.lang.string", name = "customerId", required = true, value = "string") @PathVariable String customerId) {
		 	Customer customer = customerService.getCustomerById(Long.parseLong(customerId));
	        return customer;
	 }
	 
	 @ApiOperation(value = "Delete a customer", notes = "Delete a specific customer with the given ID", httpMethod = "DELETE")
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE, produces = "application/json")
	 public @ResponseBody String deleteCustomer(@ApiParam(internalDescription = "java.lang.string", name = "customerId", required = true, value = "string") @PathVariable String customerId) {
		 customerService.deleteCustomer(Long.parseLong(customerId));
		 return "{status: success}";
	 }
	 
	 @ApiOperation(value = "Create a customer using Parameters", notes = "Creates a new customer using Param", httpMethod = "POST")
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody Customer createCustomerFromParamName(@ApiParam(internalDescription = "java.lang.string", value="string", name = "FirstName", required = false) @RequestParam(required = true) String FirstName, @ApiParam(internalDescription = "java.lang.string", value="string", name = "LastName", required = false) @RequestParam(required = true) String LastName) {	
	    Customer newCustomer = customerService.createCustomer(FirstName, LastName);
	    return newCustomer;
	 }
	 
	 @ApiOperation(value = "Create a customer using JSON", notes = "Creates a new customer", httpMethod = "POST")
	 @ApiError(code = 500, reason = "Process error")
	 @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	 public @ResponseBody Customer createCustomerFromJSON(@RequestBody Customer newCustomer){
		Customer createdCustomer = customerService.createCustomer(newCustomer);
	    return createdCustomer;
	 }
	 
	 @ApiOperation(value = "Update customer", notes = "Update a existing customer", httpMethod = "POST") 
	 @RequestMapping(value = "/{customerId}", method = RequestMethod.POST, consumes = "application/json")
	 public @ResponseBody Customer updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(Long.parseLong(customerId), customer);
		return updatedCustomer;
	 }
}
