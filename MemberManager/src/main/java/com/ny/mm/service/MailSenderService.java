package com.ny.mm.service;

import java.io.UnsupportedEncodingException;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ny.mm.model.Member;

@Service("mailSenderService")
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;
	
	public int send(Member member) {
		
		int result = 0;
		MimeMessage message = sender.createMimeMessage();
		
		String name = member.getName() + " 님";
		String email = member.getEmail();
		String id = member.getId();
		String code = member.getCode();
		
		try {
			message.setSubject("[info] Welcome TO Our WEBSITE", "utf-8");
			
			String htmlMsg = "<h1>회원가입을 축하합니다~</h1>";
			htmlMsg += "<h1>사랑합니다 "+name+"!</h1>";
			htmlMsg += "<a href = \"http://localhost:8080/mm/join/verify?id="+id+"&code="+code+"\">인증하기 클릭</a>";
			
			message.setText(htmlMsg, "utf-8", "html");
			message.addRecipient(RecipientType.TO, new InternetAddress(email, name, "utf-8"));

			sender.send(message);
		
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		
		return 1;
	}
}
