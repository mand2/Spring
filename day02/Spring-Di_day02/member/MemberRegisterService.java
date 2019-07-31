package member;
/*membermanagerJAVA에서 연결받음,
 * container 연습
 * 어노테이션 연습 : 생성자 다 삭제.
 * 2019.07.30*/
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao ;
	
	/*setter 메서드를 사용하면, appctx1.xml에서 빈생성 안하고 property주입방식으로 사용*/
	/*
	 public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	*/
	
	
	/*
	 public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	*/
	public void regist(RegisterRequest request) throws AlreadyExistMemberException	{
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new AlreadyExistMemberException();
		}
		
		Member newMem = new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());
		memberDao.insert(newMem);
	}
	
}
