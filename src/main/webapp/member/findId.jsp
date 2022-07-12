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
  	<form method="post" name="frm" action="ticket.do">
    	<input type="hidden" name="command" value="findId">
    	<table align="center" bgcolor="black" cellspacing="1" width="400">
      		<tr align="center" bgcolor="#fde8ff">
        		<td width="430">
          			<h3>성명<input type="text" name="name" value="${name}"></h3>
        		</td>
      		</tr>
      		<tr align="center" bgcolor="#fde8ff">
      			<td width="430">
          			<h3>전화번호<input type="text" name="phone" value="${phone}"></h3>
        		</td>
      		</tr>
      		<tr align="center" bgcolor="#fde8ff">
        		<td width="430">
          			<h3><input type="submit" value="아이디 찾기"></h3>
          			${msg}
        		</td>
      		</tr>
    	</table>
	</form>
</body>
</html>