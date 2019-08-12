package com.bitcamp.guest.service;
/* 2019-08-12 mon
 * */
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.dao.MessageDao;
import com.bitcamp.guest.dao.MessageJdbcTemplateDao;
import com.bitcamp.guest.dao.MsgSTDao;
import com.bitcamp.guest.dao.MsgSessionDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.ConnectionProvider;


@Service("writeService")
public class WriteMessageService implements GuestBookService{

/* 2019-08-05 에 작성한 내용
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
*/

	/*---------------------------------------------------------
				2019-08-08에 jdbc템플릿으로 변경
	---------------------------------------------------------*/
	
//	@Autowired
//	private MessageJdbcTemplateDao templateDao;
//	
//	public int write(Message message) {
//		int result = 0;
//		result = templateDao.insert(message);
//		return result;
//	}
	
	/*---------------------------------------------------------
				2019-08-12에 MyBatis템플릿으로 변경
	---------------------------------------------------------*/
//	
//	@Autowired
//	private MsgSTDao templateDao;
//	
//	public int write(Message message) {
//		return templateDao.insert(message);
//	}

	/*---------------------------------------------------------
			2019-08-12 pm5:10에 자동매퍼기능 사용하여+mybatis 변경
	---------------------------------------------------------*/
	@Autowired
	private SqlSessionTemplate template;
	private MsgSessionDao dao;
	
	public int write(Message message) {
		dao = template.getMapper(MsgSessionDao.class);
		return dao.insert(message);
	}
}
