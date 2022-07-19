<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>

<article>
<div id="wrap" align="center">
	<form method="post" name="frm">
		<table border="1">
	<tr>
		<td colspan="5">${ticketVO.name}</td>
	</tr>
	<tr>
		<th>기간</th>
		<td><fmt:formatDate value="${sdate}" pattern="YYYY/MM/dd"/> ~ <fmt:formatDate value="${edate}" pattern="YYYY/MM/dd"/></td>
		<td rowspan="7"><img src="ticket_image/${ticketVO.image}" style="height:400px; width:300px;"></td>
	</tr>
	<tr>
		<th>시작시간</th>
		<td>${ticketVO.daytime}</td>
	</tr>
	<tr>
		<th>장소</th>
		<td>${ticketVO.place}</td>
	</tr>
	<tr>
		<th>연령</th>
		<td>${ticketVO.age}세 이상</td>
	</tr>
	<tr>
		<th>관람시간</th>
		<td>${ticketVO.showtime}</td>
	</tr>
	<tr>
		<th>금액</th>
		<td>성인 ${ticketVO.price1}, 어린이 ${ticketVO.price2}</td>
	</tr>
	<tr>
		<th>설명</th>
		<td colspan="5">${ticketVO.content}</td>
	</tr>
</table>
	</form>
	<input type="button" value="취소" onClick="showDelete('${ticketVO.tpseq}');">
	<input type="button" value="목록으로" onClick="location.href='ticket.do?command=ticketCartList'">
</div>
</article>

<%@ include file="../footer.jsp" %>