<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!-- join / form.jsp 회원가입 -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member REG FORM</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="<c:url value='../css/default.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='../css/regform.css'/>" rel="stylesheet" type="text/css">

<style>
	.color_red {
		color: red;
	}
	.color_blue {
		color:blue;
	}
</style>
</head>

<body>
<!-- nav 시작 -->
<%@ include file="../frame/nav.jsp" %>
<!-- nav 끝-->

<!-- header 시작 -->
<%@ include file="../frame/header.jsp" %>
<!-- header 끝-->

<!-- contents 시작 -->


<div class = "wrap">
        <h2>회원가입</h2>
        <form method="post" enctype="multipart/form-data" id="">
            <div id="regForm">
                <!--input 의 width값을 길게 주면 아래 행으로 넘어가니까 효과 있음!-->
                <!--.inputbox는 박스 클릭시 색상 주기, .input은 width설정-->
                
                <div class="warning">
                    <label for="id"><h4>아이디</h4></label>
                    <span class="inputbox"><input id="id" name="id" class="input"></span>
                    <input type="checkbox" id="idcheck">
                    <h5></h5>
                </div>
                
                <div class="warning">
                    <label for="pw"><h4>비밀번호</h4></label>
                    <span class="inputbox"><input id="pw" name="pw" class="input" type="password"></span>
                    <h5></h5>
                </div>
                
                <div class="warning">
                    <label for="name"><h4>이름</h4></label>
                    <span class="inputbox"><input id="name" name="name" class="input"></span>
                    <h5></h5>
                </div>

                <div class="warning">
                    <label for="photo"><h4>사진</h4></label>
                    <span class="inputbox"><input type="file" name = "photo" id="photo"></span>
                    <h5></h5>
                </div>
                
                
                <input type="submit" value="회원가입">
            </div>
        </form>
    </div>



<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->

<script>
	$(document).ready(function(){
		$('#id').focusout(function(){
			//ajax id전송 사용유무에 대한 결과 값 반환
			$.ajax({
				url: 'idcheck2', /* jsp를 사용하지 않고 바로 연결 */
				method: 'get',
				data: {
					id : $(this).val()
				},
				success: function(data){
						$(this).closest('h5').html('');
						$('#idcheck +h5').removeClass('color_red');
						$('#idcheck +h5').removeClass('color_blue');
						
					
					if(data == 'Y'){
						$('#idcheck').prop('checked', true);
						$('#idcheck +h5').html('사용가능한 멋진 아이디!');
						$('#idcheck +h5').addClass('color_blue');
					} else {
						$('#idcheck').prop('checked', false);
						$('#idcheck +h5').html('사용중인 아이디이거나 탈퇴한 회원입니다.');
						$('#idcheck +h5').addClass('color_red');
					}
				}
			});
		});
		
		$('form').submit(function() {
			if(!$('#idcheck').prop('checked')){
				alert('아이디체크');
				return false;
			}
		});
		
	});
</script>

</body>

</html>