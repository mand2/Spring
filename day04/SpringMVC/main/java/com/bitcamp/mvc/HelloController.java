package com.bitcamp.mvc;
import java.util.Date;

/* 2019-07-31
 * HelloController 객체 생성
 * */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	/* 목적:
	 * 1.
	 * FrontController로 전송할 view 경로와, == hello
	 * 결과 데이터(MODEL) == addObject 후,,
	 * 저장하고 전달할 객체인 
	 * ModelAndView 객체 생성
	 * */
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("hello");
		modelAndView.addObject("userName", "JIN");
		modelAndView.addObject("greeting", "아기들 안녕^^ 난 월드와이드핸섬 진이야");
		modelAndView.addObject("now", new Date());
		
		return modelAndView;
	}
	
	
	
}
