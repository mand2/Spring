package com.bitcamp.mvc.order;
/* 2019-08-01
 * 주문하기 클릭하면 /order/order라는 url을 보여주고,
 * - getForm을 통해 
 * 		-get방식: 폼을 불러준다.
 * 		-post방식: order 현황 전체보기 보여줌.
 * 
 * */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.mvc.domain.OrderCommand;
import com.bitcamp.mvc.domain.OrderItem;

@Controller
@RequestMapping(value = "/order/order")
public class OrderController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		return "product/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String order(@ModelAttribute("orders")  OrderCommand orders) {
		
		/*출력확인*/
		System.out.println("address: " + orders.getAddress());
		
		for( OrderItem item : orders.getOrderItems()) {
			System.out.println(item);
		}
		
		return "product/order";
	}
	
}
