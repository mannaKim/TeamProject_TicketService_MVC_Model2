<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<h2>Item</h2>
<div>
  <c:forEach items="${goodsCategoryList}" var="gvo">
    <div>
      <a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}">
        <img src="goods/goods_images/${gvo.image}">
        <h4>${gvo.name}</h4>
        <h3><fmt:formatNumber value="${gvo.price2}" type="currency"/></h3>
        <p>${gvo.content}</p>
      </a>
    </div>
  </c:forEach>
</div>
<%@ include file="../footer.jsp" %>