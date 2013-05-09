package com.example.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Account {
		
	@JsonProperty(value="Name")
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
