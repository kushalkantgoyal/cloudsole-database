package com.example.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.example.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map map, Document doc,
			PdfWriter writer, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		Customer customer = (Customer)map.get("customer");
		doc.add(new Paragraph("FirstName: " + customer.getFirstName()));	
	}

}
