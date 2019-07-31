package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 객체 조립기
 * mainforSpring에서 수정
 * 의존관계자동설정: appCtx4.xml이용
 * */
public class MainForSpring2 {
	
	//private static Assembler assembler = new Assembler();
	
	
	//spring container 생성: 조립기 설정파일인 appCtx1.xml읽고 컨테이너 생성함. 
	//genericXmlAppliCon(Locatoin) :String형식의 주소값을 넣는다.
//	private static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
	private static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
	
	public static void main(String[] args) {
		System.out.println("스프링컨테이너에서 받은 객체");
		System.out.println("");
		MemberRegisterService regService1 = ctx.getBean("regService", MemberRegisterService.class);
		MemberRegisterService regService2 = ctx.getBean("regService", MemberRegisterService.class);
		
		//regService 객체에서 생성된 s1과 s2 의 참조주소 값이 같은지?
		System.out.println("regService1 == regService2 : " + (regService1 == regService2) );
		
		System.out.println("==================================");
		System.out.println("스프링컨테이너에서 받은 객체");
		System.out.println("REG SERVICE");
		
		
		/*chgPwService 의 scope가 prototype임. 객체를 만들 때마다 주소값 다름 즉 같은 parent라도 다른 애들임!!*/
		ChangePasswordService chgPWser1 = ctx.getBean("chgPwService", ChangePasswordService.class);
		ChangePasswordService chgPWser2 = ctx.getBean("chgPwService", ChangePasswordService.class);
		
		boolean chk = chgPWser1 == chgPWser2;
		
		System.out.println("chgPWser1 == chgPWser2 : " + (chk) );
		
		
	}
	
	
}
