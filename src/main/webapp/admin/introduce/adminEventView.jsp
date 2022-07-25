<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<article id="adminEvent_View">
<form name="frm">
	<table>
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
			<img src="ticket_image/${event.eimage2}" style="width:950px; min-height:900px;">
		</td>
	</tr>
	</table>
	<br>
	<div id="adminEventView_btn">
		<input type="button" class="adminbtn" value="수정" onClick="location.href='ticket.do?command=updateEvent&evnum=${event.evnum}'" style="width:70px; height:30px;">
		<input type="button" class="adminbtn" value="삭제" onClick="location.href='ticket.do?command=deleteEvent&evnum=${event.evnum}'" style="width:70px; height:30px;">
		<input type="button" class="adminbtn" value="목록으로" onClick="location.href='ticket.do?command=adminEvent'" style="width:100px; height:30px;">
	</div>
	</form>
</article>

<%@ include file="../admin_footer.jsp" %>