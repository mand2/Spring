package com.ny.mm.service;
/* 2019-08-07
 * member delete service
 * */

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.mm.dao.MemberDAO;
import com.ny.mm.jdbc.ConnectionProvider;

@Service(value = "deleteService")
public class MemDelService {
	
	@Autowired
	private MemberDAO dao;
	
	public int delete(String id) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
			
			result = dao.deleteMember(conn, id);
			conn.commit();
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
