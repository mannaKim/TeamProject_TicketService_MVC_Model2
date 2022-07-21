<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<article>
	<form name="frm" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${loginUser.id}<input type="hidden" name="id" value="${loginUser.id}"></td>
			</tr>
			<tr>
				<th>이벤트명</th>
				<td><input type="text" name="title" size="80"></td>
			</tr>
			<tr>
				<th>이벤트기간</th>
				<td><input type="text" name="evdate" size="80"></td>
			</tr>
			<tr>
				<th>당첨자발표일</th>
				<td><input type="text" name="evperson" size="80"></td>
			</tr>
			<tr>
				<th>배너이미지</th>
				<td><input type="file" name="eimage"></td>
			</tr>
			<tr>
				<th>메인이미지</th>
				<td><input type="file" name="eimage2"></td>
			</tr>
		</table><br><br>
		<input type="button" value="등록" onClick="event_save()">
		<input type="button" value="돌아가기" onClick="location.href='ticket.do?command=adminEvent'">
	</form>
</article>

<%@ include file="../admin_footer.jsp" %>