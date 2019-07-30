package member;

import java.util.Date;

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public Member(String email, String password, String name, Date registerDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}
	
	public void changePassword(String oldPassword, String newPassword) throws IdPasswordNotMatchException {
		//이전 패스워드와 다를 때: 예외처리
		if(!this.password.equals(oldPassword)) {
			throw new IdPasswordNotMatchException();
		}
		this.password = newPassword;
	}
}
