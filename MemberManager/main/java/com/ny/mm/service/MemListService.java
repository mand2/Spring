package com.ny.mm.service;
/*-------------------
 * 파일이름: MemListService.java
 * 파일설명: 회원 리스트 service
 * 작성자: 김나연
 * 버전: 1.0.0
 * 생성일자: 2019-08-07 오전 9시 50분
 * 최종수정일자: 2019-08-07 오전 9시 50분
 * 최종수정자: 김나연
 * 최종수정내용: member manager 스프링으로 변경 
 -------------------*/

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.mm.dao.MemberDAO;
import com.ny.mm.jdbc.ConnectionProvider;
import com.ny.mm.model.ListViewData;
import com.ny.mm.model.Member;
import com.ny.mm.model.SearchMember;

@Service(value = "listService")
public class MemListService {
	
	@Autowired
	private MemberDAO dao;

	final int MEM_PER_CNT = 3; //page당 나올 멤버 수
	
	public ListViewData getListData(int curPageNum, SearchMember searchMember) {
		ListViewData list = new ListViewData();
		Connection conn= null;
		
		
		try {
			conn = ConnectionProvider.getConnection();
			
			//현재페이지번호
			list.setCurPageNum(curPageNum);
			
			//전체 회원수
			int totalCnt = dao.selectTotalCount(conn, searchMember);
			
			//전체 페이지 개수
			int pageTotalCnt = 0;
			
			if( totalCnt > 0) {
				pageTotalCnt = totalCnt / MEM_PER_CNT;
				
				if( totalCnt % MEM_PER_CNT > 0 ) {
					pageTotalCnt ++;
				}
			}
			list.setPageTotalCnt(pageTotalCnt);
			
			//구간 검색을 위한 인덱스 검색해야 함.
			int index = (curPageNum-1) * MEM_PER_CNT;
			
			//총멤버+리스트출력
//			list.setList(dao.selectList(conn, index, MEM_PER_CNT, searchMember));
			
			/* 회원 정보리스트
			 * 검색 조건이 없는 경우 selectList = 전체 회원 리스트 가져오기 
			 * id로 검색: where id like '%?%'
			 * name로 검색: where name like name '%?%'
			 * id+name로 검색: where id like '%?%' or name like '%?%' 
			 * */
			
			List<Member> memberList = null;
			if(searchMember == null) {
				memberList = dao.selectList(conn, index, MEM_PER_CNT);
			} else if (searchMember.getType().equals("1")) {
				memberList = dao.selectListByName(conn, index, MEM_PER_CNT, searchMember);
			} else if (searchMember.getType().equals("2")) {
				memberList = dao.selectListByName(conn, index, MEM_PER_CNT, searchMember);
			} else if (searchMember.getType().equals("3")) {
				memberList = dao.selectListByBoth(conn, index, MEM_PER_CNT, searchMember);
			}
			
			list.setList(memberList);
			
			//no setting
			int no = totalCnt - index;
			list.setNo(no);
			
			
			list.setTotalCnt(totalCnt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
