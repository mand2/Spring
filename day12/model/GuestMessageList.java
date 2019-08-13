package com.bitcamp.mvc.domain;
/**
 * 2019-08-13 
 * REST API사용 
 * XML형식
 * 실제로 view에 처리할 객체임
 */

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message-list")
public class GuestMessageList {
	
	
	//list의 개수만큼 <message> tag가 나온다
	@XmlElement(name = "message")
	private List<GuestMessage> messages;

	/*--- constructor ---*/
	public GuestMessageList() {}

	public GuestMessageList(List<GuestMessage> messages) {
		this.messages = messages;
	}

	public List<GuestMessage> getMessages() {
		return messages;
	}

	
}
