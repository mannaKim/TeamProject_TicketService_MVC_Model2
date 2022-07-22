<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>

<article id="adminEvent_Update">
	<h2 align="center">이벤트 수정</h2>
	<form method="post" enctype="multipart/form-data" action="ticket.do?command=update">
		<input type="hidden" name="evnum" value="${eventVO.evnum}">
		<input type="hidden" name="oldPicture1" value="${eventVO.eimage}">
		<input type="hidden" name="oldPicture2" value="${eventVO.eimage2}">
		<table>
			<tr>
				<th style="width:150px; height:40px;">이벤트제목</th>
				<td><input type="text" name="title" value="${eventVO.title}" size="60" style="width:400px; height:25px; font-size:16px;"></td>
			</tr>
			<tr>
				<th style="width:150px; height:40px;">이벤트 기간</th>
				<td><input type="text" name="evdate" value="${eventVO.evdate}" size="60" style="width:400px; height:25px; font-size:16px;">(형식 : yy/mm/dd로 입력하세요.)</td>
			</tr>
			<tr>
				<th style="width:150px; height:40px;">당첨자 발표일</th>
				<td><input type="text" name="evperson" value="${eventVO.evperson}" size="60" style="width:400px; height:25px; font-size:16px;">(형식 : yy/mm/dd로 입력하세요.)</td>
			</tr>
			<tr>
				<th style="width:150px; height:40px;">배너사진</th>
				<td><input type="file" name="eimage"></td>
			</tr>
			<tr>
				<th style="width:150px; height:40px;">메인사진</th>
				<td><input type="file" name="eimage2"></td>
			</tr>
		</table><br>
		<div id="adminEventUp_btn">
			<input type="submit" value="수정" style="width:70px; height:30px;">
			<input type="reset" value="다시작성" style="width:100px; height:30px;">
			<input type="button" value="목록" onClick="location.href='ticket.do?command=adminEvent'" style="width:70px; height:30px;">
		</div>
	</form>
</article>


<%@ include file="../admin_footer.jsp" %>