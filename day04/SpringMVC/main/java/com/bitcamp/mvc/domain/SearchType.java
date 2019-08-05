package com.bitcamp.mvc.domain;

/* 2019-08-02
 * searchcontroller.java에서 사용할 객체형식
 * 검색어 객체 
 * */

public class SearchType {
	private int no;
	private String name;
	
	public SearchType(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "SearchType [no=" + no + ", name=" + name + "]";
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
