package com.bitcamp.mvc.domain;
/**
 * 2019-08-13 
 * REST API사용 
 * XML형식
 * @XmlAccessorType(XmlAccessType.FIELD)
 * @XmlType(propOrder = {"id", "message", "createTime"})
 */


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "message", "createTime"})
public class GuestMessage {
	
	private Integer id;
	private String message;
	private Date createTime;
	
	public GuestMessage(Integer id, String message, Date createTime) {
		this.id = id;
		this.message = message;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
