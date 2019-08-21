package com.ny.mm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ny.mm.model.Member;
import com.ny.mm.model.member.JoinRestApiRequest;
import com.ny.mm.service.JoinService;
import com.ny.mm.service.MemDelService;
import com.ny.mm.service.MemListService;

@RestController
@RequestMapping("/rest/members")
public class MemberRestFulController {
	
	@Autowired
	private MemListService listService;
	
	@Autowired
	private MemDelService delService;
	
	@Autowired
	private JoinService joinService;
	
	/**
	 * restful 이므로, 
	 * restcontroller 어노테이션ㅇ을 사용하면
	 * @responsebody 생략
	 * 해당 메서드에 @requestMapping 생략
	 * */
	
//	
//	@GetMapping
//	public List<Member> getAllList(){
//	이런 형식으로 사용 하지 않고!	
//	ResponseEntity < 반환형타입 > 을 쓰면 response 할 때 반환형타입 형태로 포장해서 만든다.  
//	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Member>> getAllList(){
		
		List<Member> list = listService.getAllList();
		
		
		/* 객체 생성
		 * ResponseEntity<List<Member>>(body, status)
		 * body 에 반환할 타입 넣어주고,
		 * status에 httpstatus 설정해줌.
		 * */
		
		
		ResponseEntity<List<Member>> entity = new ResponseEntity<List<Member>>(list, HttpStatus.OK );
		
		/* status 정리
		 * HttpStatus.OK 200정상
		 * HttpStatus.NOT_FOUND 404에러
		 * HttpStatus.INTERNAL_SERVER_ERROR 500에러
		 * */
		
		return entity;
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id") String id) {
		
		int cnt = delService.delete(id);
		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail" , HttpStatus.OK) ;
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> regMember(JoinRestApiRequest joinReq, HttpServletRequest request){
		
		System.out.println("check : " + joinReq);
		
		int result = joinService.joinMember(request, joinReq); 
		
		return new ResponseEntity<String>(result > 0 ? "success" : "fail" , HttpStatus.OK);
	}
	
}
