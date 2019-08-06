<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="nav">
		
		<!-- jstl 로 경로만들기 -->
		<ul>
			<li><a href="<c:url value='/'/>">홈</a></li>
			<li><a href="<c:url value='/login/form'/>">로그인</a></li>
			<li><a href="<c:url value='/join/form'/>">회원가입</a></li>

			<%-- <li><a href="<c:url value='/member/myPage.do'/>">MyPage</a></li>
			<li><a href="<c:url value='/member/logout.do'/>">LOG OUT</a></li> --%>
			<li><a href="<c:url value='/member/list'/>">member</a></li>
		</ul>
		
</nav>
