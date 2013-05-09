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
 * Generated from information gathered from /services/data/v27.0/sobjects/Contact/describe
 */

public class Contact implements java.io.Serializable {
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
    @JsonProperty(value="AccountId")
    private String accountId;
    @JsonProperty(value="LastName")
    private String lastName;
    @JsonProperty(value="FirstName")
    private String firstName;
    @JsonProperty(value="Salutation")
    private String salutation;
    @JsonProperty(value="Name")
    private String name;
    @JsonProperty(value="RecordTypeId")
    private String recordTypeId;
    @JsonProperty(value="OtherStreet")
    private String otherStreet;
    @JsonProperty(value="OtherCity")
    private String otherCity;
    @JsonProperty(value="OtherState")
    private String otherState;
    @JsonProperty(value="OtherPostalCode")
    private String otherPostalCode;
    @JsonProperty(value="OtherCountry")
    private String otherCountry;
    @JsonProperty(value="MailingStreet")
    private String mailingStreet;
    @JsonProperty(value="MailingCity")
    private String mailingCity;
    @JsonProperty(value="MailingState")
    private String mailingState;
    @JsonProperty(value="MailingPostalCode")
    private String mailingPostalCode;
    @JsonProperty(value="MailingCountry")
    private String mailingCountry;
    @JsonProperty(value="Phone")
    private String phone;
    @JsonProperty(value="Fax")
    private String fax;
    @JsonProperty(value="MobilePhone")
    private String mobilePhone;
    @JsonProperty(value="HomePhone")
    private String homePhone;
    @JsonProperty(value="OtherPhone")
    private String otherPhone;
    @JsonProperty(value="AssistantPhone")
    private String assistantPhone;
    @JsonProperty(value="ReportsToId")
    private String reportsToId;
    @JsonProperty(value="Email")
    private String email;
    @JsonProperty(value="Title")
    private String title;
    @JsonProperty(value="Department")
    private String department;
    @JsonProperty(value="AssistantName")
    private String assistantName;
    @JsonProperty(value="LeadSource")
    private String leadSource;
    @JsonProperty(value="Birthdate")
    private String birthdate;
    @JsonProperty(value="Description")
    private String description;
    @JsonProperty(value="OwnerId")
    private String ownerId;
    @JsonProperty(value="HasOptedOutOfEmail")
    private Boolean hasOptedOutOfEmail;
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
    @JsonProperty(value="LastCURequestDate")
    private String lastCURequestDate;
    @JsonProperty(value="LastCUUpdateDate")
    private String lastCUUpdateDate;
    @JsonProperty(value="EmailBouncedReason")
    private String emailBouncedReason;
    @JsonProperty(value="EmailBouncedDate")
    private String emailBouncedDate;
    @JsonProperty(value="UseSalesforce")
    private String useSalesforce;
    @JsonProperty(value="Jigsaw")
    private String jigsaw;
    @JsonProperty(value="JigsawContactId")
    private String jigsawContactId;
    @JsonProperty(value="ConnectionReceivedId")
    private String connectionReceivedId;
    @JsonProperty(value="ConnectionSentId")
    private String connectionSentId;
    
   
   
    /**
     * Constructor.
     */
    public Contact() { }

    /**
     * Constructor with required fields.
     */
    public Contact(String lastName) {
        this.lastName = lastName;
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
    @XmlAttribute(name = "AccountId")
    @Column(name = "AccountId")
    public String getAccountId() {
        return accountId;
    }
    @XmlAttribute(name = "LastName")
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }
    @XmlAttribute(name = "FirstName")
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }
    @XmlAttribute(name = "Salutation")
    @Column(name = "Salutation")
    public String getSalutation() {
        return salutation;
    }
    @XmlAttribute(name = "Name")
    @Column(name = "Name")
    public String getName() {
        return name;
    }
    @XmlAttribute(name = "RecordTypeId")
    @Column(name = "RecordTypeId")
    public String getRecordTypeId() {
        return recordTypeId;
    }
    @XmlAttribute(name = "OtherStreet")
    @Column(name = "OtherStreet")
    public String getOtherStreet() {
        return otherStreet;
    }
    @XmlAttribute(name = "OtherCity")
    @Column(name = "OtherCity")
    public String getOtherCity() {
        return otherCity;
    }
    @XmlAttribute(name = "OtherState")
    @Column(name = "OtherState")
    public String getOtherState() {
        return otherState;
    }
    @XmlAttribute(name = "OtherPostalCode")
    @Column(name = "OtherPostalCode")
    public String getOtherPostalCode() {
        return otherPostalCode;
    }
    @XmlAttribute(name = "OtherCountry")
    @Column(name = "OtherCountry")
    public String getOtherCountry() {
        return otherCountry;
    }
    @XmlAttribute(name = "MailingStreet")
    @Column(name = "MailingStreet")
    public String getMailingStreet() {
        return mailingStreet;
    }
    @XmlAttribute(name = "MailingCity")
    @Column(name = "MailingCity")
    public String getMailingCity() {
        return mailingCity;
    }
    @XmlAttribute(name = "MailingState")
    @Column(name = "MailingState")
    public String getMailingState() {
        return mailingState;
    }
    @XmlAttribute(name = "MailingPostalCode")
    @Column(name = "MailingPostalCode")
    public String getMailingPostalCode() {
        return mailingPostalCode;
    }
    @XmlAttribute(name = "MailingCountry")
    @Column(name = "MailingCountry")
    public String getMailingCountry() {
        return mailingCountry;
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
    @XmlAttribute(name = "MobilePhone")
    @Column(name = "MobilePhone")
    public String getMobilePhone() {
        return mobilePhone;
    }
    @XmlAttribute(name = "HomePhone")
    @Column(name = "HomePhone")
    public String getHomePhone() {
        return homePhone;
    }
    @XmlAttribute(name = "OtherPhone")
    @Column(name = "OtherPhone")
    public String getOtherPhone() {
        return otherPhone;
    }
    @XmlAttribute(name = "AssistantPhone")
    @Column(name = "AssistantPhone")
    public String getAssistantPhone() {
        return assistantPhone;
    }
    @XmlAttribute(name = "ReportsToId")
    @Column(name = "ReportsToId")
    public String getReportsToId() {
        return reportsToId;
    }
    @XmlAttribute(name = "Email")
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }
    @XmlAttribute(name = "Title")
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }
    @XmlAttribute(name = "Department")
    @Column(name = "Department")
    public String getDepartment() {
        return department;
    }
    @XmlAttribute(name = "AssistantName")
    @Column(name = "AssistantName")
    public String getAssistantName() {
        return assistantName;
    }
    @XmlAttribute(name = "LeadSource")
    @Column(name = "LeadSource")
    public String getLeadSource() {
        return leadSource;
    }
    @XmlAttribute(name = "Birthdate")
    @Column(name = "Birthdate")
    public String getBirthdate() {
        return birthdate;
    }
    @XmlAttribute(name = "Description")
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }
    @XmlAttribute(name = "OwnerId")
    @Column(name = "OwnerId")
    public String getOwnerId() {
        return ownerId;
    }
    @XmlAttribute(name = "HasOptedOutOfEmail")
    @Column(name = "HasOptedOutOfEmail")
    public Boolean getHasOptedOutOfEmail() {
        return hasOptedOutOfEmail;
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
    @XmlAttribute(name = "LastCURequestDate")
    @Column(name = "LastCURequestDate")
    public String getLastCURequestDate() {
        return lastCURequestDate;
    }
    @XmlAttribute(name = "LastCUUpdateDate")
    @Column(name = "LastCUUpdateDate")
    public String getLastCUUpdateDate() {
        return lastCUUpdateDate;
    }
    @XmlAttribute(name = "EmailBouncedReason")
    @Column(name = "EmailBouncedReason")
    public String getEmailBouncedReason() {
        return emailBouncedReason;
    }
    @XmlAttribute(name = "EmailBouncedDate")
    @Column(name = "EmailBouncedDate")
    public String getEmailBouncedDate() {
        return emailBouncedDate;
    }
    @XmlAttribute(name = "UseSalesforce")
    @Column(name = "UseSalesforce")
    public String getUseSalesforce() {
        return useSalesforce;
    }
    @XmlAttribute(name = "Jigsaw")
    @Column(name = "Jigsaw")
    public String getJigsaw() {
        return jigsaw;
    }
    @XmlAttribute(name = "JigsawContactId")
    @Column(name = "JigsawContactId")
    public String getJigsawContactId() {
        return jigsawContactId;
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
     * AccountId is a reference to a parent entity.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    /**
     * LastName is a required field.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * FirstName is an optional field.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Salutation is an optional field.
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }
    /**
     * Name is a required field.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * RecordTypeId is a reference to a parent entity.
     */
    public void setRecordTypeId(String recordTypeId) {
        this.recordTypeId = recordTypeId;
    }
    /**
     * OtherStreet is an optional field.
     */
    public void setOtherStreet(String otherStreet) {
        this.otherStreet = otherStreet;
    }
    /**
     * OtherCity is an optional field.
     */
    public void setOtherCity(String otherCity) {
        this.otherCity = otherCity;
    }
    /**
     * OtherState is an optional field.
     */
    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }
    /**
     * OtherPostalCode is an optional field.
     */
    public void setOtherPostalCode(String otherPostalCode) {
        this.otherPostalCode = otherPostalCode;
    }
    /**
     * OtherCountry is an optional field.
     */
    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }
    /**
     * MailingStreet is an optional field.
     */
    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }
    /**
     * MailingCity is an optional field.
     */
    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }
    /**
     * MailingState is an optional field.
     */
    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }
    /**
     * MailingPostalCode is an optional field.
     */
    public void setMailingPostalCode(String mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
    }
    /**
     * MailingCountry is an optional field.
     */
    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
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
     * MobilePhone is an optional field.
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    /**
     * HomePhone is an optional field.
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    /**
     * OtherPhone is an optional field.
     */
    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }
    /**
     * AssistantPhone is an optional field.
     */
    public void setAssistantPhone(String assistantPhone) {
        this.assistantPhone = assistantPhone;
    }
    /**
     * ReportsToId is a reference to a parent entity.
     */
    public void setReportsToId(String reportsToId) {
        this.reportsToId = reportsToId;
    }
    /**
     * Email is an optional field.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Title is an optional field.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Department is an optional field.
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    /**
     * AssistantName is an optional field.
     */
    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }
    /**
     * LeadSource is an optional field.
     */
    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }
    /**
     * Birthdate is an optional field.
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    /**
     * Description is an optional field.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * OwnerId is a reference to a parent entity.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * HasOptedOutOfEmail is an optional field.
     */
    public void setHasOptedOutOfEmail(Boolean hasOptedOutOfEmail) {
        this.hasOptedOutOfEmail = hasOptedOutOfEmail;
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
     * LastCURequestDate is an optional field.
     */
    public void setLastCURequestDate(String lastCURequestDate) {
        this.lastCURequestDate = lastCURequestDate;
    }
    /**
     * LastCUUpdateDate is an optional field.
     */
    public void setLastCUUpdateDate(String lastCUUpdateDate) {
        this.lastCUUpdateDate = lastCUUpdateDate;
    }
    /**
     * EmailBouncedReason is an optional field.
     */
    public void setEmailBouncedReason(String emailBouncedReason) {
        this.emailBouncedReason = emailBouncedReason;
    }
    /**
     * EmailBouncedDate is an optional field.
     */
    public void setEmailBouncedDate(String emailBouncedDate) {
        this.emailBouncedDate = emailBouncedDate;
    }
    /**
     * UseSalesforce is an optional field.
     */
    public void setUseSalesforce(String useSalesforce) {
        this.useSalesforce = useSalesforce;
    }
    /**
     * Jigsaw is an optional field.
     */
    public void setJigsaw(String jigsaw) {
        this.jigsaw = jigsaw;
    }
    /**
     * JigsawContactId is a reference to a parent entity.
     */
    public void setJigsawContactId(String jigsawContactId) {
        this.jigsawContactId = jigsawContactId;
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

    @Override
    public String toString(){
    return ToStringBuilder.reflectionToString(this);}
}
