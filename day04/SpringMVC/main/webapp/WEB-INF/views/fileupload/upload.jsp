<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 확인</title>
</head>
<body>
	<h1>파일업로드:uploadForm > upload1/2 > upload.jsp로</h1>
	<h3>
		숙제노예의학번 : ${sno} <br>
		노예 리포트의 이 름 : ${fileName} <br>
		노예 리포트의 사이즈 : ${fileSize} byte<br>
	</h3>
	
	<h1>파일업로드:uploadForm > upload3 > upload.jsp로</h1>
	<h3>
		숙제노예의학번 : ${report.sno} <br>
		노예 리포트의 이 름 : ${report.fileName} <br>
		노예 리포트의 사이즈 : ${report.fileSize} byte <br>
	</h3>
</body>
</html>