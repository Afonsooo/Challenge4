package br.com.fiap.StarIntersection.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Email {

	private String emailId;
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	private String text;
	private String sendDateEmail;
	private String statusEmail;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSendDateEmail() {
		return sendDateEmail;
	}

	public void setSendDateEmail(String sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}

	public String getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(String statusEmail) {
		this.statusEmail = statusEmail;
	}

	@Override
	public String toString() {
		return "Email [emailId=" + emailId + ", ownerRef=" + ownerRef + ", emailFrom=" + emailFrom + ", emailTo="
				+ emailTo + ", subject=" + subject + ", text=" + text + ", sendDateEmail=" + sendDateEmail + "]";
	}

}
