<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Find Id</title>
	<link href="member/css/member.css" rel="stylesheet">
	<script src="member/member.js"></script>
</head>
<body>
  	<h2 align="center">아이디 찾기</h2>
  	<form method="post" name="frm" action="ticket.do" id="findid_box">
    	<input type="hidden" name="command" value="findId">
    	<table>
      		<tr>
        		<td id="findid_name" class="find_id">
          			<h3>이름</h3>
          			<input type="text" name="name" value="${name}" style="width:380px; height:35px; font-size:18px; margin-top:7px;">
        		</td>
      		</tr>
      		<tr>
      			<td class="find_id">
          			<h3>전화번호</h3>
          			<input type="text" name="phone" value="${phone}" style="width:380px; height:35px; font-size:18px; margin-top:7px;">
        		</td>
      		</tr>
      		<tr>
        		<td align="center">
          			<h3><input type="submit" value="아이디 찾기" style="width:150px; height:35px;"></h3>
          			${msg}
        		</td>
      		</tr>
    	</table>
	</form>
</body>
</html>