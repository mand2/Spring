<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- json으로 ~! jackson통해서 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::jackson:: list</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
<link href="<c:url value='/css' />/default_css.css" type="text/css" rel="stylesheet">

</head>
<body>
	<!-- board List 보여주기~ MessageListView -->
	<div class="wrap">
		<div class="menu">
			<h1><a href="writeForm">방명록 남기기</a></h1>
		</div>
		
		<div id="list">
		</div>
		<div id="page">
			<div id="paging"></div>
		</div>
		
				
	</div>
	
</body>
</html>

<script>
	$(document).ready(function() {
		page(1);
	});
	
	/* page function */
	function page(num) {
		$.ajax({
			url : 'listj',
			type : 'get',
			data : {
				page : num
			},
			success : function(data) {
				//alert(data);
				//console.log(data);
				//alert(data.messageTotalCount);
				//alert(JSON.stringify(data));

				var list = data.messageList;
				var output = '';
				for (var i = 0; i < list.length; i++) {

					console.log(list[i]);

					var id = list[i].id;
					var guestName = list[i].guestName;
					var message = list[i].message;

					output += '<div class="msg">\n';
					output += '메세지 번호 : ' + id + '<br>\n';
					output += '작성자 : ' + guestName + '<br>\n';
					output += '내용 : ' + message + '<br>\n';
					output += '<a href="guest/delete?messageID='+id+'">삭제하기</a>';
					output += '</div>\n';
				}

				var page = data.pageTotalCount;
				//alert(page);
				var pageCnt = '';
				

				for (var p = 1; p < page + 1; p++) {
					pageCnt += '<span class="page_box"><a onclick="page('+p+')">'+ p + '</a></span> ';
					/* 개인적으로 초기에 작성한 것
					pageCnt += '<span class="page_box"><a href="list_j.jsp?page='+ p +'">'+ p + '</a></span> '; 
					*/
				}

				$('#list').html(output);
				$('#paging').html(pageCnt);
			}

		});
	}

</script>
