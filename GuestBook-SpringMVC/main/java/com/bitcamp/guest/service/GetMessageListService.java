package com.bitcamp.guest.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.dao.MessageDao;
import com.bitcamp.guest.dao.MessageJdbcTemplateDao;
import com.bitcamp.guest.dao.MsgSTDao;
import com.bitcamp.guest.dao.MsgSessionDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.domain.MessageListView;
import com.bitcamp.guest.jdbc.ConnectionProvider;

@Service("listService")
public class GetMessageListService implements GuestBookService {

	
/* 2019-08-05 에 작성한 내용	*/
	/*주입*/
//	@Autowired
//	private MessageDao dao;
//	
//	//1. 한 페이지에 보여줄 게시글의 개수
//	private static final int MESSAGE_COUNT_PER_PAGE = 3;
//	
//	
//	//page마다 보여주는 게시글이 달라짐. 
//	/* MessageListView에 필요한 것들: 
//	 * messageCountPerPage messageTotalCount 
//	 * pageTotalCount curruntPageNumber 
//	 * messageList 
//	 * firstRow endRow
//	 * @pageNumber : 현재 페이지
//	 * @
//	 * */
//	public MessageListView getMessageListView(int pageNumber) {
//		
//		Connection conn = null;
//		int currentPageNumber = pageNumber;
//		MessageListView view = null;
//		
//		try {
//			//Connection
//			conn = ConnectionProvider.getConnection();
//			
//			//전체게시물의개수
//			int messageTotalCount = dao.selectCount(conn);
//			
//			//게시물 내용리스트 & DB의 검색으로 사용할 firstRow endRow 
//			List<Message> messageList = null;
//			int firstRow = 0;
//			
//			if(messageTotalCount > 0 ) {
//				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE ;
//				messageList = dao.selectList(conn, firstRow, MESSAGE_COUNT_PER_PAGE );
//				
//			} else {
//				currentPageNumber = 0;
//				messageList = Collections.emptyList();
//			}
//			view = new MessageListView(MESSAGE_COUNT_PER_PAGE, messageTotalCount, currentPageNumber, messageList, firstRow);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return view ;
//		
//	}
	

	/*---------------------------------------------------------
				2019-08-08에 jdbc템플릿으로 변경
	---------------------------------------------------------*/
//	
//	@Autowired
//	private MessageJdbcTemplateDao dao;
//	
//	private static final int MESSAGE_COUNT_PER_PAGE = 3;
//
//	
//	public MessageListView getMessageListView(int pageNumber) {
//		MessageListView view = null;
//		int currentPageNumber = pageNumber;
//		
//		int msgTotalCnt = dao.selectCount();
//		List<Message> msgList = null;
//		int firstRow = 0;
//		
//		if(msgTotalCnt > 0) {
//			
//			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE ;
//			msgList = dao.selectList(firstRow, MESSAGE_COUNT_PER_PAGE);
//		
//		} else {
//			currentPageNumber = 0;
//			msgList = Collections.emptyList();
//		}
//		
//		view = new MessageListView(MESSAGE_COUNT_PER_PAGE, msgTotalCnt, currentPageNumber, msgList, firstRow);
//		
//		return view;
//	}
	
	/*---------------------------------------------------------
				2019-08-12에 mybatis템플릿으로 변경
	---------------------------------------------------------*/

//	@Autowired
//	private MsgSTDao dao;
//	
//	private static final int MESSAGE_COUNT_PER_PAGE = 3;
//
//	
//	public MessageListView getMessageListView(int pageNumber) {
//		MessageListView view = null;
//		int currentPageNumber = pageNumber;
//		
//		int msgTotalCnt = dao.selectCount();
//		List<Message> msgList = null;
//		int firstRow = 0;
//		
//		if(msgTotalCnt > 0) {
//			
//			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE ;
//			msgList = dao.selectList(firstRow, MESSAGE_COUNT_PER_PAGE);
//		
//		} else {
//			currentPageNumber = 0;
//			msgList = Collections.emptyList();
//		}
//		
//		view = new MessageListView(MESSAGE_COUNT_PER_PAGE, msgTotalCnt, currentPageNumber, msgList, firstRow);
//		
//		return view;
//	}
	
	/*---------------------------------------------------------
			2019-08-12 pm5:10에 자동매퍼기능 사용하여+mybatis 변경
	---------------------------------------------------------*/
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MsgSessionDao dao;
	
	private static final int MESSAGE_COUNT_PER_PAGE = 7;
	
	
	public MessageListView getMessageListView(int pageNumber) {
		
		/*dao 생성*/
		dao = template.getMapper(MsgSessionDao.class);
		
		MessageListView view = null;
		int currentPageNumber = pageNumber;
		
		int msgTotalCnt = dao.selectCount();
		List<Message> msgList = null;
		int firstRow = 0;
		
		if(msgTotalCnt > 0) {
			
			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE ;
			

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("firstrow", firstRow);
			params.put("cntPerPage", MESSAGE_COUNT_PER_PAGE);
			
			msgList = dao.selectList(params);
			
		} else {
			currentPageNumber = 0;
			msgList = Collections.emptyList();
		}
		
		view = new MessageListView(MESSAGE_COUNT_PER_PAGE, msgTotalCnt, currentPageNumber, msgList, firstRow);
		
		return view;
	}
}
