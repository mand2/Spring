<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>email 인증 신청</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="<c:url value='../css/default.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='../css/regform.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<!-- nav 시작 -->
<%@ include file="../frame/nav.jsp" %>
<!-- nav 끝-->

<!-- header 시작 -->
<%@ include file="../frame/header.jsp" %>
<!-- header 끝-->

<!-- contents 시작 -->
	
	<div class = "wrap">
        <h2>이메일 인증 신청</h2>
            <form method="post" action="verify/${loginInfo.id}">
	            <div id="regForm">
	                <!--input 의 width값을 길게 주면 아래 행으로 넘어가니까 효과 있음!-->
	                <!--.inputbox는 박스 클릭시 색상 주기, .input은 width설정-->
	                
	                
	                <input type="hidden" id="id" name="name" value="${loginInfo.id}">
	                
	                <div class="warning">
	                    <label for="email"><h4>이메일</h4></label>
	                    <span class="inputbox"><input type="text" name = "email" id="email" class="input"></span>
	                    <h5></h5>
	                </div>
	                <input type="submit" value="이메일 인증하기">
	            </div>
	         </form>
	</div>
	
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->	
</body>
</html>