package com.bitcamp.mvc.member;
/*2019-08-02
 * header 값 가져오기: 
 * -getHeader: 이전페이지가 갖고 있는 referrer 속성을 가져오기 + data sharing
 * */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {

	@RequestMapping("/header/getHeader")
	public String getHeader(
				@RequestHeader("referer") String referrer,
				Model model) {
		
		System.out.println("referrer" + referrer);
		
		model.addAttribute("result", referrer);
		
		return "header/header";
	}
	
}
