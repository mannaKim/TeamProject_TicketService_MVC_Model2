<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TicketingCartList</title>
<script src="ticketing/ticketing.js"></script>
<link href="css/ticketingbtn.css" rel="stylesheet">
<link href="css/ticket.css" rel="stylesheet">
</head>
<body>
<h1>TicketingCart</h1>
<form method="post" name="cartlist" action="ticket.do">
<input type="hidden" name="command" value="ticketing">
<table class="table" border="1">
	<tr>
		<td>1단계</td><td>2단계<br>진행중</td><td>3단계</td>
	</tr>
	<tr>
		<td colspan="3">
			<table border="1">
				<tr>
					<td>
						<table>
							<tr>
								<td width=>선택한 날짜</td>
								<td>
									${choisDay}
									<input type="hidden" name="choisDay" value="${choisDay}">
								</td>
							</tr>
							<tr>
								<td>일　반</td><td>${ticket_productVO.price1} 원</td>
							</tr>
							<tr>
								<td></td>
								<td>
									${quantity1} 매
									<input type="hidden" name="quantity1" value="${quantity1}">
								</td>
							</tr>
							<tr>
								<td>어린이</td><td>${ticket_productVO.price2} 원</td>
							</tr>
							<tr>
								<td></td>
								<td>
									${quantity2} 매
									<input type="hidden" name="quantity2" value="${quantity2}">
								</td>
							</tr>
						</table>
					</td>
					<td>
					<table border="1">
						<tr>
						<td>
							<img  src="ticket_images/${ticket_productVO.image}" width="100"/>
						</td><td width="200">${ticket_productVO.name}</td>
						</tr>
						<tr>
							<td colspan="2">선택된 내용</td>
						</tr>
						<tr>
							<td>날　짜</td><td>${choisDay}</td>
						</tr>
						<tr>
							<td>매　수</td><td>${selecttotal} 매</td>
						</tr>
						<tr>
							<td colspan="2">결제내역</td>
						</tr>
						<tr>
							<td>일　반</td><td>${totalPrice1} 원</td>
						</tr>
						<tr>
							<td>어린이</td><td>${totalPrice2} 원</td>
						</tr>
						<tr>
							<td>최종 결제금액</td><td>${totalPrice3} 원</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="결제하기" onclick="go_ticketing()">
								<input type="hidden" name="tpseq" value="${ticket_productVO.tpseq}">
								<input type="button" value="뒤로" onClick="history.go(-1);">
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>