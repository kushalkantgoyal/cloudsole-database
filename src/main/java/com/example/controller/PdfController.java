package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.example.model.Customer;
import com.example.pdf.CustomerPdfView;

@Controller
@RequestMapping("/pdf")
public class PdfController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Customer newCustomer = new Customer();
		newCustomer.setFirstName("Test");
		newCustomer.setLastName("Test");
		//return new ModelAndView(new PdfController(), "", );
		return null;
	}
}
