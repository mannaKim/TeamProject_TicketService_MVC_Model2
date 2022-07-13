<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h2>장바구니</h2>
<div>
	<table>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</table>
  <c:forEach items="${goodsCartList}" var="gcvo">
    <div>
      <a href="ticket.do?command=goodsDetail&gseq=${gcvo.gseq}">
        <img src="${gcvo.image}">
        <h4>${gcvo.gname}</h4>
        <h3><fmt:formatNumber value="${gcvo.price}" type="currency"/></h3>
      </a>
      <h3>${gcvo.quantity}</h3>
    </div>
  </c:forEach>
  <hr>
  <h3>${totalPrice}</h3>
</div>

<div class="clear"></div>


<%@ include file="../footer.jsp" %>