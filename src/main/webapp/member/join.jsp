<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link href="member/css/member.css" rel="stylesheet">
	<script src="member/member.js"></script>	
</head>
<body>
<div class="clear"></div>
<article id="join_box">
	<div id="join_top">
		<div id="join_logo">
			<a href="ticket.do?command=index"><img src="ticket_image/logo.png"></a>
		</div>
		<div id="join_icon">
			<ul>
				<li>1. 약관동의</li>
				<li>2. 정보입력</li>
				<li>3. 가입완료</li>
			</ul>
		</div>
	</div>
	<form method="post" name="joinFrm" id="joinFrm">
		<fieldset id="join_fild">
			<div id="join_login">
				<div id="join_id" class="join">
					<h3>아이디</h3>
					<input type="text" name="id" size="12" style="width:370px; height:35px; font-size:18px;">
					<input type="hidden" name="idCheck">
					<input type="button" value="중복체크" class="join_checkbox" onclick="idcheck();">
				</div>
				<div id="join_pass" class="join">
					<h3>비밀번호</h3>
					<input type="password" name="pwd" style="width:370px; height:35px; font-size:18px; margin-bottom:20px;">
					<h3>비밀번호 확인</h3>
					<input type="password" name="pwdCheck" style="width:370px; height:35px; font-size:18px;">
				</div>
			</div>
			<div id="join_person">
				<div id="join_name" class="join">
					<h3>이름</h3>
					<input type="text" name="name" style="width:370px; height:35px; font-size:18px;">
				</div>
				<div id="join_phone" class="join">
					<h3>전화번호</h3><input type="text" name="phone" style="width:370px; height:35px; font-size:18px;">
				</div>
				<div id="join_email" class="join">
					<h3>E-Mail</h3>
					<input type="text" name="email" style="width:370px; height:35px; font-size:18px; margin-bottom:20px;">
				</div>
			</div>
			<div id="join_address">
	      		<h3>주소</h3>
	      		<input type="text" name="zip_num" size="10" style="width:370px; height:35px; font-size:18px; margin-bottom:20px;">
	      		<input type="button" value="주소 찾기" class="join_checkbox" onclick="find_address();">
	      		<h3>상세주소</h3>
	      		<input type="text" name="address1" size="50" style="width:370px; height:35px; font-size:18px;">
	      		<input type="text" name="address2" size="25" style="width:370px; height:35px; font-size:18px; margin-top:7px;">
      		</div>
      		<div id="join_buttons">
	      		<input type="button" value="회원가입" class="join_button" onClick="go_join();">
	      		<input type="reset" value="다시쓰기" class="join_button" style="margin-left:7px;">
	      		<input type="button" value="돌아가기" class="join_button" style="margin-left:7px;" onClick="location.href='ticket.do?command=index'">
    		</div>
    	</fieldset>
  	</form>
</article>
</body>
</html>