<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<article class="article">

<form method="post" name="frm">
<div id="t_showBox">
	<img src="ticket_image/back1.png"style="width:100%;" >
</div>
<table id="t_showBox">
	<tr id="t_btnn1">
		<th colspan="3" id="title">${ticketVO.name}</th>
		<td rowspan="8" id="img"><img src="ticket_image/${ticketVO.image}" style="width:230px;"><br>
		<a href="ticket.do?command=ticketingForm&tpseq=${ticketVO.tpseq}"class="btnCancel1">예매하기</a>
		</td>
	</tr>
	<tr>
		<th id="t-boxline">기간</th>
		<td colspan="2"><fmt:formatDate value="${sdate}" pattern="YYYY/MM/dd"/> ~ 
		<fmt:formatDate value="${edate}" pattern="YYYY/MM/dd"/>
	</td>
	</tr>
	<tr>
		<th>시작시간</th>
		<td colspan="2">${ticketVO.daytime}</td>
	</tr>
	<tr>
		<th id="t-boxline">장소</th>
		<td colspan="2">${ticketVO.place}</td>
	</tr>
	<tr>
		<th>연령</th>
		<td colspan="2">${ticketVO.age}세 이상</td>
	</tr>
	<tr>
		<th id="t-boxline">관람시간</th>
		<td colspan="2">${ticketVO.showtime}</td>
	</tr>
	<tr>
		<th>금액</th>
		<td colspan="2">일 반 : ${ticketVO.price1} / 어린이 ${ticketVO.price2}</td>
	</tr>
	<tr>
		<th id="t-boxline">설명</th>
		<td colspan="2">${ticketVO.content}</td>
	</tr>
</table>
</form>

</article>
<%@ include file="../footer.jsp" %>