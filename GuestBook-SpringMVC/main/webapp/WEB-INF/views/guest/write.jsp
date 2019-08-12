<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeMessage</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>

		<c:if test="${result == 1}">
			<c:out value="Y"/>
		</c:if>	
		
		<c:if test="${!(result == 1) }">
			<c:out value="N"/>
		</c:if>
                                                                                                                                                 

</body>
</html>