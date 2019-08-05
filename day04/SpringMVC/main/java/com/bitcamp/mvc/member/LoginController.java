package com.bitcamp.mvc.member;
/* 2019-08-01
 * 로그인 폼 페이지 요청 various ways
 * 
 * - loginCheck : httpservletRequest를 parameter로 받아와 ModelAndView이용
 * - loginproc: String으로, model/@RequestParam 을 parameter로 받아와 model에 셋팅
 * - loginOk: String으로, Login.java (빈객체)를 사용
 * - loginOk2: String으로, Login.java (빈객체)를 사용 + modelAttribute로 EL에 쓸 객체 이름 정해줌. 
 * 			이거 쓰면 parameter원래이름을 쓸 수 없음
 *  view resolver의 범위에 포함된 경로 return으로 반환
 * */

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.mvc.domain.Login;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/member/login")
	public String getLoginForm() {
		//login form . jsp 보여주기
		
		return "member/loginForm"; //view 경로 반환
	}
	
	/* 목적:
	 * 1.
	 * 사용자 요청 주소는 /member/loginCheck
	 * 이지만
	 * 반환하는 view경로는 member/login.jsp에서 반환
	 * 전송할 view 경로와, == member/login
	 * 결과 데이터(MODEL) == addObject 후,,
	 * 저장하고 전달할 객체인 
	 * ModelAndView 객체 생성
	 * */
	@RequestMapping(value = "/member/loginCheck" , method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		String id = request.getParameter("id"); //parameter 받아서~
		String pw = request.getParameter("pw");
		
		System.out.println(id + " | " + pw); //출력해보기
		
		
		modelAndView.setViewName("member/login");
		
		modelAndView.addObject("id", id);  //parameter 전달~
		modelAndView.addObject("pw", pw);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/member/loginChk")
	public String loginproc(@RequestParam(value = "id", defaultValue = "SuperFantastic") String id ,
							@RequestParam(value = "pw", required = false) String pw , 
							Model model) {
		
		System.out.println(id + "| " + pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "member/login";
	}
	
	
	@RequestMapping(value = "/member/loginOk")
	public String loginOk(Login login) {
		
		//객체를 잘 받았는지 확인
		System.out.println(login.getId() + " | " + login.getPw());
		
		
		login.setId(login.getId() + "-12345"); //사용자가 입력한 데이터를 가공하고 후에 공유할수있음.
		
		return "member/login";
	}
	
	
	@RequestMapping(value = "/member/loginOk2")
	public String loginOk2(@ModelAttribute("user") Login login) {
		
		//객체를 잘 받았는지 확인
		System.out.println(login.getId() + " | " + login.getPw());
		
		
		login.setId(login.getId() + "-12345"); //사용자가 입력한 데이터를 가공하고 후에 공유할수있음.
		
		
		return "member/login";
	}
	
}
