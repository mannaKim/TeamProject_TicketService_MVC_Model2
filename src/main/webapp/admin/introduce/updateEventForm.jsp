<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>

<div id="wrap" align="center">
	<form method="post" enctype="multipart/form-data" action="ticket.do?command=update">
		<input type="hidden" name="evnum" value="${eventVO.evnum}">
		<input type="hidden" name="oldPicture1" value="${eventVO.eimage}">
		<input type="hidden" name="oldPicture2" value="${eventVO.eimage2}">
		<table border="1">
			<tr>
				<th style="width:150px">이벤트제목</th>
				<td><input type="text" name="title" value="${eventVO.title}" size="80"></td>
			</tr>
			<tr>
				<th style="width:150px">이벤트 기간</th>
				<td><input type="text" name="evdate" value="${eventVO.evdate}" size="80">(형식 : yy/mm/dd로 입력하세요.)</td>
			</tr>
			<tr>
				<th style="width:150px">당첨자 발표일</th>
				<td><input type="text" name="evperson" value="${eventVO.evperson}" size="80">(형식 : yy/mm/dd로 입력하세요.)</td>
			</tr>
			<tr>
				<th>배너사진</th>
				<td><input type="file" name="eimage"></td>
			</tr>
			<tr>
				<th>메인사진</th>
				<td><input type="file" name="eimage2"></td>
			</tr>
		</table><br>
		<input type="submit" value="수정">
		<input type="reset" value="다시작성">
		<input type="button" value="목록" onClick="location.href='ticket.do?command=adminEvent'">
	</form>
</div>


<%@ include file="../admin_footer.jsp" %>