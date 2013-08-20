package com.example.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.service.JobManagerService;

@Controller
@RequestMapping("/quartz")
public class QuartzController {
		
	@Autowired
	private JobManagerService jobManagerService;
	
	@RequestMapping("")
	public String QuartzView(Map<String, Object> map){
		map.put("jobTriggers", jobManagerService.getJobTriggers());
		map.put("cronExpression", jobManagerService.getCronExpressions());
		map.put("cronDetails", jobManagerService.getJobDetails());
		
		return "quartz";
	}
	
	@RequestMapping(value="/stop/{jobName}", method=RequestMethod.GET)
	public String stopQuartz(Map<String, Object> map, @PathVariable String jobName){
		map.put("quartzOutput", jobManagerService.checkAndUnscheduleTrigger(jobName));
		map.put("jobTriggers", jobManagerService.getJobTriggers());
		map.put("cronExpression", jobManagerService.getCronExpressions());
		map.put("cronDetails", jobManagerService.getJobDetails());
		return "quartz";
	}
	
	@RequestMapping(value="/run", method=RequestMethod.POST)
	public String runNewQuartzJob(Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException{
		
			final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
					request);
			final Map<String, String> formData = new FormHttpMessageConverter()
					.read(null, inputMessage).toSingleValueMap();
			String cronExpression = formData.get("cronexpression");
			String jobName = formData.get("jobName");
			map.put("quartzOutput", jobManagerService.checkAndScheduleCronExpression(jobName, jobName, cronExpression));
			map.put("jobTriggers", jobManagerService.getJobTriggers());
			map.put("cronExpression", jobManagerService.getCronExpressions());
			map.put("cronDetails", jobManagerService.getJobDetails());
		return "quartz";
	}
	
	
	@RequestMapping(value="/run/{jobName}", method=RequestMethod.GET)
	public String runQuartz(Map<String, Object> map, @PathVariable String jobName, HttpServletRequest request) throws HttpMessageNotReadableException, IOException{
		if (jobManagerService.retrieveCronExpression(jobName)!=null)
			map.put("quartzOutput", jobManagerService.checkAndScheduleCronExpression(jobName, jobName, jobManagerService.retrieveCronExpression(jobName)));
			map.put("jobTriggers", jobManagerService.getJobTriggers());
			map.put("cronExpression", jobManagerService.getCronExpressions());
			map.put("cronDetails", jobManagerService.getJobDetails());
		return "quartz";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String runQueryUpdate(Map<String, Object> map, HttpServletRequest request) throws HttpMessageNotReadableException, IOException{
		final ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(
				request);
		final Map<String, String> formData = new FormHttpMessageConverter()
				.read(null, inputMessage).toSingleValueMap();
		String cronExpression = formData.get("cronexpression");
		String jobName = formData.get("jobName");
		jobManagerService.checkAndUnscheduleTrigger(jobName);
		map.put("quartzOutput", jobManagerService.checkAndScheduleCronExpression(jobName, jobName, cronExpression));
		map.put("jobTriggers", jobManagerService.getJobTriggers());
		map.put("cronExpression", jobManagerService.getCronExpressions());
		map.put("cronDetails", jobManagerService.getJobDetails());
		return "quartz";
	}
	
}
