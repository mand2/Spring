package com.ny.mm.model;
/*-------------------
 * 파일이름: Member.java
 * 파일설명: 멤버 객체 model 
 * 작성자: 김나연
 * 버전: 1.0.0
 * 생성일자: 2019-08-05 오후 5시 57분
 * 최종수정일자: 2019-08-05 오후 5시 57분
 * 최종수정자: 김나연
 * 최종수정내용: member manager 스프링으로 변경 
 * -------------------*/
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ny.mm.model.member.LoginInfo;

public class Member {
	private int idx;
	private String id;
	@JsonIgnore
	private String pw;
	private String name;
	private String photo;
	private Date regDate;
	
	
	/* 2019-08-20 추가
	 * 인증코드와 verify 확인코드
	 * */
	
	@JsonIgnore
	private String code;
	private char verify;
	private String email;
	
	public Member() {
		this.regDate = new Date();
		randomCode();
	}
	
	public Member(String id, String email) {
		this.id = id;
		this.email = email;
		randomCode();
	}

	public Member(String id, String pw, String name, String photo) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.regDate = new Date();
		randomCode();
	}
	public Member(String id, String pw, String name, String photo, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.regDate = new Date();
		this.email = email;
		randomCode();
	}
	
	public Member(int idx, String id, String pw, String name, String photo, Date regDate) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.regDate = regDate;
		randomCode();
	}


	@Override
	public String toString() {
		return "Member [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", photo=" + photo + ", regDate="
				+ regDate + ", code=" + code + ", verify=" + verify + ", email=" + email + "]";
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() { 
		return code;
	}

	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//memberInfo 인스턴스에서 LoginInfo객체 반환하는 메서드 
	public LoginInfo toLoginInfo() {
		return new LoginInfo(id, name, photo, regDate, email); 
	}
	 
	
	public boolean hasPassword() {
		return pw != null && !pw.isEmpty();
	}
	
	public boolean matchPassword(String pw) {
		return hasPassword() && this.pw.equals(pw);
	}
	
	//영대소문자+숫자 난수
	public void randomCode() {
		
		StringBuffer temp = new StringBuffer();
		
		Random rnd = new Random();
		String str = String.valueOf( (char) (rnd.nextInt(26) + 97) );
		
		for(int i = 0; i < 10; i++) { //10자리 난수발생
			int index = rnd.nextInt(3); //숫자 012 중에서 난수 발생시킴
			
			switch (index) {
			case 0:
				//97~122 a-z의 아스키코드
				temp.append((char)(rnd.nextInt(26) + 97)); 
				break;
			case 1:
				
				temp.append((char)(rnd.nextInt(26) + 65)); 
				break;
			case 2:
				temp.append(rnd.nextInt(10));
				break;

			}
		}
		
		System.out.println("난수코드생성: " + temp);
		setCode(temp.toString());
	}
	
}
