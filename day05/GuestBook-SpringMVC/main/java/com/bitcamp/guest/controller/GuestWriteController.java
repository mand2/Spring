package com.bitcamp.guest.controller;
import org.springframework.beans.factory.annotation.Autowired;
/* 2019-08-05 Mon
 * 1. controller 만들기: 쓰기
 * 2. 글쓰기요청 :  보여주기
 * 3. 글 쓴 후 : 잘 올라갔다 보여주는 페이지
 * */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.guest.domain.RequestGuestWrite;
import com.bitcamp.guest.service.WriteMessageService;

@Controller
public class GuestWriteController {
	
	@Autowired
	private WriteMessageService writeService; //wirteMessageService의 이름을 가져옴 == 주입

	/*글쓰기누르면 보여주기*/
	@RequestMapping("/guest/writeForm")
	public String getForm() {
		
		return "guest/writeForm";
	}
	     
	/*form에서 쓰면 '잘 올라갔다' 보여주는 페이지로 넘김*/
	@RequestMapping(value = "/guest/write", method = RequestMethod.POST)
	public String write(RequestGuestWrite reqGuestWrite, Model model) {
		
		System.out.println(reqGuestWrite.toString());
		
		int result = writeService.write(reqGuestWrite.toMessage());
//		System.out.println("result write | "+result);
		
		model.addAttribute("result", result);
		
		return "guest/write";
	}
	
}
