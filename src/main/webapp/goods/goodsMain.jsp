<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div>
	<!-- 메인이미지 -->
	<img src="goods/goods_images/sub_images/main_image.png">
</div>
<%@ include file="sub_image_menu.jsp" %>

<!-- 신상품 -->
<h2>MD's Pick</h2>
<div>
  <c:forEach items="${newList}" var="gvo">
    <div>
      <a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}">
        <img src="goods/goods_images/${gvo.image}">
        <h4>${gvo.name}</h4>
        <h3><fmt:formatNumber value="${gvo.price2}" type="currency"/></h3>
      </a>
    </div>
  </c:forEach>
</div>

<div class="clear"></div>

<!-- 베스트 상품 -->
<h2>Best Item</h2>
<div>
  <c:forEach items="${bestList}" var="gvo">
    <div>
      <a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}">
        <img src="goods/goods_images/${gvo.image}">
        <h4>${gvo.name}</h4>
        <h3><fmt:formatNumber value="${gvo.price2}" type="currency"/></h3>
      </a>
    </div>
  </c:forEach>
</div>
<%@ include file="../footer.jsp" %>