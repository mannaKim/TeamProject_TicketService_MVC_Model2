<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Find Password</title>
	<link href="member/css/member.css" rel="stylesheet">
	<script src="member/member.js"></script>
</head>
<body>
  	<h2 align="center">비밀번호 찾기</h2>
  	<form method="post" name="frm" action="ticket.do" id="findStep_box">
    	<input type="hidden" name="command" value="findPwdStep2">
    	<table>
      		<tr>
        		<td class="findStep_opt">
          			<h3>아이디 : ${id}</h3>
          			<input type="hidden" name="id" value="${id}">
        		</td>
      		</tr>
      		<tr>
        		<td class="findStep_opt">
         			<h3>성명 : ${name}</h3>
         			<input type="hidden" name="name" value="${name}">
        		</td>
      		</tr>
      		<tr>
        		<td class="findStep_opt">
          			<h3>전화번호 : ${phone}</h3>
          			<input type="hidden" name="phone" value="${phone}">
        		</td>
      		</tr>
      		<tr>
        		<td id="fintStep_num">
          			<h3>인증번호</h3><input type="text" name="confirmNum" style="width:380px; height:35px; font-size:18px; margin-top:7px;">
          			<br>전송받은 번호를 입력하세요
          			<br>${msg}<br>
          			<div id="fintStep_btn">
          				<input type="submit" value="인증번호 확인" style="width:150px; height:35px;">
          			</div>
       			</td>
      		</tr>
    	</table>
	</form>
</body>
</html>