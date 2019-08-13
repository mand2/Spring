package com.bitcamp.mvc;
/**
 * 2019-08-13 
 * REST API사용
 */





import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "0813/form";
	}
	
	
	/* String형식으로 response에 넣어줌 
	 * 그러나 &으로 끊어주고 =로 key&value 나눠야하기 때문에 귀찮,
	 * == > 과제: json, xml 형식으로도 응용해보자!!
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String simple(@RequestBody String body) {
		
		System.out.println(body);
		return body;
	}
}
