package member;
/*membermanagerJAVA에서 연결받음,
 * container 연습: property주입방식
 * 어노테이션 연습 : 생성자 다 삭제.
 * 2019.07.30*/

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	
	@Autowired
	private MemberDao memberDao;
	
	
	
	/*
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	*/
	/*생성자를 사용하여 memberDao 주입 == DI*/
	/*
	 * public ChangePasswordService(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */
	
	public void changePassword(String email, String oldPassword, String newPassword) throws MemberNotFoundException, IdPasswordNotMatchException {
		Member member = memberDao.selectByEmail(email);
	
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
		
	}
	
	
}
