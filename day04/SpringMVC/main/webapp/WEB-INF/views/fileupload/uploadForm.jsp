<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일처리: requestparam</title>
</head>
<body>
	<h1>@RequestParam이용한 파일 처리</h1>
	<hr>
	<form action="upload1" method="post" enctype="multipart/form-data">
		숙제노예의 학번: <input type="text" name="sno" id="sno">
		노예 리포트파일: <input type="file" name="report" id="report">
		
		<input type="submit" value="숙제노예탈출하자">
	</form>

	<h1>MultipartHttpServletRequest 이용한 파일처리</h1>
	<hr>
	<form action="upload2" method="post" enctype="multipart/form-data">
		숙제노예의 학번: <input type="text" name="sno" id="sno">
		노예 리포트파일: <input type="file" name="report" id="report">
		
		<input type="submit" value="숙제노예탈출하자">
	</form>

	<h1>커맨드 객체를 이용한 파일처리</h1>
	<hr>
	<form action="upload3" method="post" enctype="multipart/form-data">
		숙제노예의 학번: <input type="text" name="sno" id="sno">
		노예 리포트파일: <input type="file" name="report" id="report">
		
		<input type="submit" value="숙제노예탈출하자">
	</form>
</body>
</html>