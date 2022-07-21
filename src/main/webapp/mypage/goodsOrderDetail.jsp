<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_image_menu.jsp"%>
<article>
	<div class="goodsBox">
		<div class="goodsCart">
		<br><br>
		<h1>주문 상세</h1>
		<input type="button" value="목록으로" class="goodsButton3"
				onClick="location.href='ticket.do?command=allGoodsOrderList'">
			<table>
				<tr>
					<th colspan="2">상품명</th>
					<th>수량</th>
					<th>가격</th>
					<th>처리상태</th>
				</tr>
				<c:forEach items="${goodsOrderList}" var="govo">
					<tr>
						<td width="300px"><a
							href="ticket.do?command=goodsDetail&gseq=${govo.gseq}"> <img
								src="goods/goods_images/${govo.image}">
						</a></td>
						<td><a href="ticket.do?command=goodsDetail&gseq=${govo.gseq}">
								${govo.gname} </a></td>
						<td>${govo.quantity}</td>
						<td><fmt:formatNumber value="${govo.price*govo.quantity}"
								type="currency" /></td>
						<td><c:if test="${govo.result=='1'}">배송 준비중</c:if> <c:if
								test="${govo.result=='0'}">배송 완료</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<h1>배송지 정보</h1>
		<div class="goodsCart">

			<table>
				<tr>
					<th>수령인</th>
					<th>휴대폰</th>
					<th>주소지</th>
				</tr>
				<tr>
					<td>${goodsOrderList[0].mname}</td>
					<td>${goodsOrderList[0].phone}</td>
					<td>[${goodsOrderList[0].zip_num}]&nbsp;
						${goodsOrderList[0].address1}&nbsp; ${goodsOrderList[0].address2}
					</td>
				</tr>
			</table>
		</div>
		<h1>결제 정보</h1>
		<div class="goodsCart">

			<table>
				<tr>
					<th>결제 금액</th>
				</tr>
				<tr>
					<td><fmt:formatNumber value="${totalPrice}" type="currency" /></td>
				</tr>
			</table>
		</div>
	</div>
	<br><br>
</article>
<%@ include file="../footer.jsp"%>