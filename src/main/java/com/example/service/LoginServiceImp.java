package com.example.service;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.force.api.ApiSession;
import com.force.api.ForceApi;
import com.force.sdk.oauth.context.ForceSecurityContextHolder;
import com.force.sdk.oauth.context.SecurityContext;

@Service
public class LoginServiceImp implements LoginService {
	
	@Override
	public ForceApi LoginToSalesforce() 
	{
		SecurityContext sc = ForceSecurityContextHolder.get();
        ApiSession apiSession = new ApiSession();
        apiSession.setAccessToken(sc.getSessionId());
        apiSession.setApiEndpoint(sc.getEndPointHost());
        return new ForceApi(apiSession);
	}
	

	public static String getSessionId() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(false); //create a new session
		System.out.println("SessionId: " + session.getAttribute("sessionId").toString());
		return session.getAttribute("sessionId").toString();
	}

	public static String getEndpointURL() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(false); //create a new session
		System.out.println("Endpoint: " + session.getAttribute("endpoint").toString());
		return session.getAttribute("endpoint").toString();
	}
}
