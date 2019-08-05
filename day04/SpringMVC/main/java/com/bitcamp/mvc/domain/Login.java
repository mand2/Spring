package com.bitcamp.mvc.domain;
/*2019-08-01
 * 로그인 시 login 한 memeber객체 만들어주는 클래스
 * */
public class Login {
	
	
	private String id;
	private String pw;
	
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
	
}
