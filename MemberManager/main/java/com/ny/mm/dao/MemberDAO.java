package com.ny.mm.dao;
/*-------------------
 * 파일이름: MemberDAO.java
 * 파일설명: 멤버 관련 DAO 
 * 작성자: 김나연
 * 버전: 1.0.0
 * 생성일자: 2019-08-05 오후 5시 57분
 * 최종수정일자: 2019-08-05 오후 5시 57분
 * 최종수정자: 김나연
 * 최종수정내용: member manager 스프링으로 변경 
 * -------------------*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ny.mm.jdbc.JdbcUtil;
import com.ny.mm.model.Member;

@Repository("dao")
public class MemberDAO {

	
	//VO객체를 이용하여 : JDBC insert query 작성, 실행
	public int insertMember(Connection conn, Member vo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into project_01.memberinfo (ID, PW, NAME, PHOTO) values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhoto());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e + " memberInsert FAIL!!");
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	
	//전체회원 리스트가져오기
	public ArrayList<Member> getALLMemberList(Connection conn) {
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
		
			String sql = "select * from project_01.memberinfo order by idx";
			rs = stmt.executeQuery(sql);
		
			
			
		while(rs.next()) {
			Member vo = new Member();
			
			vo.setIdx(rs.getInt(1));
			vo.setId(rs.getString(2));
			vo.setPw(rs.getString(3));
			vo.setName(rs.getString(4));
			vo.setPhoto(rs.getString(5));
			vo.setRegDate(rs.getDate(6));
			
			list.add(vo);
		};
		
		
		} catch (SQLException e) {
			System.out.println(e + "Show ALL member LIST FAIL!!");
		}
		
		return list;
	}
	
	//로그인-1 member의 존재여부와 id pw가져올수있게,,,
	public Member selectOneMem(Connection conn, String id) {
		Member member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from project_01.memberinfo "
					+ " where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				
				member.setId(rs.getString(2));
				member.setPw(rs.getString(3));
				member.setName(rs.getString(4));
				member.setPhoto(rs.getString(5));
				member.setRegDate(rs.getDate(6));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}
	
	
	
	
}
