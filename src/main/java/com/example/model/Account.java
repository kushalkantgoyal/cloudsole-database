package com.example.model;

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
 * Generated from information gathered from /services/data/27.0/sobjects/Account/describe
 */
@Entity
@XmlRootElement(name = "Account")
@Table(name = "Account")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Account implements java.io.Serializable {
    public static boolean CREATEABLE = true;
    public static boolean DELETABLE = true;
    public static boolean UPDATEABLE = true;

    private Long dbid;
    @JsonProperty(value="Id")
    private String id;
    @JsonProperty(value="IsDeleted")
    private Boolean isDeleted;
    @JsonProperty(value="MasterRecordId")
    private String masterRecordId;
    @JsonProperty(value="Name")
    private String name;
    @JsonProperty(value="Type")
    private String type;
    @JsonProperty(value="ParentId")
    private String parentId;
    @JsonProperty(value="BillingStreet")
    private String billingStreet;
    @JsonProperty(value="BillingCity")
    private String billingCity;
    @JsonProperty(value="BillingState")
    private String billingState;
    @JsonProperty(value="BillingPostalCode")
    private String billingPostalCode;
    @JsonProperty(value="BillingCountry")
    private String billingCountry;
    @JsonProperty(value="ShippingStreet")
    private String shippingStreet;
    @JsonProperty(value="ShippingCity")
    private String shippingCity;
    @JsonProperty(value="ShippingState")
    private String shippingState;
    @JsonProperty(value="ShippingPostalCode")
    private String shippingPostalCode;
    @JsonProperty(value="ShippingCountry")
    private String shippingCountry;
    @JsonProperty(value="Phone")
    private String phone;
    @JsonProperty(value="Fax")
    private String fax;
    @JsonProperty(value="AccountNumber")
    private String accountNumber;
    @JsonProperty(value="Website")
    private String website;
    @JsonProperty(value="Sic")
    private String sic;
    @JsonProperty(value="Industry")
    private String industry;
    @JsonProperty(value="AnnualRevenue")
    private String annualRevenue;
    @JsonProperty(value="NumberOfEmployees")
    private Integer numberOfEmployees;
    @JsonProperty(value="Ownership")
    private String ownership;
    @JsonProperty(value="TickerSymbol")
    private String tickerSymbol;
    @JsonProperty(value="Description")
    private String description;
    @JsonProperty(value="Rating")
    private String rating;
    @JsonProperty(value="Site")
    private String site;
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
    @JsonProperty(value="IsPartner")
    private Boolean isPartner;
    @JsonProperty(value="IsCustomerPortal")
    private Boolean isCustomerPortal;
    @JsonProperty(value="Jigsaw")
    private String jigsaw;
    @JsonProperty(value="JigsawCompanyId")
    private String jigsawCompanyId;
    @JsonProperty(value="CustomerPriority__c")
    private String customerPriority;
    @JsonProperty(value="SLA__c")
    private String sLA;
    @JsonProperty(value="Active__c")
    private String active;
    @JsonProperty(value="NumberofLocations__c")
    private Double numberofLocations;
    @JsonProperty(value="UpsellOpportunity__c")
    private String upsellOpportunity;
    @JsonProperty(value="SLASerialNumber__c")
    private String sLASerialNumber;
    @JsonProperty(value="SLAExpirationDate__c")
    private String sLAExpirationDate;

    /**
     * Constructor.
     */
    public Account() { }

    /**
     * Constructor with required fields.
     */
    public Account(String id, Boolean isDeleted, String masterRecordId, String name, String type, String parentId, String billingStreet, String billingCity, String billingState, String billingPostalCode, String billingCountry, String shippingStreet, String shippingCity, String shippingState, String shippingPostalCode, String shippingCountry, String phone, String fax, String accountNumber, String website, String sic, String industry, String annualRevenue, Integer numberOfEmployees, String ownership, String tickerSymbol, String description, String rating, String site, String ownerId, String createdDate, String createdById, String lastModifiedDate, String lastModifiedById, String systemModstamp, String lastActivityDate, Boolean isPartner, Boolean isCustomerPortal, String jigsaw, String jigsawCompanyId, String customerPriority, String sLA, String active, Double numberofLocations, String upsellOpportunity, String sLASerialNumber, String sLAExpirationDate) {
        this.id = id;
        this.isDeleted = isDeleted;
        this.masterRecordId = masterRecordId;
        this.name = name;
        this.type = type;
        this.parentId = parentId;
        this.billingStreet = billingStreet;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingPostalCode = billingPostalCode;
        this.billingCountry = billingCountry;
        this.shippingStreet = shippingStreet;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingPostalCode = shippingPostalCode;
        this.shippingCountry = shippingCountry;
        this.phone = phone;
        this.fax = fax;
        this.accountNumber = accountNumber;
        this.website = website;
        this.sic = sic;
        this.industry = industry;
        this.annualRevenue = annualRevenue;
        this.numberOfEmployees = numberOfEmployees;
        this.ownership = ownership;
        this.tickerSymbol = tickerSymbol;
        this.description = description;
        this.rating = rating;
        this.site = site;
        this.ownerId = ownerId;
        this.createdDate = createdDate;
        this.createdById = createdById;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedById = lastModifiedById;
        this.systemModstamp = systemModstamp;
        this.lastActivityDate = lastActivityDate;
        this.isPartner = isPartner;
        this.isCustomerPortal = isCustomerPortal;
        this.jigsaw = jigsaw;
        this.jigsawCompanyId = jigsawCompanyId;
        this.customerPriority = customerPriority;
        this.sLA = sLA;
        this.active = active;
        this.numberofLocations = numberofLocations;
        this.upsellOpportunity = upsellOpportunity;
        this.sLASerialNumber = sLASerialNumber;
        this.sLAExpirationDate = sLAExpirationDate;
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
    @XmlAttribute(name = "MasterRecordId")
    @Column(name = "MasterRecordId")
    public String getMasterRecordId() {
        return masterRecordId;
    }
    @XmlAttribute(name = "Name")
    @Column(name = "Name")
    public String getName() {
        return name;
    }
    @XmlAttribute(name = "Type")
    @Column(name = "Type")
    public String getType() {
        return type;
    }
    @XmlAttribute(name = "ParentId")
    @Column(name = "ParentId")
    public String getParentId() {
        return parentId;
    }
    @XmlAttribute(name = "BillingStreet")
    @Column(name = "BillingStreet")
    public String getBillingStreet() {
        return billingStreet;
    }
    @XmlAttribute(name = "BillingCity")
    @Column(name = "BillingCity")
    public String getBillingCity() {
        return billingCity;
    }
    @XmlAttribute(name = "BillingState")
    @Column(name = "BillingState")
    public String getBillingState() {
        return billingState;
    }
    @XmlAttribute(name = "BillingPostalCode")
    @Column(name = "BillingPostalCode")
    public String getBillingPostalCode() {
        return billingPostalCode;
    }
    @XmlAttribute(name = "BillingCountry")
    @Column(name = "BillingCountry")
    public String getBillingCountry() {
        return billingCountry;
    }
    @XmlAttribute(name = "ShippingStreet")
    @Column(name = "ShippingStreet")
    public String getShippingStreet() {
        return shippingStreet;
    }
    @XmlAttribute(name = "ShippingCity")
    @Column(name = "ShippingCity")
    public String getShippingCity() {
        return shippingCity;
    }
    @XmlAttribute(name = "ShippingState")
    @Column(name = "ShippingState")
    public String getShippingState() {
        return shippingState;
    }
    @XmlAttribute(name = "ShippingPostalCode")
    @Column(name = "ShippingPostalCode")
    public String getShippingPostalCode() {
        return shippingPostalCode;
    }
    @XmlAttribute(name = "ShippingCountry")
    @Column(name = "ShippingCountry")
    public String getShippingCountry() {
        return shippingCountry;
    }
    @XmlAttribute(name = "Phone")
    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }
    @XmlAttribute(name = "Fax")
    @Column(name = "Fax")
    public String getFax() {
        return fax;
    }
    @XmlAttribute(name = "AccountNumber")
    @Column(name = "AccountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }
    @XmlAttribute(name = "Website")
    @Column(name = "Website")
    public String getWebsite() {
        return website;
    }
    @XmlAttribute(name = "Sic")
    @Column(name = "Sic")
    public String getSic() {
        return sic;
    }
    @XmlAttribute(name = "Industry")
    @Column(name = "Industry")
    public String getIndustry() {
        return industry;
    }
    @XmlAttribute(name = "AnnualRevenue")
    @Column(name = "AnnualRevenue")
    public String getAnnualRevenue() {
        return annualRevenue;
    }
    @XmlAttribute(name = "NumberOfEmployees")
    @Column(name = "NumberOfEmployees")
    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }
    @XmlAttribute(name = "Ownership")
    @Column(name = "Ownership")
    public String getOwnership() {
        return ownership;
    }
    @XmlAttribute(name = "TickerSymbol")
    @Column(name = "TickerSymbol")
    public String getTickerSymbol() {
        return tickerSymbol;
    }
    @XmlAttribute(name = "Description")
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }
    @XmlAttribute(name = "Rating")
    @Column(name = "Rating")
    public String getRating() {
        return rating;
    }
    @XmlAttribute(name = "Site")
    @Column(name = "Site")
    public String getSite() {
        return site;
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
    @XmlAttribute(name = "IsPartner")
    @Column(name = "IsPartner")
    public Boolean getIsPartner() {
        return isPartner;
    }
    @XmlAttribute(name = "IsCustomerPortal")
    @Column(name = "IsCustomerPortal")
    public Boolean getIsCustomerPortal() {
        return isCustomerPortal;
    }
    @XmlAttribute(name = "Jigsaw")
    @Column(name = "Jigsaw")
    public String getJigsaw() {
        return jigsaw;
    }
    @XmlAttribute(name = "JigsawCompanyId")
    @Column(name = "JigsawCompanyId")
    public String getJigsawCompanyId() {
        return jigsawCompanyId;
    }
    @XmlAttribute(name = "CustomerPriority__c")
    @Column(name = "CustomerPriority__c")
    public String getCustomerPriority__c() {
        return customerPriority;
    }
    @XmlAttribute(name = "SLA__c")
    @Column(name = "SLA__c")
    public String getSLA__c() {
        return sLA;
    }
    @XmlAttribute(name = "Active__c")
    @Column(name = "Active__c")
    public String getActive__c() {
        return active;
    }
    @XmlAttribute(name = "NumberofLocations__c")
    @Column(name = "NumberofLocations__c")
    public Double getNumberofLocations__c() {
        return numberofLocations;
    }
    @XmlAttribute(name = "UpsellOpportunity__c")
    @Column(name = "UpsellOpportunity__c")
    public String getUpsellOpportunity__c() {
        return upsellOpportunity;
    }
    @XmlAttribute(name = "SLASerialNumber__c")
    @Column(name = "SLASerialNumber__c")
    public String getSLASerialNumber__c() {
        return sLASerialNumber;
    }
    @XmlAttribute(name = "SLAExpirationDate__c")
    @Column(name = "SLAExpirationDate__c")
    public String getSLAExpirationDate__c() {
        return sLAExpirationDate;
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
     * MasterRecordId is a reference to a parent entity.
     */
    public void setMasterRecordId(String masterRecordId) {
        this.masterRecordId = masterRecordId;
    }
    /**
     * Name is a required field.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Type is an optional field.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * ParentId is a reference to a parent entity.
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    /**
     * BillingStreet is an optional field.
     */
    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }
    /**
     * BillingCity is an optional field.
     */
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }
    /**
     * BillingState is an optional field.
     */
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }
    /**
     * BillingPostalCode is an optional field.
     */
    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }
    /**
     * BillingCountry is an optional field.
     */
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }
    /**
     * ShippingStreet is an optional field.
     */
    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }
    /**
     * ShippingCity is an optional field.
     */
    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }
    /**
     * ShippingState is an optional field.
     */
    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }
    /**
     * ShippingPostalCode is an optional field.
     */
    public void setShippingPostalCode(String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }
    /**
     * ShippingCountry is an optional field.
     */
    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }
    /**
     * Phone is an optional field.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Fax is an optional field.
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**
     * AccountNumber is an optional field.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    /**
     * Website is an optional field.
     */
    public void setWebsite(String website) {
        this.website = website;
    }
    /**
     * Sic is an optional field.
     */
    public void setSic(String sic) {
        this.sic = sic;
    }
    /**
     * Industry is an optional field.
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    /**
     * AnnualRevenue is an optional field.
     */
    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
    /**
     * NumberOfEmployees is an optional field.
     */
    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
    /**
     * Ownership is an optional field.
     */
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    /**
     * TickerSymbol is an optional field.
     */
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }
    /**
     * Description is an optional field.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Rating is an optional field.
     */
    public void setRating(String rating) {
        this.rating = rating;
    }
    /**
     * Site is an optional field.
     */
    public void setSite(String site) {
        this.site = site;
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
     * IsPartner is an optional field.
     */
    public void setIsPartner(Boolean isPartner) {
        this.isPartner = isPartner;
    }
    /**
     * IsCustomerPortal is an optional field.
     */
    public void setIsCustomerPortal(Boolean isCustomerPortal) {
        this.isCustomerPortal = isCustomerPortal;
    }
    /**
     * Jigsaw is an optional field.
     */
    public void setJigsaw(String jigsaw) {
        this.jigsaw = jigsaw;
    }
    /**
     * JigsawCompanyId is a reference to a parent entity.
     */
    public void setJigsawCompanyId(String jigsawCompanyId) {
        this.jigsawCompanyId = jigsawCompanyId;
    }
    /**
     * CustomerPriority__c is an optional field.
     */
    public void setCustomerPriority__c(String customerPriority) {
        this.customerPriority = customerPriority;
    }
    /**
     * SLA__c is an optional field.
     */
    public void setSLA__c(String sLA) {
        this.sLA = sLA;
    }
    /**
     * Active__c is an optional field.
     */
    public void setActive__c(String active) {
        this.active = active;
    }
    /**
     * NumberofLocations__c is an optional field.
     */
    public void setNumberofLocations__c(Double numberofLocations) {
        this.numberofLocations = numberofLocations;
    }
    /**
     * UpsellOpportunity__c is an optional field.
     */
    public void setUpsellOpportunity__c(String upsellOpportunity) {
        this.upsellOpportunity = upsellOpportunity;
    }
    /**
     * SLASerialNumber__c is an optional field.
     */
    public void setSLASerialNumber__c(String sLASerialNumber) {
        this.sLASerialNumber = sLASerialNumber;
    }
    /**
     * SLAExpirationDate__c is an optional field.
     */
    public void setSLAExpirationDate__c(String sLAExpirationDate) {
        this.sLAExpirationDate = sLAExpirationDate;
    }

    @Override
    public String toString(){
    return ToStringBuilder.reflectionToString(this);}
}
