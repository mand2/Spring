package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSendController {
	
	@Autowired
	MailSender sender;
	
	@Autowired
	JavaMailSender jmsender;
	
	
	//MailSender를 이용해 메일보내기
	@ResponseBody
	@RequestMapping("/mail/send")
	public String sendMail() {
		
		//메일내용설정해주기
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("atpletrea@naver.com");
		message.setSubject("hiiiiiiiiiiiii");
		message.setText("my first email to send a letter");
		message.setFrom("atpletrea@gmail.com");
		
		sender.send(message);
		
		return "send OK";
	}
	
	@ResponseBody
	@RequestMapping("/mail/send/javamail")
	public String sendJavaMailSender() {
		
		MimeMessage message = jmsender.createMimeMessage();
		try {
			//메일제목설정
			message.setSubject("[안내] 처음보내는 JAVAMAIL SENDER", "utf-8");
			
			//html메일내용
			String htmlStr = "<h1 style=\"color: lightblue;\">hi everyone~~</h1>"
					+ "<a href=\"http://www.naver.com\">naver</a>";
			
			//내용설정 (subtype)을 설정해주지 않으면 그냥 다 전해짐,, 태그를 텍스트로 인식!
			message.setText(htmlStr, "utf-8", "html");
			
			//TO 설정 
			/**인터넷어드레스를 쓰는 이유?
			 * 뒤에 사용자 이름을 보내줄 수 있음 
			 * 홍길동 님 이런식으루,,
			 * */
			message.addRecipient(RecipientType.TO, new InternetAddress("atpletrea@naver.com", "ny 님", "utf-8"));
			
			jmsender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return "send OK";
	}
	
	
	@RequestMapping("/mail/send/file")
	@ResponseBody
	public String sendFileAttach() {
		
		MimeMessage message = jmsender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			
			//title
			helper.setSubject("[info] file attatched");
			
			//content html
			String htmlStr = "<h1>file has been attatched . please download the file I send </h1>";
			
			//content setting
			helper.setText(htmlStr, true);
			
			//to
			helper.setTo(new InternetAddress("atpletrea@naver.com", "만득이 님", "utf-8"));
			
			//create file instance + absolute root
			DataSource dataSource = new FileDataSource("d:\\memory leak 경고.txt");
			helper.addAttachment(MimeUtility.encodeText("memory leak 경고.txt", "utf-8", "B"), dataSource);
			/** MimeUtility.encodeText()
			 * Parameters:
			 * text: the header value
			 * charset: the charset. If this parameter is null, the platform's default chatset is used.
			 * encoding: the encoding to be used. 
			 * 			Currently supported values are "B" and "Q". 
			 * 			B: binary
			 * Returns: Unicode string containing only US-ASCII characters
			 * */
			
			jmsender.send(message);
		
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "send ok";
	}
}
