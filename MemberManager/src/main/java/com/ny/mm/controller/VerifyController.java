package com.ny.mm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ny.mm.model.member.VerifyMember;
import com.ny.mm.service.VerifyService;

@Controller
public class VerifyController {
	
	@Autowired
	private VerifyService verifyService;
	
	@RequestMapping("/join/verify")
	public String verify(@RequestParam("id")String id, @RequestParam("code")String code) {
		return "join/verify_" + verifyService.verify(id, code);
	}
	
	@RequestMapping(value = "/login/verify/{id}", method = RequestMethod.POST)
	public String verifyChange(@PathVariable("id")String id, VerifyMember vMem) {
		
		verifyService.reSend(id, vMem);
		
		return "login/verify";
	}
}
