package com.example.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	//private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public SimpleMailMessage sendMail(String from, String to, String subject, String body) throws MessagingException {
		
		SimpleMailMessage message = new SimpleMailMessage();
		 
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
		
		return message;
	}
	
	public void sendMailWithAttachment(SimpleMailMessage simplemessage, String dear, String content, String attachmentPath) {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setFrom(simplemessage.getFrom());
			helper.setTo(simplemessage.getTo());
			helper.setSubject(simplemessage.getSubject());
			helper.setText(String.format(
					simplemessage.getText(), dear, content));
			
			FileSystemResource file = new FileSystemResource(attachmentPath);
			
			helper.addAttachment(file.getFilename(), file);
			
			
		}catch (MessagingException e) {
			throw new MailParseException(e);
		}
		mailSender.send(message);
	
	}

}
