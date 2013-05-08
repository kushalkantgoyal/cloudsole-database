package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobManagerService {

	public static final String JOB1 = "job1";
	public static final String JOB2 = "job2";
	public static final String JOB3 = "job3";
	
	private Logger logger = LoggerFactory.getLogger(JobManagerService.class);
	
	private Scheduler scheduler = null;
	
	private Map<String, JobDetail> jobDetails = new HashMap<String, JobDetail>();
	
	private Map<String, Trigger> jobTriggers = new HashMap<String, Trigger>();
	
	private Map<String, String> cronExpressions = new HashMap<String, String>();
	
	private boolean successfullyInitialized = false;

	public void initialize() {
		try {
			initializeScheduler();
			//initializeJob(Job1.class, JOB1);
			//initializeJob(Job2.class, JOB2);
			//initializeJob(Job3.class, JOB3);
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

	private void initializeJob(Class<?> jobClass, String jobName) throws SchedulerException {
		logger.info("initializing <{}>", jobName);
		
		JobDetail jobDetail = JobBuilder.newJob((Class<Job>) jobClass).withIdentity(jobName).storeDurably(true).build();
		
		jobDetails.put(jobName, jobDetail);
		
		JobKey jobKey = jobDetail.getKey();
		
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
		
		logger.info("<{}> initialized", jobName);
	}
	
	private void resetTriggers(String jobName, List<? extends Trigger> triggers) throws SchedulerException {		
		logger.warn("found more than 1 trigger for <{}>", jobName);
			
		logger.warn("removing all triggers to avoid unexpeced results");
			
		for (Trigger trigger : triggers) {
			scheduler.unscheduleJob(trigger.getKey());
		}
	}
	
	public void checkAndUnscheduleTrigger(String jobName) {
		Trigger trigger = jobTriggers.get(jobName);
		
		if (trigger != null) {
			TriggerKey triggerKey = trigger.getKey();
			
			logger.info("unscheduling <{}>", triggerKey);
			
			try {
				scheduler.unscheduleJob(trigger.getKey());
				jobTriggers.put(jobName, null);
				logger.info("<{}> successfully unscheduled", triggerKey);
			} catch (SchedulerException e) {
				logger.error("exception unscheduling <{}>", triggerKey);
				e.printStackTrace();
			}
		} else {
			logger.info("trigger for <{}> not found", jobName);
		}
	}
	
	public void checkAndScheduleCronExpression(String jobName, String triggerName, String cronExpression) {
		Trigger trigger = jobTriggers.get(jobName);
		
		if (trigger == null) {
			trigger = TriggerBuilder.newTrigger()
					.withIdentity(triggerName)
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
					.forJob(jobDetails.get(jobName)).build();
			
			try {
				logger.info("scheduling <{}> with cron expression <{}>", jobName, cronExpression);
				scheduler.scheduleJob(trigger);
				logger.info("<{}> successfully scheduled", jobName);
				
				jobTriggers.put(jobName, trigger);
				cronExpressions.put(jobName, cronExpression);
			} catch (SchedulerException e) {
				logger.error("exception scheduling <{}>", jobName);
				e.printStackTrace();
			}
		} else {
			logger.info("trigger already exists for <{}>", jobName);
		}
	}
	
	public boolean isSuccessfullyInitialized() {
		return successfullyInitialized;
	}

	public String retrieveCronExpression(String jobName) {
		return cronExpressions.get(jobName);
	}
}
