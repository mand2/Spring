<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form2</title>
</head>
<body>

	<h1>
	LOGIN FORM
	</h1>
	
	<hr>
	<!-- 자기자신에게 준다 -->
	<form action="memberLogin" method="post">
		아이디: <input type="text" name="id" id="id">
		<br>
		비밀번호: <input type="password" name="pw" id="pw">
		<br>
		<input type="submit" value="login" id="btn">	
	</form>
	
</body>
</html>