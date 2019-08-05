<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역: 전체확인하기</title>

<style>
	* {
		margin: 0;
		padding: 0;
	}
	
	div {
		width: 450px;
		border : 1px solid #ccc;
		padding : 10px;
		margin: 5px auto;
	}
</style>
</head>
<body>

	<h1> 주문내역: 전체확인 </h1>
		
		<c:forEach var="item" items="${orders.orderItems}">
			<div>
				상품이름: ${item.itemId} <br>		
				상품개수: ${item.number} <br>			
				상품주의: ${item.remark} <br>			
			</div>	
		</c:forEach>
	
	<h1> 배송지 </h1>
		<div>
			우편번호: ${orders.address.zipcode}<br>
			주 소 1 : ${orders.address.address1}<br>
			주 소 2 : ${orders.address.address2}<br>
		</div>
	
		
</body>
</html>