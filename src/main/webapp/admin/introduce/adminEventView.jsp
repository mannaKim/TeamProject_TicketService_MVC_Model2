<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<div id="wrap" align="center">
<form name="frm">
	<table border="1">
		<tr>
			<td style="text-align:center;" height="50">${event.title}
			<span style="float:right;"><fmt:formatDate value="${event.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></span></td>
		</tr>
		<tr>
			<td height="50">이벤트 기간 : ${event.evdate}</td>
		</tr>
		<tr>
			<td height="50">당첨자 발표일 : ${event.evperson}</td>
		</tr>
		<tr>
		<td colspan="5" align="center">
			<img src="ticket_image/${event.eimage2}">
		</td>
	</tr>
	</table>
	</form><br><br>
	<input type="button" value="수정" onClick="location.href='ticket.do?command=updateEvent&evnum=${event.evnum}'">
	<input type="button" value="삭제" onClick="location.href='ticket.do?command=deleteEvent&evnum=${event.evnum}'">
	<input type="button" value="목록으로" onClick="location.href='ticket.do?command=adminEvent'">
	<br><br>
</div>

<%@ include file="../../footer.jsp" %>