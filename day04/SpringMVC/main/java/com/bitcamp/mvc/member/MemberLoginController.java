package com.bitcamp.mvc.member;

import javax.servlet.http.HttpServletRequest;

/* 2019-08-01
 * member/memberlogin에서 들어오는 건 똑같지만
 * get 방식인지
 * post 방식인지 다 다르니까여~~! 
 * */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/memberLogin")
public class MemberLoginController {
	
	
	//get 방식으로 받으면 loginForm으로
	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		return "member/loginForm2";
	}
	
	//post 방식으로 받으면 loginCheck결과가 나오는 login으로
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//dispatcher에서 받은 model에 반환할 id와 pw 셋팅
		model.addAttribute("id", id); 
		model.addAttribute("pw", pw);
		
		System.out.println(id +" | " + pw);
		
		return "member/login";
	}
	
}
