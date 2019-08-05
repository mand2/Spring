package com.bitcamp.guest.service;
/* 2019-08-05 mon
 * */
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.dao.MessageDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.ConnectionProvider;


@Service("writeService")
public class WriteMessageService implements GuestBookService{

	@Autowired
	private MessageDao dao;
	
	
	public int write(Message message) {
		int result = 0;

		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();

			result = dao.insert(conn, message);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


}
