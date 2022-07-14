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
								<td width="300">선택한 날짜</td>
								<td width="200">${choisDay}
									<input type="hidden" name="choisDay" value="${choisDay}">
								</td>
							</tr>
							<tr>
								<td>일　반</td><td>${ticket_productVO.price1} 원</td>
							</tr>
							<tr>
								<td></td>
								<td><select id="select" name="quantity1">
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
								<td>어린이</td><td>${ticket_productVO.price2} 원</td>
							</tr>
							<tr>
								<td></td>
								<td><select id="select" name="quantity2">
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
						</table>
					</td>
					<td>
					<table border="1">
						<tr>
						<td width="100" >
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
							<td>매　수</td><td>0 매</td>
						</tr>
						<tr>
							<td colspan="2">결제내역</td>
						</tr>
						<tr>
							<td>일　반</td><td>0 원</td>
						</tr>
						<tr>
							<td >어린이</td><td>0 원</td>
						</tr>
						<tr>
							<td>최종 결제금액</td><td>0 원</td>
						</tr>
						<tr>
							<td colspan="2">
							<input type="submit" value="다음단계" onclick="return go_CartList()">
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