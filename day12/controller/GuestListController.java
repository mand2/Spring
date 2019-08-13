package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mvc.domain.GuestMessage;
import com.bitcamp.mvc.domain.GuestMessageList;

/**
 * 2019-08-13 
 * REST API사용 
 * XML형식
 * 실제로 view에 처리할 객체임
 */


@Controller
public class GuestListController {

	@RequestMapping(value = "/guest/xmlList.xml")
	@ResponseBody
	public GuestMessageList xmlList() {
		return getmessageList();
	}

	private GuestMessageList getmessageList() {

		List<GuestMessage> message = new ArrayList<GuestMessage>();
		message.add(new GuestMessage(1, "hihi", new Date()));
		message.add(new GuestMessage(2, "매우심심하다", new Date()));
		message.add(new GuestMessage(3, "배가부르다아", new Date()));
		
		return new GuestMessageList(message);
	}
	
}
