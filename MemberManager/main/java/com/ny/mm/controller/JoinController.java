package com.ny.mm.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
/* 2019-08-06
 * member register (==join) 관련 컨트롤러 제작
 * getForm() 회원가입 폼 반환
 * 
 * */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ny.mm.dao.MemberDAO;
import com.ny.mm.model.JoinMember;
import com.ny.mm.model.Member;
import com.ny.mm.service.JoinService;
import com.ny.mm.service.memberService;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinservice;
	
	@RequestMapping(value = "/join/form", method = RequestMethod.GET)
	public String getForm() {
		return "join/form";
	}
	
	@RequestMapping(value = "/join/form", method = RequestMethod.POST)
	public String join(Model model, JoinMember joinMember, HttpServletRequest request) {
		System.out.println(joinMember);
		
		model.addAttribute("result", joinservice.joinMember(request, joinMember));
		/* jsp에 멤버 보여주기
		 * Member member = new Member(joinMember.getId(), joinMember.getPw(),
		 * joinMember.getName(), photo);
		 */
		
		return "join/join";
	}
	
	@RequestMapping("/join/idcheck")
	public String idCheck() {
		return "join/idcheck";
	}
}
