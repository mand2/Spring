<%@ page session="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
<title>::WELCOME::</title>
<link href="<c:url value='/css'/>/default.css" rel="stylesheet" type="text/css">
	
</head>
<body>


<!-- nav 시작 -->
<%@ include file="frame/nav.jsp" %>
<!-- nav 끝-->

<!-- header 시작 -->
<%@ include file="frame/header.jsp" %>
<!-- header 끝-->

<!-- contents 시작 -->
	<section>
        <div class="bkg">
        	<span class="img_bkg"></span>
        </div>
        <article>
            <p>moon child는 일상생활에 지친 하루를 마무하며 취미를 공유하는 신개념 복합공간입니다.</p>
            <p>쉽게 접할 수 있는 주제에 대해 친구와 잡담하듯 솔직하게 공유하고자 합니다.</p>
            <p>사람들과의 소통을 통해 자신이 찾고자 하는 혹은, 알지 못했던 관심사를 알아낼 수 있습니다.</p>
        </article>
    
    </section>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="frame/footer.jsp" %>
<!-- footer 끝-->



</body>
</html>
