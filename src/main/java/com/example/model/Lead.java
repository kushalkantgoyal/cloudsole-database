package com.example.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Lead {
	@JsonProperty("LastName")
	private String LastName;
	
	@JsonProperty("Company")
	private String Company;
	
	@JsonProperty("LeadStatus")
	private String LeadStatus;
	
	@JsonProperty("Email")
	private String Email;

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getLeadStatus() {
		return LeadStatus;
	}

	public void setLeadStatus(String leadStatus) {
		LeadStatus = leadStatus;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
}
