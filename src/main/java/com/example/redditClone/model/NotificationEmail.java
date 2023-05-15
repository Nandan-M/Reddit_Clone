package com.example.redditClone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationEmail {
	private String subject;
	private String recepient;
	private String body;
	public NotificationEmail(String string) {
		// TODO Auto-generated constructor stub
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRecepient() {
		return recepient;
	}
	public void setRecepient(String recepient) {
		recepient = recepient;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
