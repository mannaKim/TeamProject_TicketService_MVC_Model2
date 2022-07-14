<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<article>
	<h2>주문 상세</h2>
	<form>
		<table border>
			<tr>
				<th colspan="2">상품명</th>
				<th>수량</th>
				<th>가격</th>
				<th>처리상태</th>
			</tr>
			<c:forEach items="${goodsOrderList}" var="govo">
	   			<tr>
	   				<td>
	   					<a href="ticket.do?command=goodsDetail&gseq=${govo.gseq}">
	   						<img src="${govo.image}">
	   					</a>
	   				</td>
	   				<td>
	   					<a href="ticket.do?command=goodsDetail&gseq=${govo.gseq}">
	   						${govo.gname}
	   					</a>
	   				</td>
	   				<td>
	   					<fmt:formatNumber value="${govo.price*govo.quantity}" type="currency"/>
	   				</td>
	   				<td>
	   					${govo.quantity}
	   				</td> 
	   				<td>
	   					<c:if test="${govo.result=='1'}">배송 준비중</c:if>
            			<c:if test="${govo.result=='0'}">배송 완료</c:if>
	   				</td>
	   			</tr>  
	  		</c:forEach>
		</table>
		<hr>
		<h2>배송지 정보</h2>
		<table border>
			<tr>
				<th>수령인</th>
				<th>휴대폰</th>
				<th>주소지</th>
			</tr>
			<tr>
				<td>${goodsOrderList[0].mname}</td>
				<td>${goodsOrderList[0].phone}</td>
				<td>
					[${goodsOrderList[0].zip_num}]&nbsp;
					${goodsOrderList[0].address1}&nbsp;
					${goodsOrderList[0].address2}
				</td>
			</tr>
		</table>
		<hr>
		<h2>결제 정보</h2>
		<table border>
			<tr>
				<th>결제 금액</th>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${totalPrice}" type="currency"/></td>
			</tr>
		</table>
	</form>
</article>
<%@ include file="../footer.jsp" %>