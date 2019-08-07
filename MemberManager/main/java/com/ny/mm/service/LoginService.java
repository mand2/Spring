package com.ny.mm.service;
/* 2019-08-06
 * 로그인 서비스 제작
 * 
 * */


import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.mm.dao.MemberDAO;
import com.ny.mm.jdbc.ConnectionProvider;
import com.ny.mm.model.Member;

@Service(value = "loginService")
public class LoginService implements memberService{
	
	@Autowired
	private MemberDAO dao;
	
	public boolean login(String id, String pw, HttpServletRequest request) {
		
		boolean loginChk = false;
		Connection conn = null;
		Member member = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			member = dao.selectOneMem(conn, id);
			
			if(member != null && member.matchPassword(pw)) {
				//세션저장 + loginChk값 변경
				loginChk = true;
				request.getSession(true).setAttribute("loginInfo", member.toLoginInfo());
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginChk;
	}
}
