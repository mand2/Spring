package com.bitcamp.guest.domain;

public class RequestGuestWrite {
	
	private String guestName;
	private String password;
	private String message;

	
	@Override
	public String toString() {
		return "RequestGuestWrite [guestName=" + guestName + ", password=" + password + ", message="
				+ message + "]";
	}

	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Message toMessage() {
		return new Message(0, guestName, password, message);
	}
	
}
