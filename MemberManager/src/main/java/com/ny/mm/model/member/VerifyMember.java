package com.ny.mm.model.member;

import org.springframework.web.multipart.MultipartFile;

import com.ny.mm.model.Member;

public class VerifyMember {
	
	private String id;
	private String email;
	
	@Override
	public String toString() {
		return "VerifyMember [id=" + id + ", email=" + email + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
