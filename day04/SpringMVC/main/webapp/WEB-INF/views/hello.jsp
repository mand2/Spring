<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GREETINGS</title>

<style>
	* {
		padding: 0;
		margin: 0;
	}
	
	div {
		width: 500px;
		text-align: center;
		margin: 0 auto;
		padding: 20px;
	}
	
	div span {
		font-size: 24px;
		display: block;
		background-color: #e9f9f8;		
	}
</style>
</head>
<body>
<h1>HELLO.jsp</h1>

<div>
	<span>userName: ${userName}</span>
	<span>greeting: ${greeting}</span>
	<span>now: ${now}</span>
	
</div>
<div>
	<a href="<c:url value='/header/getHeader'/>">/header/getHeader</a>
</div>
</body>
</html>