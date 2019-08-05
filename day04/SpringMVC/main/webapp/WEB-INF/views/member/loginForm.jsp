<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form</title>
</head>
<body>

	<h1>
	LOGIN FORM
	</h1>
	
	<hr>
	
<!-- 	
	loginController - getLoginForm
	자기자신으로 넘김	
	<form action="loginCheck" method="post"> 
-->
<!--
	loginController - loginCheck
	<form action="loginChk" method="post">
-->	
<!-- loginController - loginOk 
	<form action="loginOk" method="post">
-->	
<!-- loginController - loginOk2 -->
	<form action="loginOk2" method="post">
		아이디: <input type="text" name="id" id="id">
		<br>
		비밀번호: <input type="password" name="pw" id="pw">
		<br>
		<input type="submit" value="login" id="btn">	
	</form>
	
</body>
</html>