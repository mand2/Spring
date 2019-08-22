package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 2019-08-21
 * security controller
 * 설정파일 따로 만들지 않아도 됨. --> 대신 bean으로 등록 서블릿에,,
 * pom.xml에 등록,,
 * */



@Controller
public class SecurityController {
	
	@Autowired
	private BCryptPasswordEncoder encoder; //bean에 등록된 것을 주입
	
	@Autowired
	private AES256Util aesUtil;
	
	@ResponseBody
	@RequestMapping(value = "/pw")
	public String encoding() {
		
		String str = "password"; //사용자에게 받은 데이터라 가정하고 처리해보자
		String encodingStr = encoder.encode(str); //str를 암호화처리해본다!!

		boolean result = encoder.matches(str, encodingStr); //문자열 비교 맞는지 아닌지 --> 결과: true 반환
		return str + " : " + encodingStr + "<br>\n"
				+ "str = encodingStr ==> " + result;
	}
	
	
	//단방향
	@ResponseBody
	@RequestMapping(value = "/pw2")
	public String encoding2() {
		
		String str = "password"; //사용자에게 받은 데이터라 가정하고 처리해보자
		String encodingStr = Sha256.encrypt(str); //str를 암호화처리해본다!! //static method라서 바로 가져옴! bean등록 ㄴㄴㄴ 
		String pw = "pass";
		
		boolean result = encodingStr.equals(Sha256.encrypt(pw));  // pw 와 str이 같을까?
		
//		boolean result = encoder.matches(str, encodingStr); //문자열 비교 맞는지 아닌지 --> 결과: false 반환 (새로 받은 걸 암호문으로 따로 바꿔도 값은 동일함ㅋ)
		return str + " : " + encodingStr + "<br>\n"
		+ "str = pw ==> " + result;
	}

	//양방향 알고리즘
	@ResponseBody
	@RequestMapping(value = "/pw3")
	public String encoding3() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		String str = "password"; //사용자에게 받은 데이터라 가정하고 처리해보자
		
		String encodingStr = aesUtil.encrypt(str);
		String decodingStr = aesUtil.decrypt(encodingStr);
		
//		boolean result = encoder.matches(str, encodingStr); //문자열 비교 맞는지 아닌지 --> 결과: false 반환 (새로 받은 걸 암호문으로 따로 바꿔도 값은 동일함ㅋ)
		return str + " : " + encodingStr +" : " + decodingStr + "<br>\n";
	}
	
	
	
	
	
}
