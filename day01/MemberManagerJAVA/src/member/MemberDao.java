package member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	/* 20190729: 일단 조립기 역할까지만 보기. DB설정안하고,,
	 * @map : String email로 저장된 맵
	 * */
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<String, Member>();
	
	//email을 받아서 해당 멤버 반환
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	//member넣기
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	//member변경
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll(){
		return map.values();
	}
	
	
	
}
