<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>

<article>
	<form name="frm" method="post" action="ticket.do">
	<input type="hidden" name="command" value="noticeWrite">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${loginUser.id}<input type="hidden" name="id" value="${loginUser.id}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass">수정/삭제를 위해 필요</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title">* 필수</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea cols="70" rows="10" name="content"></textarea>* 필수
				</td>
			</tr>
		</table><br><br>
		<input type="submit" value="등록" onClick="return noticeCheck()">
		<input type="reset" value="다시작성">
		<input type="button" value="목록으로" onClick="location.href='ticket.do?command=adminNotice'">
	</form>

</article>

<%@ include file="../../footer.jsp" %>