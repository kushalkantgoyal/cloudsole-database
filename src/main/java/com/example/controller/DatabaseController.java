package com.example.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Customer;
import com.example.service.CustomerService;

@Controller
@RequestMapping("/db")
public class DatabaseController {
	
	@Autowired
	@Qualifier("jpaRepository")
	private CustomerService customerService;
	
	@RequestMapping(value="")
	public String showAllCustomers(Map<String, Object> map){
		map.put("pagination", customerService.getPaginationSequence());
		map.put("contactList", customerService.getPaginatedCustomer(0, 10));
		return "viewdb";
	}
	
	@RequestMapping(value="/{pageNumber}", method = RequestMethod.GET)
	public String returnPageOfCustomers(Map<String, Object> map, @PathVariable("pageNumber") Integer pageNumber){
		map.put("pagination", customerService.getPaginationSequence());
		map.put("contactList", customerService.getPaginatedCustomer((pageNumber-1)*10, (pageNumber*10 > customerService.getTotalRecords()) ? customerService.getTotalRecords() : pageNumber*10));
		return "viewdb";
	}
	
	@RequestMapping(value="/insert")
	public String insertCustomersView(){
		return "insertdb";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertCustomers(Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		String firstName = formData.get("firstName");
		String lastName = formData.get("lastName");
		customerService.createCustomer(firstName, lastName);
		map.put("contactList", customerService.getAllCustomers());
		return "viewdb";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchForCustomer(Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		String searchId = formData.get("seachquery");
		try{
		Customer foundCustomer = customerService.getCustomerById(Long.parseLong(searchId));
		List<Customer> createListWithOne = Arrays.asList(foundCustomer);
		map.put("contactList", createListWithOne);}
		catch(RuntimeException re) {
			map.put("errormsg", "Could not find the user");
		}
		return "viewdb";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String deleteCustomer(@PathVariable("id") String id, Map<String, Object> map){
		customerService.deleteCustomer(Long.parseLong(id));
		map.put("contactList", customerService.getAllCustomers());
		return "viewdb";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String updateCustomerView(@PathVariable("id") String id, Map<String, Object> map){
		List<Customer> createListWithOne = Arrays.asList(customerService.getCustomerById(Long.parseLong(id)));
		map.put("contactList", createListWithOne);
		return "updatedb";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String updateCustomer(@PathVariable("id") String id, Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		String firstName = formData.get("firstName");
		String lastName = formData.get("lastName");
		customerService.updateCustomer(Long.parseLong(id), firstName, lastName);
		map.put("contactList", customerService.getAllCustomers());
		return "viewdb";
	}

	@RequestMapping(value="/export", method=RequestMethod.POST)
	public void exportToCsv(HttpServletResponse response) throws IOException{
		/*File file = SObjectUtil.createTempCSVFile(res);
		 
	     response.setContentType("application/csv"); 
	     response.setContentLength(new Long(file.length()).intValue());
	     response.setHeader("Content-Disposition","attachment; filename=export.csv");
	 
	     try {
	    	 FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
	    	
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	     finally
	     {
	    	 file.deleteOnExit();
	     }*/
	}
	
	@RequestMapping("/query")
	public String showQuery(){
		return "query";
	}
	
	@RequestMapping(value="/query", method=RequestMethod.POST)
	public String showQueryResult(Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(request);
		final Map<String, String> formData = new FormHttpMessageConverter().read(null, inputMessage).toSingleValueMap();
		final String query = formData.get("query");
		
		map.put("contactList", customerService.findCustomerByQuery(query));
		return "viewdb";
	}
}
