package com.ny.mm.model.member;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class LoginInfo {
	private String id;
	private String name;
	private String photo;
	private Date regDate;
	private String email;
	
	public LoginInfo(String id, String name, String photo, Date regDate, String email) {
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.regDate = regDate;
		this.email = email;
	}


	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhoto() {
		return photo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public String getEmail() {
		return email;
	}


	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", name=" + name + ", photo=" + photo + ", regDate=" + regDate + ", email="
				+ email + "]";
	}
	
}
