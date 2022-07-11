<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<div align="center">
    <h1>비밀번호 확인</h1>
    <form name="frm" method="post" action="ticket.do">
      <input type="hidden" name="command" value="checkPwd">
      <input type="hidden" name="id" value="${id}">
      <input type="hidden" name="purpose" value="${purpose}">
      <table style="width:80%">
	    <tr>
	      <th>비밀번호</th>
	      <td><input type="password" name="pwd" size="20"></td>
	    </tr>    
      </table>
      <br>
      <input type="submit" value="확인" onClick="return pwdCheck()">
      <br><br>
      ${message}
    </form>
</div>
<%@ include file="../footer.jsp" %>