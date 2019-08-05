package com.bitcamp.mvc.domain;
/* 2019-08-01
 * 리스트로 만들어보기~
 * views/product/ 이후의 뷰에서 사용될 것임!
 * 사용자가 주문하는 흐름을 보여주는 객ㄱ체 : list
 * */

import java.util.List;

public class OrderCommand {
	
	/* form 태그 내에서 전달될 이름들임
	 * orderItems
	 * address
	 * */
	private List<OrderItem> orderItems;
	private Address address;
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OrderCommand [orderItems=" + orderItems + ", address=" + address + "]";
	}
	
	
	
}
