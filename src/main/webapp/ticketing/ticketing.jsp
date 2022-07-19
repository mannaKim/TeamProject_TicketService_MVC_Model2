<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ticketing.jsp</title>
<script src="ticketing/ticketing.js"></script>
<link href="css/ticketingbtn.css" rel="stylesheet">
<link href="css/ticket.css" rel="stylesheet">
</head>
<body>
<h1>Ticketing</h1>
<form method="post" name="cartlist" action="ticket.do">
<input type="hidden" name="command" value="ticketCartList">
<table class="table" border="1">
	<tr>
		<th>1단계</th><th>2단계</th><th>3단계<br>완료</th>
	</tr>
	<tr>
		<td colspan="3">
			<table border="1">
				<tr>
					<td>
						<table>
							<tr>
								<td width="360" align="right">선택한 날짜</td>
								<td width="200" align="right">${choisDay}</td>
							</tr>
							<tr>
								<td>일　반</td><td>${ticket_productVO.price1} 원</td>
							</tr>
							<tr>
								<td></td>
								<td>${select1} 매</td>
							</tr>
							<tr>
								<td>어린이</td><td>${ticket_productVO.price2} 원</td>
							</tr>
							<tr>
								<td></td>
								<td>${select2} 매</td>
							</tr>
							<tr>
								<td colspan="2" style="color: red">취소 가능 마감 시간 : ${choisDay} 까지</td>
							</tr>
							<tr>
								<td colspan="2">
									<table>
										<tr>
											<th width="180">내용</th><th width="180">취소수수료</th><th width="192">비고</th>
										</tr>
										<tr>
											<td>예매 후 7일 이내</td><td>없음</td>
											<td rowspan="5">
- 취소 시 예매수수료는 예매 당일 밤 12시 이전까지만 환불됩니다.
- 예매 후 7일 이내라도 취소시점이 관람일로부터 10일 이내라면 그에 해당하는 취소수수료가 부과됩니다.
- 관람 당일 취소 가능 상품의 경우 관람 당일 취소 시 티켓금액의 90%가 취소수수수료로 부과됩니다.
											</td>
										</tr>
										<tr>
											<td>예매 후 8일 ~ 관람일 10일 전까지</td>
											<td>뮤지컬, 콘서트, 클래식 등: 장당 4,000원 /
연극, 전시 등: 장당 2,000원
(단, 티켓 금액의 10% 이내)</td>
										</tr>
										<tr>
											<td>관람일 9일 전 ~ 관람일 7일 전까지</td><td>티켓금액의 10%</td>
										</tr>
										<tr>
											<td>관람일 6일 전 ~ 관람일 3일 전까지</td><td>티켓금액의 20%</td>
										</tr>
										<tr>
											<td>관람일 2일 전 ~ 관람일 1일 전까지</td><td>티켓금액의 30%</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td>
					<table border="1">
						<tr>
						<td width="90" >
							<img  src="ticket_image/${ticket_productVO.image}" width="90" />
						</td><td width="150">${ticket_productVO.name}</td>
						</tr>
						<tr>
							<td colspan="2">선택된 내용</td>
						</tr>
						<tr>
							<td>날　짜</td><td align="right">${choisDay}</td>
						</tr>
						<tr>
							<td>일　반</td>
							<td align="right">${quantity1} 매</td>
						</tr>
						<tr>
							<td>어린이</td>
							<td align="right">${quantity2} 매</td>
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
									<c:when test="${selectevent == 0}"> 
										<td align="right">	 
											${selectevent} 원
										</td>
										</c:when>
										<c:when test="${selectevent > 0}">
										<td align="right">	 
											- ${selectevent} 원
										</td>
									</c:when>
								</c:choose>
							</tr>
						<tr>
							<td>최종 결제금액</td><td align="right">${setotal} 원</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="완 료" id="btn_ticket" onclick="go_mypage()">
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