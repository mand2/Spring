package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 객체 조립기
 * */
public class MainForAssembler {
	
	private static Assembler assembler = new Assembler();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어 입력plzzzz");
			String command = reader.readLine();
			
			//시스템종료키워드
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("빠ㅏㅏㅏㅏ이 안니용!");
				break;
			}
			
			//시스템시작키워드
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" ")); //띄어쓰기를 따라 반환해준다.
			}
			if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
			}
		}
	}
	
	
	/*------main메서드 내에서 부를 메서드들------*/
	//새로운애들
	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		
		//의존성낮추기
		MemberRegisterService service = assembler.getRegService();
		RegisterRequest request = new RegisterRequest();
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		
		//비번다를때?
		if(!request.isPwEqualToConfirmPw()) {
			System.out.println("암호 불일치!!");
			return;
		}
		
		
		try {
			service.regist(request);
			System.out.println("***** 등록되었습니다.");
			
			
		} catch (AlreadyExistMemberException e) {
			e.printStackTrace();
			System.out.println("이미 존재하는 이메일!");
		}
	}
	
	//pw변경
	private static void processChangeCommand(String[] args) {
		
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService service = assembler.getPwService();
		
			try {
				service.changePassword(args[1], args[2], args[3]);
				System.out.println("***** 암호변경되었어요!!");
				
			} catch (MemberNotFoundException e) {
				e.printStackTrace();
				System.out.println("존재하지않는이메일");
			} catch (IdPasswordNotMatchException e) {
				e.printStackTrace();
				System.out.println("이메일과 암호 불일치");
			}
			
		
	}
	
	private static void printHelp() {
		System.out.println("");
		System.out.println("잘못된 명령 구문임~! 아래 명령 사용법 확인필!"); 
		System.out.println("new 이메일 사용자이름 암호 암호확인"); 
		System.out.println("chagne 이메일 현재암호 새암호"); 
	}
}
