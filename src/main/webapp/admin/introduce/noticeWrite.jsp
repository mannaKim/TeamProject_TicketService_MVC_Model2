<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>

<article id="adminNotice_write">
	<h2 align="center">공지사항 작성</h2>
	<form name="frm" method="post" action="ticket.do">
	<input type="hidden" name="command" value="noticeWrite">
		<table>
			<tr>
				<th width="100" height="40">작성자</th>
				<td>${loginUser.id}<input type="hidden" name="id" value="${loginUser.id}"></td>
			</tr>
			<tr>
				<th width="100" height="40">* 비밀번호</th>
				<td><input type="password" name="pass" style="width:180px; height:25px; font-size:16px;">&nbsp;&nbsp;수정/삭제를 위해 필요</td>
			</tr>
			<tr>
				<th width="100" height="40">* 제목</th>
				<td><input type="text" name="title" style="width:180px; height:25px; font-size:16px;"></td>
			</tr>
			<tr>
				<th width="100">* 내용</th>
				<td>
					<textarea cols="70" rows="13" name="content" style="font-size:16px;"></textarea>
				</td>
			</tr>
		</table>
		<br>
		<div id="adminNoticewt_btn">
			<input type="submit" value="등록" onClick="return noticeCheck()" style="width:70px; height:30px;">
			<input type="reset" value="다시작성" style="width:100px; height:30px;">
			<input type="button" value="목록으로" onClick="location.href='ticket.do?command=adminNotice'" style="width:100px; height:30px;">
		</div>
	</form>

</article>

<%@ include file="../admin_footer.jsp" %>