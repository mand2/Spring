<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼: order</title>
</head>
<body>
	<h1> form : orders
	</h1>
<!-- 	<form action="order" method="post"> -->
	<form method="post"> <!-- action생략시 자기자신에게 보냄. -->
		product 1 - id : <input type="text" name="orderItems[0].itemId">
		product 1 - no : <input type="text" name="orderItems[0].number">
		product 1 - rm : <input type="text" name="orderItems[0].remark">
		<br>
		
		product 2 - id : <input type="text" name="orderItems[1].itemId">
		product 2 - no : <input type="text" name="orderItems[1].number">
		product 2 - rm : <input type="text" name="orderItems[1].remark">
		<br>
		
		product 3 - id : <input type="text" name="orderItems[2].itemId">
		product 3 - no : <input type="text" name="orderItems[2].number">
		product 3 - rm : <input type="text" name="orderItems[2].remark">
		<br>
		
		배송지
		<br>
		우편번호: <input type="text" name="address.zipcode"> <br>	
		주소 1: <input type="text" name="address.address1"> <br>	
		주소 2: <input type="text" name="address.address2"> <br>
		
		<input type="submit">	
	</form>
</body>
</html>