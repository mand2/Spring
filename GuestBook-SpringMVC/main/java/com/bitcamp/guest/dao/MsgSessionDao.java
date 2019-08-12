package com.bitcamp.guest.dao;
/**
 * 2019-08-12 (2)
 * MyBatis를 이용 + auto mapper creating function
 * MsgSTDao와 구분되는 장점: dao 주입이 아님. 코드 줄일 수 있음 
 * service class 내에서 만들어 줄 수 있다.
 * 규칙1: 메서드 이름이 element이름이어야 한다
 * 		== SQL mapper 내부의 각 id와 interface의 변수명이 같아야 한다.
 * 규칙2: SQL mapper 의 namespace == 인터페이스의 package명 
 */




import java.util.List;
import java.util.Map;

import com.bitcamp.guest.domain.Message;

public interface MsgSessionDao {
	
	public int insert(Message message) ;
	public int selectCount();
	public List<Message> selectList(Map<String, Object> params);
	public Message select(int messageID);
	public int deleteMessage(int messageID);
	
}
