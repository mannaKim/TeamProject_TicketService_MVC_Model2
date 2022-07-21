<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_image_menu.jsp"%>
<article>
	<br><br>
	<div class="chkPwdBox">
		<br>
		<form name="frm" method="post" action="ticket.do">
			<input type="hidden" name="command" value="checkPwd">
			<input type="hidden" name="id" value="${id}">
			<input type="hidden" name="purpose" value="${purpose}">
			<div class="chkPwd">
				<table>
					<tr>
						<th colspan="2"><h1>비밀번호 확인</h1><br></th>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pwd" size="15"></td>
					</tr>
				</table>
			</div>
			${message} <br>
			<input type="submit" value="확인"
				class="goodsButton1" onClick="return pwdCheck()">
		</form>
		<br>
	</div>
	<br><br>
</article>
<%@ include file="../footer.jsp"%>