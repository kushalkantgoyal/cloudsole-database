package com.example.service;
import com.force.api.ForceApi;

public interface LoginService 
{
	public ForceApi LoginToSalesforce();
	public String getSessionId();
	public String getEndpointURL();
}
