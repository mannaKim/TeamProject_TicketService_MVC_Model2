<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_image_menu.jsp"%>
<article>
	<div class="goodsBox">
		<h1>${title}</h1>
		<c:choose>
			<c:when test="${empty allGoodsOrderList}">
				<div class="emptyGoodsCart">
					<img src="./goods/goods_images/sub_images/emptyOrder.png">
					<h3>주문 내역이 없습니다.</h3>
				</div>
				<div class="goodsCartButton">
					<input type="button" value="쇼핑하러 가기" class="goodsButton1"
						onClick="location.href='ticket.do?command=goodsMain'">
				</div>
			</c:when>

			<c:otherwise>
				<div class="goodsCart">
					<table>
						<tr>
							<th>주문일자</th>
							<th>주문번호</th>
							<th colspan="2">상품명</th>
							<th>결제금액</th>
							<th>주문상세</th>
							<th>처리상태</th>
						</tr>
						<c:forEach items="${allGoodsOrderList}" var="govo">
							<tr>
								<td><fmt:formatDate value="${govo.indate}" type="date" /></td>
								<td>${govo.oseq}</td>
								<td><img src="goods/goods_images/${govo.image}"></td>
								<td>${govo.gname}</td>
								<td><fmt:formatNumber value="${govo.price}" type="currency" />
								</td>
								<td><a
									href="ticket.do?command=goodsOrderDetail&oseq=${govo.oseq}">조회</a>
								</td>
								<td><c:if test="${govo.result=='1'}">미처리</c:if> <c:if
										test="${govo.result=='0'}">완료</c:if></td>
							</tr>
						</c:forEach>
					</table>
					<br>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</article>
<%@ include file="../footer.jsp"%>