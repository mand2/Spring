package com.ny.mm.controller;
/*-------------------
 * 파일이름: JoinController.java
 * 파일설명: 회원가입 
 * 작성자: 김나연
 * 버전: 1.0.0
 * 생성일자: 2019-08-06 오전 10시 57분
 * 최종수정일자: 2019-08-06 오전 10시 57분
 * 최종수정자: 김나연
 * 최종수정내용: member manager 스프링으로 변경 
 * -------------------*/

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
		
		model.addAttribute("result", joinservice.joinMember(request, joinMember));
		
		model.addAttribute("member", new Member(joinMember.getId(), joinMember.getPw(), joinMember.getName(), joinMember.getPhoto().getOriginalFilename()));
		
		return "join/join";
	}
	
	@RequestMapping("/join/idcheck")
	public String idCheck() {
		return "join/idcheck";
	}
}
