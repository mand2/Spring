package com.bitcamp.guest.controller;
/* 2019-08-05 mon
 * @@ 참고: guestList의 request에서 받아오는 스트링을 int로 자동변환해줌@@
 * -----------------------
 * 2019-08-09
 * 추가: jackson을 사용하여 list를 json으로 변환해주기.
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.guest.domain.MessageListView;
import com.bitcamp.guest.service.GetMessageListService;

@Controller
public class GuestListController {
	
	@Autowired
	private GetMessageListService listService;
	
	@RequestMapping(value = "/guest/list")
	public String getList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
						Model model) {

		MessageListView view = listService.getMessageListView(pageNumber);
		
		model.addAttribute("viewData", view);
		
		return "guest/list";
	}
	
	
	/*--json으로 바로 반환하기위해--*/
	@RequestMapping(value = "/guest/listj")
	@ResponseBody
	public MessageListView getListJson(@RequestParam(value = "page", defaultValue = "1") int pageNumber) {
		
		MessageListView view = listService.getMessageListView(pageNumber);
		
		return view;
	}
	
	@RequestMapping(value = "/guest/list_j")
	public String getList() {
		
		return "guest/list_j";
	}
}
