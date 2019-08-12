package com.bitcamp.guest.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.dao.MessageDao;
import com.bitcamp.guest.dao.MessageJdbcTemplateDao;
import com.bitcamp.guest.dao.MsgSTDao;
import com.bitcamp.guest.dao.MsgSessionDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.ConnectionProvider;
import com.bitcamp.guest.jdbc.JdbcUtil;
import com.mysql.cj.jdbc.SuspendableXAConnection;

@Service
public class DeleteMessageService implements GuestBookService{

	/*---------------------------------------------------------
			2019-08-12 pm5:10에 자동매퍼기능 사용하여+mybatis 변경
	---------------------------------------------------------*/
	@Autowired
	private SqlSessionTemplate template;
	
	private MsgSessionDao dao;

	public int deleteMessage(int messageID, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {

		/*dao 생성*/
		dao = template.getMapper(MsgSessionDao.class);
		
		int result = 0;
		
		/*DELETE 시작*/
		Message message = dao.select(messageID);
		
		
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

			//게시물있을때 == 정상처리 될 때 완료
			result= dao.deleteMessage(messageID);
		}
		return result;
	}
	
	//삭제 결과를 map객체에 넣어 반환하는 메서드(실사용)
	public Map<String, Object> delete (int id, String pw) {
		
		int result = 0;
		boolean chk = false;
		String msg ="";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			result = deleteMessage(id, pw);
			chk = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = e.getMessage();
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
			msg = e.getMessage();
		} catch (InvalidMessagePasswordException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		
		map.put("msg", msg);
		map.put("result", result);
		map.put("chk", chk);
		
		return map;
	}

	/*---------------------------------------------------------
				2019-08-12에 mybatis템플릿으로 변경
	---------------------------------------------------------*/

//	@Autowired
//	private MsgSTDao dao;
//
//	public int deleteMessage(int messageID, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
//		int result = 0;
//		
//		/*DELETE 시작*/
//		Message message = dao.select(messageID);
//		
//		
//		//게시물 있는지 없는지
//		if(message == null ) {
//			throw new MessageNotFoundException("메세지가 존재하지 않음 : " + messageID);
//		
//		} else {
//		//비번 비교 시작
//			if(!message.hasPassword()) {//not exist
//				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
//			} 
//			
//			if(!message.matchPassword(password)){//비번일치X
//				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
//			}
//
//			//게시물있을때 == 정상처리 될 때 완료
//			result= dao.deleteMessage(messageID);
//		}
//		return result;
//	}
//	
//	//삭제 결과를 map객체에 넣어 반환하는 메서드(실사용)
//	public Map<String, Object> delete (int id, String pw) {
//		
//		int result = 0;
//		boolean chk = false;
//		String msg ="";
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		try {
//			result = deleteMessage(id, pw);
//			chk = true;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			msg = e.getMessage();
//		} catch (MessageNotFoundException e) {
//			e.printStackTrace();
//			msg = e.getMessage();
//		} catch (InvalidMessagePasswordException e) {
//			e.printStackTrace();
//			msg = e.getMessage();
//		}
//		
//		map.put("msg", msg);
//		map.put("result", result);
//		map.put("chk", chk);
//		
//		return map;
//	}
	
	

	/* 2019-08-05 에 작성한 내용	*/	
//	@Autowired
//	private MessageDao dao ; 
//	
//	
//	public int deleteMessage(int messageID, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
//			int result = 0;
//			Connection conn = null;
//			
//			try {
//				conn = ConnectionProvider.getConnection();
//				
//				//트랜젝션처리->autocommit막고, 시작
//				conn.setAutoCommit(false);
//				
//				/*DELETE 시작*/
//				Message message = dao.select(conn, messageID);
//				
//				
//				//게시물 있는지 없는지
//				if(message == null ) {
//					throw new MessageNotFoundException("메세지가 존재하지 않음 : " + messageID);
//				
//				} else {
//				//비번 비교 시작
//					if(!message.hasPassword()) {//not exist
//						throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
//					} 
//					
//					if(!message.matchPassword(password)){//비번일치X
//						throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
//					}
//					//정상처리 될 때
//					result= (dao.deleteMessage(conn, messageID));
//					conn.commit(); 
//				
//				}//게시물있을때완료.
//			//rollback필요할때
//			} catch (SQLException e) {
//				JdbcUtil.rollback(conn);
//				e.printStackTrace();
//				
//				throw e;
//			} catch (MessageNotFoundException e) {
//				JdbcUtil.rollback(conn);
//				e.printStackTrace();
//				throw e;
//			} catch (InvalidMessagePasswordException e) {
//				JdbcUtil.rollback(conn);
//				e.printStackTrace();
//				throw e;
//			}
//			
//			return result;
//	}
	

	/*---------------------------------------------------------
				2019-08-08에 jdbc템플릿으로 변경
	---------------------------------------------------------*/
//	
//	@Autowired
//	private MessageJdbcTemplateDao dao;
//
//	public int deleteMessage(int messageID, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
//		int result = 0;
//		
//		/*DELETE 시작*/
//		Message message = dao.select(messageID);
//		
//		
//		//게시물 있는지 없는지
//		if(message == null ) {
//			throw new MessageNotFoundException("메세지가 존재하지 않음 : " + messageID);
//		
//		} else {
//		//비번 비교 시작
//			if(!message.hasPassword()) {//not exist
//				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
//			} 
//			
//			if(!message.matchPassword(password)){//비번일치X
//				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
//			}
//
//			//게시물있을때 == 정상처리 될 때 완료
//			result= dao.deleteMessage(messageID);
//		}
//		
//		return result;
//	}
//	
//	
//	public Map<String, Object> delete (int id, String pw) {
//		
//		int result = 0;
//		boolean chk = false;
//		String msg ="";
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		try {
//			result = deleteMessage(id, pw);
//			chk = true;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			msg = e.getMessage();
//		} catch (MessageNotFoundException e) {
//			e.printStackTrace();
//			msg = e.getMessage();
//		} catch (InvalidMessagePasswordException e) {
//			e.printStackTrace();
//			msg = e.getMessage();
//		}
//		
//		map.put("msg", msg);
//		map.put("result", result);
//		map.put("chk", chk);
//		
//		return map;
//	}
}
