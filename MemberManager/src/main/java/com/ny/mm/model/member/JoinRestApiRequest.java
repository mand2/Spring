package com.ny.mm.model.member;

import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.ny.mm.model.Member;

public class JoinRestApiRequest {
	private String id;
	private String pw;
	private String name;
	private MultipartFile photo;
	private String code; //없어도 될듯,,
	private char verify;
	private String email;
	
	
	public Member toMemberInfo() {
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		return member;
	}
	

	@Override
	public String toString() {
		return "JoinRestApiRequest [id=" + id + ", pw=" + pw + ", name=" + name + ", photo=" + photo + ", code=" + code
				+ ", verify=" + verify + ", email=" + email + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getVerify() {
		return verify;
	}
	public void setVerify(char verify) {
		this.verify = verify;
	}
	
}
