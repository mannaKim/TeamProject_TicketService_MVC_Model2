<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_image_menu.jsp"%>
<article>
	<div class="goodsBox">
		<div class="goodsCart">
			<br><br>
			<h1>상세 정보</h1>	
			<input type="button" value="목록으로" class="goodsButton3"
				onClick="location.href='ticket.do?command=ticketCartList'">
			<table>
				<tr>
					<th></th>
					<th colspan="4">${ticketVO.name}</th>
				</tr>
				<tr>
					<th>기간</th>
					<td><fmt:formatDate value="${sdate}" pattern="YYYY/MM/dd" /> ~
						<fmt:formatDate value="${edate}" pattern="YYYY/MM/dd" /></td>
					<td rowspan="7" width="300"><img src="ticket_image/${ticketVO.image}"
						style="height: 400px; width: 300px;"></td>
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
					<td>${ticketVO.age}세이상</td>
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
		</div>
	</div>
	<br><br>
</article>
<%@ include file="../footer.jsp"%>