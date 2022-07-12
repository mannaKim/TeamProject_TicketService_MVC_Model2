<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Find Id</title>
	<link href="css/ticket.css" rel="stylesheet">
	<script src="member/member.js"></script>
</head>
<body>
  	<center><h2>아이디 찾기</h2></center>
    <table align="center" bgcolor="black" cellspacing="1" width="400">
    	<tr align="center" bgcolor="#fde8ff">
        	<td width="430">
          		<h3>조회한 회원의 아이디는 ${MemberVO.id} 입니다.</h3>
          		<input type="button" class="submit" value="로그인창으로" onClick="go_login_after_FindAccount();">
          		<input type="button" class="submit" value="비밀번호 찾기" 
          		onClick="location.href='ticket.do?command=findPwdForm&id=${MemberVO.id}'">
        	</td>
      	</tr>
    </table>
</body>
</html>