<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="intro_header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<div id="wrap" align="center">
<h1>게시글 수정</h1>
	<form method="post" name="frm" action="ticket.do">
	<input type="hidden" name="command" value="updateNotice">
	<input type="hidden" name="ntnum" value="${notice.ntnum}">
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${notice.id}<input type="hidden" name="id" value="${notice.id}"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" size="12">* (게시글 수정/삭제시 필요합니다.)</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${notice.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="70" rows="15" name="content">${notice.content}</textarea>*
			</td>
		</tr>
	</table>
	<br><br>
	<input type="submit" value="수정" onClick="return noticeCheck()">
	<input type="reset" value="다시작성">
	<input type="button" value="돌아가기" onClick="location.href='ticket.do?command=noticeViewNoCount&ntnum=${notice.ntnum}'">
	</form>
</div>


<%@ include file="../footer.jsp" %>