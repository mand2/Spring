package com.bitcamp.guest.controller;
/* 2019-08-05 mon
 * msg 리스트에서 삭제하기
 * 같은 jsp로 mapping --> parameter 만들어서 또 안넘겨줘도 됨.
 * @deleteConfirm : pw 받아오는 폼 보여주기
 * */

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.guest.service.DeleteMessageService;
import com.bitcamp.guest.service.InvalidMessagePasswordException;
import com.bitcamp.guest.service.MessageNotFoundException;


@Controller
public class DeleteMsgController {
	
	@Autowired
	private DeleteMessageService delMsg ;
	
	@RequestMapping(value = "/guest/delete", method = RequestMethod.GET)
	public String deleteConfirm() {
		return "guest/deleteConfirm";
	}
	
	
	@RequestMapping(value = "/guest/delete", method = RequestMethod.POST)
	public String deleteMsg(@RequestParam(value = "messageID")int id, 
			@RequestParam(value = "password") String pw,
			Model model) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = delMsg.delete(id, pw);
		
		model.addAttribute(resultMap);
		System.out.println("--- msg ---" + resultMap.get("msg"));
		System.out.println("--- result ---" + resultMap.get("result"));
		System.out.println("--- chk ---" + resultMap.get("chk"));
		
		
		return "guest/deleteMsg";
	}
}
