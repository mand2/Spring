package com.ny.mm.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.mm.dao.MemberDAO;
import com.ny.mm.dao.MemberStDao;
import com.ny.mm.model.Member;
import com.ny.mm.model.member.VerifyMember;

@Service("verifyService")
public class VerifyService {
	
	@Autowired
	private SqlSessionTemplate template;
	private MemberStDao dao;
	
	@Autowired
	private MailSenderService mailService;
	
	//인증
	public String verify(String id, String code) {
		
		dao = template.getMapper(MemberStDao.class);
		int result = 0;
		
		result = dao.updateVerify(id, code);
		
		return result>0 ? "Y" : "N";
	}
	
	
	//미인증 메일 보내기
	public int reSend(String id, VerifyMember vMem) {
		
		dao = template.getMapper(MemberStDao.class);
		Member member = dao.selectById(id);
		System.out.println("멤버 메일보내기 전 멤버확인: "+ member);
		
		System.out.println("바꿀멤버: " + vMem);
		
		member.setId(vMem.getId());
		member.setEmail(vMem.getEmail());
		
		System.out.println("멤버 바꾼 후 : " + member);
		
		dao.updateEmail(member);
		
		return mailService.send(member);
	}
}
