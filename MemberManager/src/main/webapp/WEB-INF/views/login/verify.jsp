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
<title>email 인증 전송</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="<c:url value='/css/default.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/css/regform.css'/>" rel="stylesheet" type="text/css">
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
        <h2>메일 전송하였습니다.</h2>
	    <div class="btn_click">
	    	<span><a href="<c:url value='/'/>">홈으로</a></span>
	    	<span><a href="<c:url value='/login/form'/>">로그인</a></span>
	    </div>
</div>	
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->	
</body>
</html>