package com.example.service;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.net.URL;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;
import org.cometd.client.transport.LongPollingTransport;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;

import com.example.util.SoapLoginUtil;

public class StreamingService {
	
	// This URL is used only for logging in. The LoginResult
		// returns a serverUrl which is then used for constructing
		// the streaming URL. The serverUrl points to the endpoint
		// where your organization is hosted.
		public static final String LOGIN_ENDPOINT = "https://login.salesforce.com";
		private static final String USER_NAME = "salesforce@rocketlawyer.com";
		private static final String PASSWORD = "RL5yncUs3rN2mPoAfI9u47ZaKAllkp7xX3F";
		// NOTE: Putting passwords in code is not a good practice and not recommended.
		// Set this to true only when using this client
		// against the Summer'11 release (API version=22.0).
		private static final boolean VERSION_22 = false;
		private static final boolean USE_COOKIES = VERSION_22;
		// The channel to subscribe to. Same as the name of the PushTopic.
		// Be sure to create this topic before running this sample.
		private static final String CHANNEL = VERSION_22 ? "/LawyerConTopic" : "/topic/LawyerConTopic";
		private static final String STREAMING_ENDPOINT_URI = VERSION_22 ? "/cometd" : "/cometd/25.0";
		// The long poll duration.
		private static final int CONNECTION_TIMEOUT = 20 * 1000; // milliseconds
		private static final int READ_TIMEOUT = 120 * 1000; // milliseconds
		
		private static BayeuxClient makeClient() throws Exception 
		{
			HttpClient httpClient = new HttpClient();
			httpClient.setConnectTimeout(CONNECTION_TIMEOUT);
			httpClient.setTimeout(READ_TIMEOUT);
			httpClient.start();
			String[] pair = SoapLoginUtil.login(httpClient, USER_NAME, PASSWORD);
			if (pair == null)
			{
				System.exit(1);
			}
			assert pair.length == 2;
			final String sessionid = pair[0];
			String endpoint = pair[1];
			System.out.println("Login successful!\nEndpoint: " + endpoint + "\nSessionid=" + sessionid);
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(ClientTransport.TIMEOUT_OPTION, READ_TIMEOUT);
			
			LongPollingTransport transport = new LongPollingTransport(options, httpClient) 
			{
				@Override
				protected void customize(ContentExchange exchange) {
					super.customize(exchange);
					exchange.addRequestHeader("Authorization", "OAuth " + sessionid);
				}
			};
			
			BayeuxClient client = new BayeuxClient(salesforceStreamingEndpoint(endpoint), transport);
			if (USE_COOKIES) establishCookies(client, USER_NAME, sessionid);
				return client;
		}
		private static String salesforceStreamingEndpoint(String endpoint) throws MalformedURLException 
		{
			return new URL(endpoint + STREAMING_ENDPOINT_URI).toExternalForm();
		}
		
		private static void establishCookies(BayeuxClient client, String user, String sid) 
		{
			client.setCookie("com.salesforce.LocaleInfo", "us", 24 * 60 * 60 * 1000);
			client.setCookie("login", user, 24 * 60 * 60 * 1000);
			client.setCookie("sid", sid, 24 * 60 * 60 * 1000);
			client.setCookie("language", "en_US", 24 * 60 * 60 * 1000);
		}

}
