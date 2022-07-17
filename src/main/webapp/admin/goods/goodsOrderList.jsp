<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<article>
	<h1>굿즈 주문 리스트</h1>
	<table border>
		<tr>
			<th>주문일자</th>
			<th>주문번호</th>
			<th>주문회원</th>
			<th colspan="2">상품명</th>
		    <th>결제금액</th>
		    <th>처리상태</th>
		    <th>주문처리</th>
		</tr>
		<c:forEach items="${GoodsOrderList}" var="govo">
			<tr>
				<td>
			   		<fmt:formatDate value="${govo.indate}" type="date"/>
			   	</td>
			   	<td>
			   		${govo.oseq}
			   	</td>
			   	<td>
			   		${govo.id}
			   	</td>
			   	<td>
			   		<img src="goods/goods_images/${govo.image}" width="200">
			   	</td>
			   	<td>
			   		${govo.gname}
			   	</td>
			   	<td>
			   		<fmt:formatNumber value="${govo.price}" type="currency"/>
			   	</td>
			   	<td>
			   		<c:if test="${govo.result=='1'}">처리중</c:if>
		            <c:if test="${govo.result=='0'}">완료</c:if>
			   	</td>
			   	<td>
			   		<a href="ticket.do?command=adminGoodsOrderModify&oseq=${govo.oseq}">이동</a>
			   	</td> 
			</tr>  
		</c:forEach>
	</table>
	<br><br>
  	<jsp:include page="/paging.jsp">
    	<jsp:param value="ticket.do?command=adminGoodsOrderList" name="command"/>
  	</jsp:include>
</article>
<%@ include file="/footer.jsp" %>