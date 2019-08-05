package com.bitcamp.mvc.member;
/* 2019-08-01
 * cookie이름과 변수를 받아서 처리하는 컨트롤러
 * view: cookie/~~
 * -getMakeForm : 쿠키구워주는 폼으로 반환
 * -makeCookie : 폼을 통해 쿠키객체 만들고 보내줌
 * -selectCookie: 쿠키를 보여주게,,search
 * -viewcookie: selectCookie에서 넘어온 쿠키를 보여주는데 어노테이션으로 쿠키정보 넘길 수 없음...
 * 		:CookieValue : 쿠키의 이름을 안다면 + 콕 집어서
 * 		:requestParam: 쿠키 전체의 배열을 갖고와서 쿠키이름~!!!
 * */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/makeForm")
	public String getMakeForm() {
		return "cookie/makeForm";
	}
	
	
	//makeForm에서 쿠키객체를 만들어서 + 보내주기(굽는다)~!
	@RequestMapping("/cookie/makeCookie")
	public String makeCookie(
			@RequestParam(value = "cName" , defaultValue = "none") String cookieName,
			@RequestParam(value = "cValue", defaultValue = "none") String cookieValue,
			HttpServletResponse response
			) {
		
		//cookie making
		Cookie c = new Cookie(cookieName, cookieValue);
		
		//send cookie
		response.addCookie(c);
		
		return "cookie/makeCookie";
	}
	
	@RequestMapping(value = "/cookie/viewCookie", method = RequestMethod.GET)
	public String selectCookie() {
		return "cookie/selectForm";
	}
	
	
	
	/* cValue : 콕 집어서 + 쿠키이름 확실히 알 때
	 * cName : 검색값을 직접 갖고와~~ param에서~~~ 그리고 request가 갖고있는 전체 값이랑 비교해!
	 * */
	@RequestMapping(value = "/cookie/viewCookie", method = RequestMethod.POST)
	public String viewcookie(
			@CookieValue(value = "g", defaultValue = "none") String cValue,
			@RequestParam(value = "cName", required = false) String cName,
			HttpServletRequest request,
			Model model
			) {
		
		model.addAttribute("cName", "g");
		model.addAttribute("cValue", cValue);
		
		//쿠키배열갖고오기
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length ; i++) {
			if(cookies[i].getName().equals(cName)) {
				model.addAttribute("cName", cName);
				model.addAttribute("cValue", cookies[i].getValue());
			}
		}
		
		return "cookie/viewCookie";
	}
}
