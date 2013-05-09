package com.example.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * Generated from information gathered from /services/data/v27.0/sobjects/Opportunity/describe
 */

public class Opportunity implements java.io.Serializable {
    public static boolean CREATEABLE = true;
    public static boolean DELETABLE = true;
    public static boolean UPDATEABLE = true;

    private Long dbid;
    @JsonProperty(value="Id")
    private String id;
    @JsonProperty(value="IsDeleted")
    private Boolean isDeleted;
    @JsonProperty(value="AccountId")
    private String accountId;
    @JsonProperty(value="RecordTypeId")
    private String recordTypeId;
    @JsonProperty(value="Name")
    private String name;
    @JsonProperty(value="Description")
    private String description;
    @JsonProperty(value="StageName")
    private String stageName;
    @JsonProperty(value="Amount")
    private String amount;
    @JsonProperty(value="Probability")
    private String probability;
    @JsonProperty(value="ExpectedRevenue")
    private String expectedRevenue;
    @JsonProperty(value="CloseDate")
    private Date closeDate;
    @JsonProperty(value="Type")
    private String type;
    @JsonProperty(value="NextStep")
    private String nextStep;
    @JsonProperty(value="LeadSource")
    private String leadSource;
    @JsonProperty(value="IsClosed")
    private Boolean isClosed;
    @JsonProperty(value="IsWon")
    private Boolean isWon;
    @JsonProperty(value="ForecastCategory")
    private String forecastCategory;
    @JsonProperty(value="ForecastCategoryName")
    private String forecastCategoryName;
    @JsonProperty(value="CampaignId")
    private String campaignId;
    @JsonProperty(value="HasOpportunityLineItem")
    private Boolean hasOpportunityLineItem;
    @JsonProperty(value="Pricebook2Id")
    private String pricebook2Id;
    @JsonProperty(value="OwnerId")
    private String ownerId;
    @JsonProperty(value="CreatedDate")
    private String createdDate;
    @JsonProperty(value="CreatedById")
    private String createdById;
    @JsonProperty(value="LastModifiedDate")
    private String lastModifiedDate;
    @JsonProperty(value="LastModifiedById")
    private String lastModifiedById;
    @JsonProperty(value="SystemModstamp")
    private String systemModstamp;
    @JsonProperty(value="LastActivityDate")
    private String lastActivityDate;
    @JsonProperty(value="FiscalQuarter")
    private Integer fiscalQuarter;
    @JsonProperty(value="FiscalYear")
    private Integer fiscalYear;
    @JsonProperty(value="Fiscal")
    private String fiscal;
    @JsonProperty(value="ConnectionReceivedId")
    private String connectionReceivedId;
    @JsonProperty(value="ConnectionSentId")
    private String connectionSentId;
    @JsonProperty(value="External_Opportunity_ID__c")
    private Double external_Opportunity_ID__c;
    @JsonProperty(value="Sales_Assist__c")
    private String sales_Assist__c;
    @JsonProperty(value="Billed_On_Date__c")
    private String billed_On_Date__c;
    @JsonProperty(value="CouponCode__c")
    private String couponCode__c;
    @JsonProperty(value="Incorporation_Type__c")
    private String incorporation_Type__c;
    @JsonProperty(value="Partner_Type__c")
    private String partner_Type__c;
    @JsonProperty(value="RequestID__c")
    private String requestID__c;
    @JsonProperty(value="ObjectInstanceID__c")
    private String objectInstanceID__c;
    @JsonProperty(value="ObjectType__c")
    private String objectType__c;
    @JsonProperty(value="OpenDate__c")
    private String openDate__c;
    @JsonProperty(value="Status__c")
    private String status__c;
    @JsonProperty(value="TrialStartDate__c")
    private String trialStartDate__c;
    @JsonProperty(value="Stage_BD__c")
    private String stage_BD__c;
    @JsonProperty(value="DB_Competitor__c")
    private String dB_Competitor__c;
    @JsonProperty(value="PrimaryProductFamily__c")
    private String primaryProductFamily__c;
    @JsonProperty(value="Call_Disposition__c")
    private String call_Disposition__c;
    @JsonProperty(value="Mark_Favorite__c")
    private Boolean mark_Favorite__c;
    @JsonProperty(value="Sales_Stage__c")
    private String sales_Stage__c;
    @JsonProperty(value="MotivatingProductFamily__c")
    private String motivatingProductFamily;
    @JsonProperty(value="Customer_Action__c")
    private String customer_Action__c;
    @JsonProperty(value="UUID__c")
    private String uUID__c;
    @JsonProperty(value="Revenue_Credit__c")
    private String revenue_Credit__c;
    @JsonProperty(value="Legal_Issue__c")
    private String legal_Issue__c;

    /**
     * Constructor.
     */
    public Opportunity() { }

    /**
     * Constructor with required fields.
     */
    public Opportunity(String stageName, Date closeDate, String name) {
        this.stageName = stageName;
        this.closeDate = closeDate;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbId", unique = true, nullable = false)
    public Long getdbId() {
        return dbid;
    }
    public void setdbId(Long dbid) {
        this.dbid = dbid;
    }
    @XmlAttribute(name = "Id")
    @Column(name = "Id")
    public String getId() {
        return id;
    }
    @XmlAttribute(name = "IsDeleted")
    @Column(name = "IsDeleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }
    @XmlAttribute(name = "AccountId")
    @Column(name = "AccountId")
    public String getAccountId() {
        return accountId;
    }
    @XmlAttribute(name = "RecordTypeId")
    @Column(name = "RecordTypeId")
    public String getRecordTypeId() {
        return recordTypeId;
    }
    @XmlAttribute(name = "Name")
    @Column(name = "Name")
    public String getName() {
        return name;
    }
    @XmlAttribute(name = "Description")
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }
    @XmlAttribute(name = "StageName")
    @Column(name = "StageName")
    public String getStageName() {
        return stageName;
    }
    @XmlAttribute(name = "Amount")
    @Column(name = "Amount")
    public String getAmount() {
        return amount;
    }
    @XmlAttribute(name = "Probability")
    @Column(name = "Probability")
    public String getProbability() {
        return probability;
    }
    @XmlAttribute(name = "ExpectedRevenue")
    @Column(name = "ExpectedRevenue")
    public String getExpectedRevenue() {
        return expectedRevenue;
    }
    @XmlAttribute(name = "CloseDate")
    @Column(name = "CloseDate")
    public Date getCloseDate() {
        return closeDate;
    }
    @XmlAttribute(name = "Type")
    @Column(name = "Type")
    public String getType() {
        return type;
    }
    @XmlAttribute(name = "NextStep")
    @Column(name = "NextStep")
    public String getNextStep() {
        return nextStep;
    }
    @XmlAttribute(name = "LeadSource")
    @Column(name = "LeadSource")
    public String getLeadSource() {
        return leadSource;
    }
    @XmlAttribute(name = "IsClosed")
    @Column(name = "IsClosed")
    public Boolean getIsClosed() {
        return isClosed;
    }
    @XmlAttribute(name = "IsWon")
    @Column(name = "IsWon")
    public Boolean getIsWon() {
        return isWon;
    }
    @XmlAttribute(name = "ForecastCategory")
    @Column(name = "ForecastCategory")
    public String getForecastCategory() {
        return forecastCategory;
    }
    @XmlAttribute(name = "ForecastCategoryName")
    @Column(name = "ForecastCategoryName")
    public String getForecastCategoryName() {
        return forecastCategoryName;
    }
    @XmlAttribute(name = "CampaignId")
    @Column(name = "CampaignId")
    public String getCampaignId() {
        return campaignId;
    }
    @XmlAttribute(name = "HasOpportunityLineItem")
    @Column(name = "HasOpportunityLineItem")
    public Boolean getHasOpportunityLineItem() {
        return hasOpportunityLineItem;
    }
    @XmlAttribute(name = "Pricebook2Id")
    @Column(name = "Pricebook2Id")
    public String getPricebook2Id() {
        return pricebook2Id;
    }
    @XmlAttribute(name = "OwnerId")
    @Column(name = "OwnerId")
    public String getOwnerId() {
        return ownerId;
    }
    @XmlAttribute(name = "CreatedDate")
    @Column(name = "CreatedDate")
    public String getCreatedDate() {
        return createdDate;
    }
    @XmlAttribute(name = "CreatedById")
    @Column(name = "CreatedById")
    public String getCreatedById() {
        return createdById;
    }
    @XmlAttribute(name = "LastModifiedDate")
    @Column(name = "LastModifiedDate")
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    @XmlAttribute(name = "LastModifiedById")
    @Column(name = "LastModifiedById")
    public String getLastModifiedById() {
        return lastModifiedById;
    }
    @XmlAttribute(name = "SystemModstamp")
    @Column(name = "SystemModstamp")
    public String getSystemModstamp() {
        return systemModstamp;
    }
    @XmlAttribute(name = "LastActivityDate")
    @Column(name = "LastActivityDate")
    public String getLastActivityDate() {
        return lastActivityDate;
    }
    @XmlAttribute(name = "FiscalQuarter")
    @Column(name = "FiscalQuarter")
    public Integer getFiscalQuarter() {
        return fiscalQuarter;
    }
    @XmlAttribute(name = "FiscalYear")
    @Column(name = "FiscalYear")
    public Integer getFiscalYear() {
        return fiscalYear;
    }
    @XmlAttribute(name = "Fiscal")
    @Column(name = "Fiscal")
    public String getFiscal() {
        return fiscal;
    }
    @XmlAttribute(name = "ConnectionReceivedId")
    @Column(name = "ConnectionReceivedId")
    public String getConnectionReceivedId() {
        return connectionReceivedId;
    }
    @XmlAttribute(name = "ConnectionSentId")
    @Column(name = "ConnectionSentId")
    public String getConnectionSentId() {
        return connectionSentId;
    }
    @XmlAttribute(name = "External_Opportunity_ID__c")
    @Column(name = "External_Opportunity_ID__c")
    public Double getExternal_Opportunity_ID__c() {
        return external_Opportunity_ID__c;
    }
    /**
     * alias for #getExternal_Opportunity_ID__c
     */
    public Double getExternal_Opportunity_ID() {
        return external_Opportunity_ID__c;
    }
    @XmlAttribute(name = "Sales_Assist__c")
    @Column(name = "Sales_Assist__c")
    public String getSales_Assist__c() {
        return sales_Assist__c;
    }
    /**
     * alias for #getSales_Assist__c
     */
    public String getSales_Assist() {
        return sales_Assist__c;
    }
    @XmlAttribute(name = "Billed_On_Date__c")
    @Column(name = "Billed_On_Date__c")
    public String getBilled_On_Date__c() {
        return billed_On_Date__c;
    }
    /**
     * alias for #getBilled_On_Date__c
     */
    public String getBilled_On_Date() {
        return billed_On_Date__c;
    }
    @XmlAttribute(name = "CouponCode__c")
    @Column(name = "CouponCode__c")
    public String getCouponCode__c() {
        return couponCode__c;
    }
    /**
     * alias for #getCouponCode__c
     */
    public String getCouponCode() {
        return couponCode__c;
    }
    @XmlAttribute(name = "Incorporation_Type__c")
    @Column(name = "Incorporation_Type__c")
    public String getIncorporation_Type__c() {
        return incorporation_Type__c;
    }
    /**
     * alias for #getIncorporation_Type__c
     */
    public String getIncorporation_Type() {
        return incorporation_Type__c;
    }
    @XmlAttribute(name = "Partner_Type__c")
    @Column(name = "Partner_Type__c")
    public String getPartner_Type__c() {
        return partner_Type__c;
    }
    /**
     * alias for #getPartner_Type__c
     */
    public String getPartner_Type() {
        return partner_Type__c;
    }
    @XmlAttribute(name = "RequestID__c")
    @Column(name = "RequestID__c")
    public String getRequestID__c() {
        return requestID__c;
    }
    /**
     * alias for #getRequestID__c
     */
    public String getRequestID() {
        return requestID__c;
    }
    @XmlAttribute(name = "ObjectInstanceID__c")
    @Column(name = "ObjectInstanceID__c")
    public String getObjectInstanceID__c() {
        return objectInstanceID__c;
    }
    /**
     * alias for #getObjectInstanceID__c
     */
    public String getObjectInstanceID() {
        return objectInstanceID__c;
    }
    @XmlAttribute(name = "ObjectType__c")
    @Column(name = "ObjectType__c")
    public String getObjectType__c() {
        return objectType__c;
    }
    /**
     * alias for #getObjectType__c
     */
    public String getObjectType() {
        return objectType__c;
    }
    @XmlAttribute(name = "OpenDate__c")
    @Column(name = "OpenDate__c")
    public String getOpenDate__c() {
        return openDate__c;
    }
    /**
     * alias for #getOpenDate__c
     */
    public String getOpenDate() {
        return openDate__c;
    }
    @XmlAttribute(name = "Status__c")
    @Column(name = "Status__c")
    public String getStatus__c() {
        return status__c;
    }
    /**
     * alias for #getStatus__c
     */
    public String getStatus() {
        return status__c;
    }
    @XmlAttribute(name = "TrialStartDate__c")
    @Column(name = "TrialStartDate__c")
    public String getTrialStartDate__c() {
        return trialStartDate__c;
    }
    /**
     * alias for #getTrialStartDate__c
     */
    public String getTrialStartDate() {
        return trialStartDate__c;
    }
    @XmlAttribute(name = "Stage_BD__c")
    @Column(name = "Stage_BD__c")
    public String getStage_BD__c() {
        return stage_BD__c;
    }
    /**
     * alias for #getStage_BD__c
     */
    public String getStage_BD() {
        return stage_BD__c;
    }
    @XmlAttribute(name = "DB_Competitor__c")
    @Column(name = "DB_Competitor__c")
    public String getDB_Competitor__c() {
        return dB_Competitor__c;
    }
    /**
     * alias for #getDB_Competitor__c
     */
    public String getDB_Competitor() {
        return dB_Competitor__c;
    }
    @XmlAttribute(name = "PrimaryProductFamily__c")
    @Column(name = "PrimaryProductFamily__c")
    public String getPrimaryProductFamily__c() {
        return primaryProductFamily__c;
    }
    /**
     * alias for #getPrimaryProductFamily__c
     */
    public String getPrimaryProductFamily() {
        return primaryProductFamily__c;
    }
    @XmlAttribute(name = "Call_Disposition__c")
    @Column(name = "Call_Disposition__c")
    public String getCall_Disposition__c() {
        return call_Disposition__c;
    }
    /**
     * alias for #getCall_Disposition__c
     */
    public String getCall_Disposition() {
        return call_Disposition__c;
    }
    @XmlAttribute(name = "Mark_Favorite__c")
    @Column(name = "Mark_Favorite__c")
    public Boolean getMark_Favorite__c() {
        return mark_Favorite__c;
    }
    /**
     * alias for #getMark_Favorite__c
     */
    public Boolean getMark_Favorite() {
        return mark_Favorite__c;
    }
    @XmlAttribute(name = "Sales_Stage__c")
    @Column(name = "Sales_Stage__c")
    public String getSales_Stage__c() {
        return sales_Stage__c;
    }
    /**
     * alias for #getSales_Stage__c
     */
    public String getSales_Stage() {
        return sales_Stage__c;
    }
    @XmlAttribute(name = "MotivatingProductFamily__c")
    @Column(name = "MotivatingProductFamily__c")
    public String getMotivatingProductFamily__c() {
        return motivatingProductFamily;
    }
    /**
     * alias for #getMotivatingProductFamily__c
     */
    public String getMotivatingProductFamily() {
        return motivatingProductFamily;
    }
    @XmlAttribute(name = "Customer_Action__c")
    @Column(name = "Customer_Action__c")
    public String getCustomer_Action__c() {
        return customer_Action__c;
    }
    /**
     * alias for #getCustomer_Action__c
     */
    public String getCustomer_Action() {
        return customer_Action__c;
    }
    @XmlAttribute(name = "UUID__c")
    @Column(name = "UUID__c")
    public String getUUID__c() {
        return uUID__c;
    }
    /**
     * alias for #getUUID__c
     */
    public String getUUID() {
        return uUID__c;
    }
    @XmlAttribute(name = "Revenue_Credit__c")
    @Column(name = "Revenue_Credit__c")
    public String getRevenue_Credit__c() {
        return revenue_Credit__c;
    }
    /**
     * alias for #getRevenue_Credit__c
     */
    public String getRevenue_Credit() {
        return revenue_Credit__c;
    }
    @XmlAttribute(name = "Legal_Issue__c")
    @Column(name = "Legal_Issue__c")
    public String getLegal_Issue__c() {
        return legal_Issue__c;
    }
    /**
     * alias for #getLegal_Issue__c
     */
    public String getLegal_Issue() {
        return legal_Issue__c;
    }
    /**
     * Id is an optional field.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * IsDeleted is an optional field.
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    /**
     * AccountId is a reference to a parent entity.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    /**
     * RecordTypeId is a reference to a parent entity.
     */
    public void setRecordTypeId(String recordTypeId) {
        this.recordTypeId = recordTypeId;
    }
    /**
     * Name is a required field.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Description is an optional field.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * StageName is a required field.
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
    /**
     * Amount is an optional field.
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }
    /**
     * Probability is an optional field.
     */
    public void setProbability(String probability) {
        this.probability = probability;
    }
    /**
     * ExpectedRevenue is an optional field.
     */
    public void setExpectedRevenue(String expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }
    /**
     * CloseDate is a required field.
     */
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
    /**
     * Type is an optional field.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * NextStep is an optional field.
     */
    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }
    /**
     * LeadSource is an optional field.
     */
    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }
    /**
     * IsClosed is an optional field.
     */
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }
    /**
     * IsWon is an optional field.
     */
    public void setIsWon(Boolean isWon) {
        this.isWon = isWon;
    }
    /**
     * ForecastCategory is a required field.
     */
    public void setForecastCategory(String forecastCategory) {
        this.forecastCategory = forecastCategory;
    }
    /**
     * ForecastCategoryName is an optional field.
     */
    public void setForecastCategoryName(String forecastCategoryName) {
        this.forecastCategoryName = forecastCategoryName;
    }
    /**
     * CampaignId is a reference to a parent entity.
     */
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }
    /**
     * HasOpportunityLineItem is an optional field.
     */
    public void setHasOpportunityLineItem(Boolean hasOpportunityLineItem) {
        this.hasOpportunityLineItem = hasOpportunityLineItem;
    }
    /**
     * Pricebook2Id is a reference to a parent entity.
     */
    public void setPricebook2Id(String pricebook2Id) {
        this.pricebook2Id = pricebook2Id;
    }
    /**
     * OwnerId is a reference to a parent entity.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * CreatedDate is an optional field.
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    /**
     * CreatedById is a reference to a parent entity.
     */
    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }
    /**
     * LastModifiedDate is an optional field.
     */
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    /**
     * LastModifiedById is a reference to a parent entity.
     */
    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }
    /**
     * SystemModstamp is an optional field.
     */
    public void setSystemModstamp(String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }
    /**
     * LastActivityDate is an optional field.
     */
    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }
    /**
     * FiscalQuarter is an optional field.
     */
    public void setFiscalQuarter(Integer fiscalQuarter) {
        this.fiscalQuarter = fiscalQuarter;
    }
    /**
     * FiscalYear is an optional field.
     */
    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    /**
     * Fiscal is an optional field.
     */
    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }
    /**
     * ConnectionReceivedId is a reference to a parent entity.
     */
    public void setConnectionReceivedId(String connectionReceivedId) {
        this.connectionReceivedId = connectionReceivedId;
    }
    /**
     * ConnectionSentId is a reference to a parent entity.
     */
    public void setConnectionSentId(String connectionSentId) {
        this.connectionSentId = connectionSentId;
    }
    /**
     * External_Opportunity_ID__c is an optional field.
     */
    public void setExternal_Opportunity_ID__c(Double external_Opportunity_ID__c) {
        this.external_Opportunity_ID__c = external_Opportunity_ID__c;
    }
    /**
     * alias for #setExternal_Opportunity_ID__c
     */
    public void setExternal_Opportunity_ID(Double external_Opportunity_ID__c) { 
        this.external_Opportunity_ID__c = external_Opportunity_ID__c;
    }
    /**
     * Sales_Assist__c is a reference to a parent entity.
     */
    public void setSales_Assist__c(String sales_Assist__c) {
        this.sales_Assist__c = sales_Assist__c;
    }
    /**
     * alias for #setSales_Assist__c
     */
    public void setSales_Assist(String sales_Assist__c) { 
        this.sales_Assist__c = sales_Assist__c;
    }
    /**
     * Billed_On_Date__c is an optional field.
     */
    public void setBilled_On_Date__c(String billed_On_Date__c) {
        this.billed_On_Date__c = billed_On_Date__c;
    }
    /**
     * alias for #setBilled_On_Date__c
     */
    public void setBilled_On_Date(String billed_On_Date__c) { 
        this.billed_On_Date__c = billed_On_Date__c;
    }
    /**
     * CouponCode__c is an optional field.
     */
    public void setCouponCode__c(String couponCode__c) {
        this.couponCode__c = couponCode__c;
    }
    /**
     * alias for #setCouponCode__c
     */
    public void setCouponCode(String couponCode__c) { 
        this.couponCode__c = couponCode__c;
    }
    /**
     * Incorporation_Type__c is an optional field.
     */
    public void setIncorporation_Type__c(String incorporation_Type__c) {
        this.incorporation_Type__c = incorporation_Type__c;
    }
    /**
     * alias for #setIncorporation_Type__c
     */
    public void setIncorporation_Type(String incorporation_Type__c) { 
        this.incorporation_Type__c = incorporation_Type__c;
    }
    /**
     * Partner_Type__c is an optional field.
     */
    public void setPartner_Type__c(String partner_Type__c) {
        this.partner_Type__c = partner_Type__c;
    }
    /**
     * alias for #setPartner_Type__c
     */
    public void setPartner_Type(String partner_Type__c) { 
        this.partner_Type__c = partner_Type__c;
    }
    /**
     * RequestID__c is an optional field.
     */
    public void setRequestID__c(String requestID__c) {
        this.requestID__c = requestID__c;
    }
    /**
     * alias for #setRequestID__c
     */
    public void setRequestID(String requestID__c) { 
        this.requestID__c = requestID__c;
    }
    /**
     * ObjectInstanceID__c is an optional field.
     */
    public void setObjectInstanceID__c(String objectInstanceID__c) {
        this.objectInstanceID__c = objectInstanceID__c;
    }
    /**
     * alias for #setObjectInstanceID__c
     */
    public void setObjectInstanceID(String objectInstanceID__c) { 
        this.objectInstanceID__c = objectInstanceID__c;
    }
    /**
     * ObjectType__c is an optional field.
     */
    public void setObjectType__c(String objectType__c) {
        this.objectType__c = objectType__c;
    }
    /**
     * alias for #setObjectType__c
     */
    public void setObjectType(String objectType__c) { 
        this.objectType__c = objectType__c;
    }
    /**
     * OpenDate__c is an optional field.
     */
    public void setOpenDate__c(String openDate__c) {
        this.openDate__c = openDate__c;
    }
    /**
     * alias for #setOpenDate__c
     */
    public void setOpenDate(String openDate__c) { 
        this.openDate__c = openDate__c;
    }
    /**
     * Status__c is an optional field.
     */
    public void setStatus__c(String status__c) {
        this.status__c = status__c;
    }
    /**
     * alias for #setStatus__c
     */
    public void setStatus(String status__c) { 
        this.status__c = status__c;
    }
    /**
     * TrialStartDate__c is an optional field.
     */
    public void setTrialStartDate__c(String trialStartDate__c) {
        this.trialStartDate__c = trialStartDate__c;
    }
    /**
     * alias for #setTrialStartDate__c
     */
    public void setTrialStartDate(String trialStartDate__c) { 
        this.trialStartDate__c = trialStartDate__c;
    }
    /**
     * Stage_BD__c is an optional field.
     */
    public void setStage_BD__c(String stage_BD__c) {
        this.stage_BD__c = stage_BD__c;
    }
    /**
     * alias for #setStage_BD__c
     */
    public void setStage_BD(String stage_BD__c) { 
        this.stage_BD__c = stage_BD__c;
    }
    /**
     * DB_Competitor__c is an optional field.
     */
    public void setDB_Competitor__c(String dB_Competitor__c) {
        this.dB_Competitor__c = dB_Competitor__c;
    }
    /**
     * alias for #setDB_Competitor__c
     */
    public void setDB_Competitor(String dB_Competitor__c) { 
        this.dB_Competitor__c = dB_Competitor__c;
    }
    /**
     * PrimaryProductFamily__c is an optional field.
     */
    public void setPrimaryProductFamily__c(String primaryProductFamily__c) {
        this.primaryProductFamily__c = primaryProductFamily__c;
    }
    /**
     * alias for #setPrimaryProductFamily__c
     */
    public void setPrimaryProductFamily(String primaryProductFamily__c) { 
        this.primaryProductFamily__c = primaryProductFamily__c;
    }
    /**
     * Call_Disposition__c is an optional field.
     */
    public void setCall_Disposition__c(String call_Disposition__c) {
        this.call_Disposition__c = call_Disposition__c;
    }
    /**
     * alias for #setCall_Disposition__c
     */
    public void setCall_Disposition(String call_Disposition__c) { 
        this.call_Disposition__c = call_Disposition__c;
    }
    /**
     * Mark_Favorite__c is an optional field.
     */
    public void setMark_Favorite__c(Boolean mark_Favorite__c) {
        this.mark_Favorite__c = mark_Favorite__c;
    }
    /**
     * alias for #setMark_Favorite__c
     */
    public void setMark_Favorite(Boolean mark_Favorite__c) { 
        this.mark_Favorite__c = mark_Favorite__c;
    }
    /**
     * Sales_Stage__c is an optional field.
     */
    public void setSales_Stage__c(String sales_Stage__c) {
        this.sales_Stage__c = sales_Stage__c;
    }
    /**
     * alias for #setSales_Stage__c
     */
    public void setSales_Stage(String sales_Stage__c) { 
        this.sales_Stage__c = sales_Stage__c;
    }
    /**
     * MotivatingProductFamily__c is an optional field.
     */
    public void setMotivatingProductFamily__c(String motivatingProductFamily__c) {
        this.motivatingProductFamily = motivatingProductFamily__c;
    }
    /**
     * alias for #setMotivatingProductFamily__c
     */
    public void setMotivatingProductFamily(String motivatingProductFamily__c) { 
        this.motivatingProductFamily = motivatingProductFamily__c;
    }
    /**
     * Customer_Action__c is an optional field.
     */
    public void setCustomer_Action__c(String customer_Action__c) {
        this.customer_Action__c = customer_Action__c;
    }
    /**
     * alias for #setCustomer_Action__c
     */
    public void setCustomer_Action(String customer_Action__c) { 
        this.customer_Action__c = customer_Action__c;
    }
    /**
     * UUID__c is an optional field.
     */
    public void setUUID__c(String uUID__c) {
        this.uUID__c = uUID__c;
    }
    /**
     * alias for #setUUID__c
     */
    public void setUUID(String uUID__c) { 
        this.uUID__c = uUID__c;
    }
    /**
     * Revenue_Credit__c is an optional field.
     */
    public void setRevenue_Credit__c(String revenue_Credit__c) {
        this.revenue_Credit__c = revenue_Credit__c;
    }
    /**
     * alias for #setRevenue_Credit__c
     */
    public void setRevenue_Credit(String revenue_Credit__c) { 
        this.revenue_Credit__c = revenue_Credit__c;
    }
    /**
     * Legal_Issue__c is an optional field.
     */
    public void setLegal_Issue__c(String legal_Issue__c) {
        this.legal_Issue__c = legal_Issue__c;
    }
    /**
     * alias for #setLegal_Issue__c
     */
    public void setLegal_Issue(String legal_Issue__c) { 
        this.legal_Issue__c = legal_Issue__c;
    }

    @Override
    public String toString(){
    return ToStringBuilder.reflectionToString(this);}
}
