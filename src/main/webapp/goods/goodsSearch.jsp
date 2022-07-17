<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<h2>Item</h2>
<div>
	<c:choose>
		<c:when test="${empty searchList}">
			<h3>'${key}'에 대한 검색 결과가 없습니다.</h3>
			<h4>입력한 검색어의 철자 또는 띄어쓰기가 정확한지 다시 한번 확인해 주세요.</h4>
			<h4>검색어의 단어 수를 줄이거나, 보다 일반적인 검색어를 사용하여 검색해 보세요.</h4>
		</c:when>
		<c:otherwise>
		  	<c:forEach items="${searchList}" var="gvo">
		    	<div>
		      		<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}">
		        		<img src="goods/goods_images/${gvo.image}">
		        		<h4>${gvo.name}</h4>
		        		<h3><fmt:formatNumber value="${gvo.price2}" type="currency"/></h3>
		        		<p>${gvo.content}</p>
		      		</a>
		    	</div>
		  	</c:forEach>
		</c:otherwise>
	</c:choose>
  	<jsp:include page="../paging.jsp">
  		<jsp:param value="ticket.do?command=goodsSearch" name="command"/>
  	</jsp:include>
</div>
<%@ include file="../footer.jsp" %>