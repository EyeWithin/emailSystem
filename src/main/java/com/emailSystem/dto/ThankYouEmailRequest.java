package com.emailSystem.dto;



public class ThankYouEmailRequest {
	private String recipientEmail;
	private String recipientName;
	
	
    public String getRecipientEmail() {
    return recipientEmail;
}

public void setRecipientEmail(String recipientEmail) {
    this.recipientEmail = recipientEmail;
}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	

}
