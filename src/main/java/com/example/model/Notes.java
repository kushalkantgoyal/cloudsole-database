package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "notes")
@Table(name = "notes")
public class Notes implements java.io.Serializable{
	
	public Notes(){}
	
	public Notes(String subject, String body){
		this.subject=subject;
		this.body=body;
	}
	
	private Long id;
	private String subject;
	private String body;
	
	@XmlAttribute(name = "id", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlAttribute(name = "subject", required = false)
	@Column(name = "subject", nullable = false)
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@XmlAttribute(name = "body", required = false)
	@Column(name = "body", nullable = false)
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
