package member;

import java.util.Date;

public class MemberRegisterService {
	
	private MemberDao memberDao ;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest request) throws AlreadyExistMemberException	{
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new AlreadyExistMemberException();
		}
		
		Member newMem = new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());
		memberDao.insert(newMem);
	}
	
}
