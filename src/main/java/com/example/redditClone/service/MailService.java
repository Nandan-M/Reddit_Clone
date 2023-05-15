package com.example.redditClone.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.example.redditClone.exception.SpringRedditException;
import com.example.redditClone.model.NotificationEmail;

@Service
public class MailService {
	
	@Autowired
	private  JavaMailSender mailSender;
	
	void sendMail(NotificationEmail notificationEmail) throws SpringRedditException{
		MimeMessagePreparator message = mimeMessage ->{
			MimeMessageHelper messageHelper= new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("mungandla10@gmail.com");
			messageHelper.setTo(notificationEmail.getRecepient());
			messageHelper.setSubject(notificationEmail.getSubject());
			messageHelper.setText(notificationEmail.getBody());
			
		};
		
		try {
			mailSender.send(message);
			System.out.println("sent");
		}
		catch(MailException e){
		throw new SpringRedditException("Not able to send email" + notificationEmail.getRecepient());
		}
		
		
	}
	
	

}
