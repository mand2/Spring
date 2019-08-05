package com.bitcamp.mvc.member;
/* 2019-08-02
 * file upload
 * 사실 메서드는 이름 같아도 됨 (overloading 가능,,)
 * -upload1: uplaod.jsp에서 액션으로 받아옴 + @RequestParam이용할거임
 * -upload2: MultipartHttpServletRequest 이용한 파일처리 
 * 		이걸 하려면 request에서 param을 받아와서 처리해줘야 함.
 * -upload3: MultipartHttpServletRequest 이용한 파일처리 : report라는 객체를 받아와서 바로 넘김
 * -path라는 String 써서 uploadfile에 넣어주기 
 * 			--> servlet-Context.xml에서 변동없는 파일들 설정 먼저 해주고 해야 함.
 * 			--> URI의 실제경로와 파일이름을 추출, 서버에 저장할 파일이름으로 unique하게 만들고 업로드
 * */

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.mvc.domain.Report;

@Controller
public class FileUploadController {
	
	String path = "/uploadfile";
	
	
	@RequestMapping("/fileupload/uploadForm")
	public String getForm() {
		 
		return "fileupload/uploadForm";
	}
	
	
	
	
	/*@RequestParam이용한 파일 처리*/
	@RequestMapping(value = "/fileupload/upload1", method = RequestMethod.POST)
	public String upload1(
				@RequestParam("sno") String sno,
				@RequestParam("report") MultipartFile file,
				Model model,
				HttpServletRequest request) {
		
		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename()); //original file name임
		model.addAttribute("fileSize", file.getSize()); //original file name임
		
		/*-  추가: 파일 경로  -*/
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		try {
			
			/*파일이 비어있지 않고 + 사이즈가 있어야 함*/
			if(!file.isEmpty() && file.getSize() > 0 ) { 
				//파일경로와+파일이름을 서버에 저장한다.
				file.transferTo(new File(dir, sno+"_"+file.getOriginalFilename()));
			}

		
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "fileupload/upload";
	}
	
	
	/*MultipartHttpServletRequest 이용한 파일처리*/
	@RequestMapping(value = "/fileupload/upload2", method = RequestMethod.POST)
	public String upload2(
			MultipartHttpServletRequest request,
			Model model) {
		
		String sno = request.getParameter("sno");

		//report(form 내에서의 이름)라는 이름으로 들어온 파일
		MultipartFile file = request.getFile("report"); 
		
		
		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename()); //original file name임
		model.addAttribute("fileSize", file.getSize()); //original file name임
		
		
		return "fileupload/upload";
	}
	
	/*MultipartHttpServletRequest 이용한 파일처리*/
	@RequestMapping(value = "/fileupload/upload3", method = RequestMethod.POST)
	public String upload3( Report report ) {
		
		return "fileupload/upload";
	}
	
}
