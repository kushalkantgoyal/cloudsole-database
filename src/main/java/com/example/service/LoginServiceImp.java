package com.example.service;
import org.springframework.stereotype.Service;

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
	

	@Override
	public String getSessionId() {
		if (LoginToSalesforce() != null)
			return ForceSecurityContextHolder.get().getSessionId();
		else
			return null;
	}

	@Override
	public String getEndpointURL() {
		if (LoginToSalesforce() != null)
			return ForceSecurityContextHolder.get().getEndPointHost();
		else 
			return null;
	}
}
