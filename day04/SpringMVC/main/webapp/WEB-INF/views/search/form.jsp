<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search 폼</title>
<style>
	*{padding: 0; margin: 0;}
	
	#popularList {
		width: 500px;
		margin: 0 100px 10px;	
	}
	
	h1{
		margin-bottom: 20px;
	}
</style>

</head>
<body>
	<h1>검색</h1>
	
	인기검색어 : 
		<div id="popularList">
			<c:forEach items="${popularList}" var="keyword">
				${keyword} <br>
			</c:forEach>
		</div>
	<select>
		<option>선택</option>
		<!-- 반복시켜야할 부분 -->
		<c:forEach items="${searchType}" var="option">		
			<option value="${option.no}">${option.name}</option>
		</c:forEach>
	</select>
	
	
	
</body>
</html>