<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX page</title>

<style>
	* { margin: 0; padding: 0;}
	a:visited {
		color: inherit;
	}
}
</style>
</head>
<body>
<h1>INDEX page</h1>

	<ul>
	<!-- 컨텍스트경로 / hello를 하던지 hello만 쓰던지 노상관 -->
		<li> <a href="hello">/hello</a></li> 
		<li> <a href="/mvc/hello">/mvc/hello</a></li> <!-- 맨앞에 /는 루트임ㅎㅎ 없으면 상대경로가됨 -->
		<li> <a href="member/login">login</a></li> <!-- 상대경로 -->
		<li> <a href="<c:url value='/member/memberLogin'/>">/member/memberLogin</a></li> <!-- jstl로. include시 경로 변경되니까 쉽게 -->
		<li> <a href="<c:url value='/order/order'/>">/order/order</a></li> 
		<li> <a href="<c:url value='/cookie/makeForm'/>">/cookie/makeForm</a></li> 
		<li> <a href="<c:url value='/cookie/viewCookie'/>">/cookie/viewCookie</a></li> 
		<li> <a href="<c:url value='/header/getHeader'/>">/header/getHeader</a></li> 
		<li> <a href="<c:url value='/search/search'/>">/search/search</a></li> 
		<li> <a href="<c:url value='/fileupload/uploadForm'/>">파일업로드-숙제노예</a></li> 
		<li> <a href="<c:url value='/mc/simple'/>">REST API test 0813</a></li> 
		<li> <a href="<c:url value='/guest/xmlList.xml'/>">XML list _ guest message</a></li> 
		<li> <a href="<c:url value='/mail/send'/>">mail</a></li> 
		<li> <a href="<c:url value='/mail/send/javamail'/>">mail_javaMailSend</a></li> 
		<li> <a href="<c:url value='/mail/send/file'/>">mail_file</a></li> 
	</ul>
	
</body>
</html>