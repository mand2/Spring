package com.ny.mm.service;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/* 2019-08-06
 * 멤버 가입
 * 
 * */
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.mm.dao.MemberDAO;
import com.ny.mm.jdbc.ConnectionProvider;
import com.ny.mm.model.Member;
import com.ny.mm.model.member.JoinMember;

@Service(value = "joinService")
public class JoinService implements memberService{
	
	@Autowired
	private MemberDAO dao;
	
	//가입 서비스
	public int joinMember(
			HttpServletRequest request,
			JoinMember joinMember
			) {
		
		int result = 0;
		Connection conn = null;
		
		//서버경로
		String path = "/uploadfile/userphoto"; //resource mapping해야함.
		//절대경로
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		Member memberinfo = joinMember.toMemberInfo();
		
		//새로운 파일 이름 생성
		String newFileName = System.nanoTime() + "_" + joinMember.getId();
		
		try {
			//file을 서버의 지정 경로에 저장.
			joinMember.getPhoto().transferTo(new File(dir, newFileName));
			
			//데이터베이스 저장을 하기위한 파일이름 세팅
			memberinfo.setPhoto(newFileName);
			
			conn = ConnectionProvider.getConnection();
			
			result = dao.insertMember(conn, memberinfo);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
