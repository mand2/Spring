package com.bitcamp.guest.dao;
/**
 * 2019-08-12 
 * MyBatis를 이용 + SqlSessionFactory의 Template 이용
 * 장점: sql구문 내용이 바뀌어도 java 코드는 바뀌지 않음. 
 */


import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.guest.domain.Message;


@Repository(value = "templateDao")
public class MsgSTDao {
	
	@Autowired
	private SqlSessionTemplate template;
	
	/*mapper의 namespace는 공통적으로 사용되는 경우가 있어 공통으로 씀*/
	private String nameSpace = "com.bitcamp.guest.mapper.mybatis.GuestMapper";
	
	
	
	//message 등록
	public int insert(Message message) { 
		String str = nameSpace + ".insertMessage";
		return template.update(str, message);
	}
	
	
	//전체메세지 수 count
	public int selectCount() {
		String str = nameSpace + ".selectCount";
		return template.selectOne(str);
	}
	
	public List<Message> selectList(int firstrow, int cntPerPage){
		String str = nameSpace + ".selectList";
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("firstrow", firstrow);
		params.put("cntPerPage", cntPerPage);
		
		return template.selectList(str, params);
		
	}
	

	/* 메세지 보기 : 삭제시 필요함.*/
	public Message select(int messageID) {
		String str = nameSpace + ".select";
		return template.selectOne(str, messageID);
	}
	
	//메세지삭제
	public int deleteMessage(int messageID) {
		String str = nameSpace + ".deleteMessage";
		return template.update(str, messageID);
		
	}
		
}
