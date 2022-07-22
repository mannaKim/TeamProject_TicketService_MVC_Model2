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
  	<form method="post" name="frm" action="ticket.do" id="findpwd_box">
    	<input type="hidden" name="command" value="findPwdStep1">
    	<table>
      		<tr>
        		<td id="findpwd_id" class="find_pwd">
          			<h3>아이디</h3>
          			<input type="text" name="id" value="${id}" style="width:380px; height:35px; font-size:18px; margin-top:7px;">
        		</td>
      		</tr>
      		<tr>
        		<td id="findpwd_name" class="find_pwd">
         			<h3>이름</h3>
         			<input type="text" name="name" value="${name}" style="width:380px; height:35px; font-size:18px; margin-top:7px;">
        		</td>
      		</tr>
      		<tr>
        		<td class="find_pwd">
          			<h3>전화번호</h3>
          			<input type="text" name="phone" value="${phone}" style="width:380px; height:35px; font-size:18px; margin-top:7px;">
        		</td>
      		</tr>
      		<tr>
        		<td align="center">
          			<h3><input type="submit" value="인증번호 전송" style="width:150px; height:35px;"></h3>
          			${msg}
       			</td>
      		</tr>
    	</table>
	</form>
</body>
</html>