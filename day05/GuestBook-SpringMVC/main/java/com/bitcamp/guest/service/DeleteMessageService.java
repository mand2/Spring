package com.bitcamp.guest.service;

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
import com.bitcamp.guest.jdbc.JdbcUtil;

@Service
public class DeleteMessageService implements GuestBookService{

	@Autowired
	private MessageDao dao ; 
	
	
	public int deleteMessage(int messageID, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
			int result = 0;
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				
				//트랜젝션처리->autocommit막고, 시작
				conn.setAutoCommit(false);
				
				/*DELETE 시작*/
				Message message = dao.select(conn, messageID);
				
				
				//게시물 있는지 없는지
				if(message == null ) {
					throw new MessageNotFoundException("메세지가 존재하지 않음 : " + messageID);
				
				} else {
				//비번 비교 시작
					if(!message.hasPassword()) {//not exist
						throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
					} 
					
					if(!message.matchPassword(password)){//비번일치X
						throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
					}
					//정상처리 될 때
					result= (dao.deleteMessage(conn, messageID));
					conn.commit(); 
				
				}//게시물있을때완료.
			//rollback필요할때
			} catch (SQLException e) {
				JdbcUtil.rollback(conn);
				e.printStackTrace();
				
				throw e;
			} catch (MessageNotFoundException e) {
				JdbcUtil.rollback(conn);
				e.printStackTrace();
				throw e;
			} catch (InvalidMessagePasswordException e) {
				JdbcUtil.rollback(conn);
				e.printStackTrace();
				throw e;
			}
			
			return result;
	}
}
