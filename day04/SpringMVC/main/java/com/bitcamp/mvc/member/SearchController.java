package com.bitcamp.mvc.member;
import java.util.ArrayList;
/* 2019-08-02
 * 검색타입을 객체로 가져와서 view에 반환!
 * -getSearchType : List 사용 + ModelAttribute사용
 * -poluarList : 스트링배열 + ModelAttribute사용
 * */
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.mvc.domain.SearchType;

@Controller
public class SearchController {
	
	@RequestMapping("/search/search")
	public String searchForm() {
		return "search/form";
	}
	
	@ModelAttribute("searchType")
	public List<SearchType> getSearchType(){
		List<SearchType> options = new ArrayList<SearchType>();
		
		options.add(new SearchType(1, "ALL"));
		options.add(new SearchType(2, "TITLE"));
		options.add(new SearchType(3, "CONTENTS"));
		options.add(new SearchType(3, "TITLE + CONTENTS"));
		
		return options;
	}
	
	@ModelAttribute("popularList")
	public String[] getPopularList() {
		return new String[] {
				"김석진이 제일 잘생김",
				"김태형 세일미",
				"잘생긴게 최고입니다",
				"최고의 복지는 잘생긴 사람이 있는 것"
				};
	}
	
}
