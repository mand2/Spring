package member;

public class ChangePasswordService {

	private MemberDao memberDao;

	
	/*생성자를 사용하여 memberDao 주입 == DI*/
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPassword, String newPassword) throws MemberNotFoundException, IdPasswordNotMatchException {
		Member member = memberDao.selectByEmail(email);
	
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
		
	}
	
	
}
