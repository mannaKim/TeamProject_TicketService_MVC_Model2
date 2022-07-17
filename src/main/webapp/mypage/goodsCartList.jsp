<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<article>
	<h2>장바구니</h2>
	<form name="goodsCartFrm" method="post">
		<c:choose>
			<c:when test="${empty goodsCartList}">
				<h3>장바구니가 비었습니다.</h3>
				<input type="button" value="계속 쇼핑" onClick="location.href='ticket.do?command=goodsMain'">
			</c:when>
			<c:otherwise>
				<table border>
					<tr>
						<th colspan="2">상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>선택</th>
					</tr>
					<c:forEach items="${goodsCartList}" var="gcvo">
			   			<tr>
			   				<td>
			   					<a href="ticket.do?command=goodsDetail&gseq=${gcvo.gseq}">
			   						<img src="goods/goods_images/${gcvo.image}">
			   					</a>
			   				</td>
			   				<td>
			   					<a href="ticket.do?command=goodsDetail&gseq=${gcvo.gseq}">
			   						${gcvo.gname}
			   					</a>
			   				</td>
			   				<td><fmt:formatNumber value="${gcvo.price*gcvo.quantity}" type="currency"/></td>
			   				<td>
			   					<button type="button" onClick="changeQuantity(-1,${gcvo.gseq},${gcvo.quantity});">-</button>
								<input type="text" name="quantity" size="2" value="${gcvo.quantity}" readonly>
								<button type="button" onClick="changeQuantity(1,${gcvo.gseq},${gcvo.quantity});">+</button>
			   				</td> 
			   				<td>
			   					<input type="checkbox" name="gcseq" value="${gcvo.gcseq}" checked>
			   				</td>
			   			</tr>  
			  		</c:forEach>
			  		<tr>
			  			<th colspan="2">총 결제 예상 금액</th>
			  			<th colspan="2"><fmt:formatNumber value="${totalPrice}" type="currency"/></th>
			  			<th>
			  				<a href="#" onClick="go_Gcart_delete();">
			  					선택상품 삭제하기
			  				</a>
			  			</th>
			  		</tr>
				</table>
				<div>
		      		<input type="button" value="계속 쇼핑하기" onClick="location.href='ticket.do?command=goodsMain'">
		        	<input type="button" value="선택한 상품 주문하기" onClick="go_Gorder_insert();">  	
		    	</div>
			</c:otherwise>
		</c:choose>
	</form>
</article>
<%@ include file="../footer.jsp" %>