package com.example.util;

import java.util.List;

public class ApexUtil {

	public enum classTypes
	{
		BASE, TEST, BATCH, SCHED, EMAIL, EXCEPTION, EMPTY;
	};
	
	public String triggerStub(String name, List<String> operations, Boolean createHandler)
	{
		StringBuilder triggerBuilder = new StringBuilder();
		triggerBuilder.append("trigger ").append(name).append("{");
		if (createHandler)
			triggerBuilder.append(name).append("TriggerHandler handler = new ").append(name).append("TriggerHandler(Trigger.isExecuting, Trigger.size);").append("\n");
		
		for (String operation : operations)
		{
			triggerBuilder.append(operation).append(",");
		}
		triggerBuilder.deleteCharAt(triggerBuilder.length()-1);
		triggerBuilder.append(") {").append("\n");
		for (String operation : operations)
		{
			triggerBuilder.append("\t").append("if ((Trigger.is" + operation.split(" " )[0] + ")").append(" && ").append("(Trigger.is" + operation.split(" " )[1] + ")").append(") {").append("\n");
			if (operation.equalsIgnoreCase("before insert"))
				triggerBuilder.append("handler.OnBeforeInsert(Trigger.new);").append("\n");
			else if (operation.equalsIgnoreCase("after insert"))
				triggerBuilder.append("handler.OnAfterInsert(Trigger.new);").append("\n");
			else if (operation.equalsIgnoreCase("before update"))
				triggerBuilder.append("handler.OnBeforeUpdate(Trigger.old, Trigger.new, Trigger.newMap);").append("\n");
			else if (operation.equalsIgnoreCase("after update"))
				triggerBuilder.append("handler.OnAfterUpdate(Trigger.old, Trigger.new, Trigger.newMap);").append("\n");
			else if (operation.equalsIgnoreCase("before delete"))
				triggerBuilder.append("handler.OnBeforeDelete(Trigger.old, Trigger.oldMap);").append("\n");
			else if (operation.equalsIgnoreCase("after insert"))
				triggerBuilder.append("handler.OnAfterDelete(Trigger.old, Trigger.oldMap);").append("\n");
			else if (operation.equalsIgnoreCase("undelete"))
				triggerBuilder.append("handler.OnUndelete(Trigger.new);").append("\n");
			
			triggerBuilder.append("}");
		}

		triggerBuilder.append("}");
		
		return triggerBuilder.toString();
	}
	
	public String classStub(String name, String type)
	{
		StringBuilder classBuilder = new StringBuilder();
		switch (classTypes.valueOf(type)) {
		case BASE:
			classBuilder.append("public class with sharing ").append(name).append("{").append("\n");
			classBuilder.append("public ").append(name).append("()").append("{}").append("\n");
			classBuilder.append("}");
			break;

		case TEST:
			classBuilder.append("@isTest").append("\n");
			classBuilder.append("public class ").append(name).append("{");
			classBuilder.append("@isTest static void Test1 {").append("\n").append("Test.startTest()").append("\n").append("Test.stopTest()").append("\n");
			classBuilder.append("}");
			break;
		
		case BATCH:
			classBuilder.append("global class ").append(name).append(" implements Database.Batchable<sObject>").append("{").append("\n");
			classBuilder.append("String query;").append("\n");
			classBuilder.append("global BatchTemplate() {").append("\n");
			classBuilder.append("}").append("\n");
			classBuilder.append("global Database.QueryLocator start(Database.BatchableContext BC) {").append("\n");
			classBuilder.append("return Database.getQueryLocator(query);").append("\n");
			classBuilder.append("}").append("\n");
		   	classBuilder.append("global void execute(Database.BatchableContext BC, List<sObject> scope) {").append("\n");
			classBuilder.append("}").append("\n");
			classBuilder.append("global void finish(Database.BatchableContext BC) {").append("\n");
			classBuilder.append("}").append("\n");
			classBuilder.append("}");
			break;
			
		case SCHED:
			classBuilder.append("global class ").append(name).append(" implements Schedulable {").append("\n");
			classBuilder.append("global void execute(SchedulableContext SC) {").append("\n");
			classBuilder.append("}").append("\n");
			classBuilder.append("}");
			break;
		
		case EMAIL:
			classBuilder.append("global class ").append(name).append(" implements Messaging.InboundEmailHandler {").append("\n");
			classBuilder.append("global Messaging.InboundEmailResult handleInboundEmail(Messaging.inboundEmail email,Messaging.InboundEnvelope env) {").append("\n");
			classBuilder.append("Messaging.InboundEmailResult result = new Messaging.InboundEmailResult();").append("\n");
			classBuilder.append("String myPlainText= '';").append("\n");
			classBuilder.append("myPlainText = email.plainTextBody;").append("\n");
			classBuilder.append("result.success = true;").append("\n");
			classBuilder.append("return result;").append("\n");
			classBuilder.append("}").append("\n");
			classBuilder.append("}");
			break;
			
		case EXCEPTION:
			classBuilder.append("public class ").append(name).append(" extends Exception{").append("\n \n");
			classBuilder.append("}");
			break;
		case EMPTY:
			classBuilder.append("public class ").append(name).append(" {").append("\n \n").append("}");
			break;
			
		}
		return classBuilder.toString();
	}
	
	public String componentStub(String name)
	{
		StringBuilder componentBuilder = new StringBuilder();
		componentBuilder.append("<apex:component>").append("\n").append("<apex:component>");
		return componentBuilder.toString();
	}
	
	public String triggerHandler(String name, List<String> operation)
	{
		StringBuilder triggerHandlerBuilder = new StringBuilder();
		triggerHandlerBuilder.append("public with sharing class ").append(name).append(" {").append("\n");
		triggerHandlerBuilder.append("private boolean m_isExecuting = false;").append("\n");
		triggerHandlerBuilder.append("private integer BatchSize = 0;").append("\n");
		triggerHandlerBuilder.append("public ").append(name).append("boolean isExecuting, integer size){").append("\n");
		triggerHandlerBuilder.append("m_isExecuting = isExecuting;").append("\n");
		triggerHandlerBuilder.append("BatchSize = size;").append("\n");
		triggerHandlerBuilder.append("}").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		triggerHandlerBuilder.append("").append("\n");
		
		return "";
	}

}
