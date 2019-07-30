package member;

public class Assembler {
	private MemberDao memberDao ;
	private MemberRegisterService regService;
	private ChangePasswordService pwService;
	
	public Assembler() {
		memberDao = new MemberDao();
		regService = new MemberRegisterService(memberDao);
		pwService = new ChangePasswordService(memberDao); 
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegService() {
		return regService;
	}

	public ChangePasswordService getPwService() {
		return pwService;
	}
	
	
	
}
