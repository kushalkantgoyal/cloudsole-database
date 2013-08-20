package com.example.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.job.QuartzDeleteJob;
import com.example.job.QuartzInsertJob;

@Service
public class JobManagerService {

	public static final String BATCHINSERT = "QuartzInsertJob";
	public static final String BATCHDELETE = "QuartzDeleteJob";
	public static final String BATCHUPDATE = "QuartzUpdateJob";
	
	private Logger logger = LoggerFactory.getLogger(JobManagerService.class);
	
	private Scheduler scheduler = null;
	private Map<String, JobDetail> jobDetails = new HashMap<String, JobDetail>();
	private Map<String, Trigger> jobTriggers = new HashMap<String, Trigger>();
	private Map<String, JobKey> jobKeys = new HashMap<String, JobKey>();
	private Map<String, String> cronExpressions = new HashMap<String, String>();
	private List<String> cronOutput = new ArrayList<String>();
	
	private boolean successfullyInitialized = false;

	@PostConstruct
	public void initialize() {
		try {
			initializeScheduler();
			initializeJob(QuartzInsertJob.class, BATCHINSERT);
			initializeJob(QuartzDeleteJob.class, BATCHDELETE);
			successfullyInitialized = true;
		} catch (SchedulerException e) {
			logger.warn("exception during initialization");
			e.printStackTrace();
		}
	}
	
	private void initializeScheduler() throws SchedulerException {
		logger.info("initializing scheduler...");
		scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		logger.info("scheduler initialized and started");
	}

	public JobDetail buildJob(Class<?> jobClass, String jobName){
		JobDetail jobDetail =  JobBuilder.newJob((Class<Job>) jobClass).withIdentity(jobName).storeDurably(true).build();
		jobDetails.put(jobName, jobDetail);
		return jobDetail;
	}
	
	public void getJobKeyAndCheckExist(JobDetail jobDetail, String jobName) throws SchedulerException{
		JobKey jobKey = jobDetail.getKey();
		jobKeys.put(jobName, jobKey);
		
		if (scheduler.checkExists(jobKey)) {
			jobDetail = scheduler.getJobDetail(jobKey);
		
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobDetail.getKey());
			
			if (triggers.size() > 0) {
				if (triggers.size() > 1) {
					resetTriggers(jobName, triggers);
				} else {
					Trigger trigger = triggers.get(0);
					jobTriggers.put(jobName, trigger);
					
					cronExpressions.put(jobName, ((CronTrigger) trigger).getCronExpression());
				}
			}
		} else {
			scheduler.addJob(jobDetail, false);
		}
		
	}
	
	private void initializeJob(Class<?> jobClass, String jobName) throws SchedulerException {
		logger.info("initializing <{}>", jobName);
		JobDetail jobDetail = buildJob(jobClass, jobName);
		getJobKeyAndCheckExist(jobDetail, jobName);
		logger.info("<{}> initialized", jobName);
	}
	
	private void resetTriggers(String jobName, List<? extends Trigger> triggers) throws SchedulerException {			
		for (Trigger trigger : triggers) {
			scheduler.unscheduleJob(trigger.getKey());
		}
	}
	
	public String checkAndUnscheduleTrigger(String jobName) {
		Trigger trigger = jobTriggers.get(jobName);
		
		if (trigger != null) {
			TriggerKey triggerKey = trigger.getKey();
			
			logger.info("unscheduling <{}>", triggerKey);
			
			try {
				scheduler.unscheduleJob(trigger.getKey());
				jobTriggers.put(jobName, null);
				return triggerKey + " successfully unscheduled";
			} catch (SchedulerException e) {
				logger.error("exception unscheduling <{}>", triggerKey);
				e.printStackTrace();
			}
		} else {
			logger.info("trigger for <{}> not found", jobName);
		}
		return "exception unscheduling";
	}
	
	public List<String> checkAndScheduleCronExpression(String jobName, String triggerName, String cronExpression) {
		Trigger trigger = jobTriggers.get(jobName);
		
		if (trigger == null) {
			trigger = TriggerBuilder.newTrigger()
					.withIdentity(triggerName)
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
					.forJob(jobDetails.get(jobName)).build();
			
			try {
				cronOutput.add("scheduling "  + jobName + " with cron expression " + cronExpression);
				scheduler.scheduleJob(trigger);
				cronOutput.add("successfully scheduled: " + jobName);
				
				jobTriggers.put(jobName, trigger);
				cronExpressions.put(jobName, cronExpression);
			} catch (SchedulerException e) {
				cronOutput.add("exception scheduling: "+ jobName);
				e.printStackTrace();
			}
		} else {
			cronOutput.add("trigger already exists for: " + jobName);
		}
		
		return cronOutput;
	}
	
	public boolean isSuccessfullyInitialized() {
		return successfullyInitialized;
	}

	public String retrieveCronExpression(String jobName) {
		return cronExpressions.get(jobName);
	}
	
	public Map<String, String> getCronExpressions(){
		return cronExpressions;
	}
	
	public Map<String, Trigger> getJobTriggers(){
		return jobTriggers;
	}
	
	public Map<String, JobDetail> getJobDetails(){
		return jobDetails;
	}
	
	public Map<String, JobKey> getJobKeys(){
		return jobKeys;
	}
	
	public List<String> getCurrentlyExecutingJobs() throws SchedulerException{
		List<String> jobDescriptions = new ArrayList<String>();
		for (JobExecutionContext runningJobs : scheduler.getCurrentlyExecutingJobs()){
			jobDescriptions.add(runningJobs.getJobDetail().getDescription());
		}
		return jobDescriptions;
	}
	
	public void scheduler(){
		//scheduler.
	}
}
