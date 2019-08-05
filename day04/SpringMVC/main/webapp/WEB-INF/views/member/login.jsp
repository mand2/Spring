<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		로그인 결과페이지
	</h1>
	<hr>
	<!-- 이건 사용자에게 보여주면 안~됨~! -->
	id : ${id } <br> 
	${login.id} <br> <!-- LoginOk -->
	${user.id} <br> <!-- LoginOk2 -->
	
	pw : ${pw } <br>
	${login.pw} <br>
	${user.pw} <br> <!-- LoginOk2 -->
	
</body>
</html>