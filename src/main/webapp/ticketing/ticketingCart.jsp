<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="ticketing.js"></script>
<link href="css/ticketingbtn.css" rel="stylesheet">
<link href="css/ticket.css" rel="stylesheet">
</head>
<body>
<h1>TicketingCart</h1>
<form method="post" name="cartlist" action="ticket.do">
<input type="hidden" name="command" value="ticketingCartList">
<table class="table" border="1">
	<tr>
		<th>1단계<br>진행중</th><th>2단계</th><th>3단계</th>
	</tr>
	<tr>
		<td colspan="3">
			<table border="1">
				<tr>
					<td>
						<table>
							<tr>
								<td width="360" align="right" >선택한 날짜</td>
								<td width="200" align="right" >${choisDay}
									<input type="hidden" name="choisDay" value="${choisDay}">
								</td>
							</tr>
							<tr>
								<td align="right" >일　반</td><td align="right" >${ticket_productVO.price1} 원</td>
							</tr>
							<tr>
								<td></td>
								<td align="right" >
									<select id="select" name="quantity1">
									     <option>0</option>
									     <option>1</option>
									     <option>2</option>
									     <option>3</option>
									     <option>4</option>
									     <option>5</option>
									     <option>6</option>
									     <option>7</option>
									     <option>8</option>
									     <option>9</option>
									     <option>10</option>
									</select>
								 매</td>
							</tr>
							<tr>
								<td align="right" >어린이</td><td align="right" >${ticket_productVO.price2} 원</td>
							</tr>
							<tr>
								<td></td>
								<td align="right" ><select id="select" name="quantity2">
									     <option>0</option>
									     <option>1</option>
									     <option>2</option>
									     <option>3</option>
									     <option>4</option>
									     <option>5</option>
									     <option>6</option>
									     <option>7</option>
									     <option>8</option>
									     <option>9</option>
									     <option>10</option>
									</select>
								 매</td>
							</tr>
							<tr>
								<td>${message}</td>
							</tr>
							<tr>
								<td colspan="2">
								</td>
							</tr>
							<tr>
								<td colspan="2">유의사항</td>
							</tr>
							<tr>
								<td colspan="2">
- 안내되어 있는 잔여석은 결제 진행 중인 좌석을 포함하고 있어 예매 가능 좌석과 다를 수 있습니다.
- 할인은 자동선택 되지 않으니, 적용 받고자 하는 할인이 있는 경우 직접 선택해주시기 바랍니다.
- 장애인, 국가유공자, 학생 할인 등 증빙서류가 필요한 경우 현장수령만 가능하며, 현장에서 증빙서류 미지참 시 차액 지불하셔야 합니다.
- 관람 당일 공연 예매 시에는 변경/취소/환불이 불가합니다.
- 경우에 따라 ATM 기기에서 가상계좌 입금이 안 될 수 있으니 가급적 인터넷/폰뱅킹 등을 이용해주시기 바랍니다.
- 예매 취소 시 예매수수료는 예매 당일 밤 12시 이전까지 환불되며, 그 이후 기간에는 환불되지 않습니다.
- 예매 취소 시점에 따라 취소수수료가 부과될 수 있습니다. 예매 후 취소마감시간과 함께 취소수수료를 꼭 확인해주시기 바랍니다.
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
							<td>날　짜</td><td align="right" >${choisDay}</td>
						</tr>
						<tr>
						<tr>
							<td>일　반</td><td align="right" >0 매</td>
						</tr>
						<tr>
							<td>어린이</td><td align="right" >0 매</td>
						</tr>
						<tr>
							<td colspan="2">결제내역</td>
						</tr>
						<tr>
							<td>일　반</td><td align="right" >0 원</td>
						</tr>
						<tr>
							<td >어린이</td><td align="right" >0 원</td>
						</tr>
						<tr>
							<td>할인금액</td><td align="right" >0 원</td>
						</tr>
						<tr>
							<td>최종 결제금액</td><td align="right" >0 원</td>
						</tr>
						<tr>
							<td colspan="2">
							<input type="submit" value="다음단계" id="btn_ticket" onclick="return go_CartList()">
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