package com.bitcamp.guest.dao;
/**
 * 2019-08-12 
 * MyBatis를 이용 + SqlSessionFactory의 Template 이용
 * 장점: sql구문 내용이 바뀌어도 java 코드는 바뀌지 않음. 
 */


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.guest.domain.Message;

public class MsgSTDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*mapper의 namespace는 공통적으로 사용되는 경우가 있어 공통으로 씀*/
	private String nameSpace = "com.bitcamp.guest.mapper.mybatis.GuestMapper";
	

	public int insert(Message message) { 
		String str = nameSpace + ".insertMessage";
		int result = sqlSession.update(str, message);
		
		return result;
	}
		
}
