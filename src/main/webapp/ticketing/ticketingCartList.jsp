<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TicketingCartList</title>
<script src="ticketing/ticketing.js"></script>
<link href="css/ticketingbtn.css" rel="stylesheet">
<link href="css/ticket.css" rel="stylesheet">
<script>
</script>
</head>
<body>
<h1>TicketingCart</h1>
<form method="post" name="cartlist" action="ticket.do">
<input type="hidden" name="command" value="ticketing">
<table class="table" border="1">
	<tr>
		<th>1단계</th><th>2단계<br>진행중</th><th>3단계</th>
	</tr>
	<tr>
		<td colspan="3">
			<table border="1">
				<tr>
					<td>
						<table>
							<tr>
								<td width="360" align="right" >선택한 날짜</td>
								<td width="200" align="right" >
									${choisDay}
									<input type="hidden" name="choisDay" value="${choisDay}">
								</td>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${ticket_productVO.price3 == 0}"> 
										<td colspan="2" align="right" >할인쿠폰이 없습니다. </td>
									</c:when>
									<c:when test="${ticket_productVO.price3 > 0}">
										<td align="right" >예매가 할인</td>
										<td align="right" >${ticket_productVO.price3} 원 </td>
									</c:when>
								</c:choose>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${ticket_productVO.price3 == 0}"> 
										<td colspan="2" ></td>
										<input type="hidden" name="selectevent" value="0">
									</c:when>
									<c:when test="${ticket_productVO.price3 > 0}">
										<td></td>
										<td align="right" >
		<select id="select" name="selectevent" onchange="quantity(${totalPrice3},${ticket_productVO.price3})">
			<option value="0">0</option>
			<option value="${ticket_productVO.price3 * selecttotal}">${selecttotal}</option>
		</select>
										 매</td>
									</c:when>
								</c:choose>
							</tr>
							<tr>
								<td colspan="2" style="color: red">
								※ 주의사항) 할인은 자동선택 되지 않으니, 적용 받고자 하는 할인이 있는 경우 직접 선택해주시기 바랍니다.
								</td>
							</tr>
						</table>
					</td>
					<td>
					<table border="1">
						<tr>
						<td width="90" >
							<img  src="ticket_image/${ticket_productVO.image}" width="90"/>
						</td>
						<td width="150">${ticket_productVO.name}</td>
						</tr>
						<tr>
							<td colspan="2">선택된 내용</td>
						</tr>
						<tr>
							<td>날　짜</td><td align="right">${choisDay}</td>
						</tr>
						<tr>
							<td>일　반</td>
							<td align="right">
								${quantity1} 매
								<input type="hidden" name="quantity1" value="${quantity1}">
							</td>
						</tr>
						<tr>
							<td>어린이</td>
							<td align="right">
								${quantity2} 매
								<input type="hidden" name="quantity2" value="${quantity2}">
							</td>
						</tr>
						<tr>
							<td colspan="2">결제내역</td>
						</tr>
						<tr>
							<td>일　반</td><td align="right">${totalPrice1} 원</td>
						</tr>
						<tr>
							<td>어린이</td><td align="right">${totalPrice2} 원</td>
						</tr>
						<tr>
							<td>할인금액</td>			
							<c:choose>				
							<c:when test="${totalPrice3 == totalPrice4}"> 
							<td align="right">	 
								${ticket_productVO.price3} 원
							</td>
							</c:when>
							<c:when test="${totalPrice3 > totalPrice4}">
							<td align="right">	 
							<div id="view" style="display:inline;">0</div> 원
							</td>
							</c:when>	
							</c:choose>
							</tr>
						<tr>
							<td>최종 결제금액</td>
						<c:choose>
						<c:when test="${totalPrice3 == totalPrice4}">
							<td align="right">${totalPrice3} 원</td>
						</c:when>
						<c:when test="${totalPrice3 > totalPrice4}">
							<td align="right">
								<div id="view2" style="display: inline;">${totalPrice3}</div> 원
							</td>
						</c:when>
						</c:choose>
							</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" value="이전단계" id="btn_ticket1" onClick="history.go(-1);">
								<input type="submit" value="결제하기" id="btn_ticket1" onclick="go_ticketing()">
								<input type="hidden" name="tpseq" value="${ticket_productVO.tpseq}">
													
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>