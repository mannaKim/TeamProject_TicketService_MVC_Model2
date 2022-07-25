<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article class="underHeader">
	<%@ include file="sub_image_menu.jsp"%>
	<div class="goodsBox">
		<h1>${goodsKind}</h1>
		<hr>
		<c:forEach items="${goodsCategoryList}" var="gvo">
			<div class="goodsCategory">
				<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}">
					<img src="goods/goods_images/${gvo.image}">
				</a>
				<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}">
					<h2>${gvo.name}</h2>
				</a>
				<h3>
					<fmt:formatNumber value="${gvo.price2}" type="currency" />
				</h3>
				<span>${gvo.content}</span>
			</div>
		</c:forEach>
		<jsp:include page="../paging.jsp">
			<jsp:param value="ticket.do?command=goodsCategory" name="command" />
		</jsp:include>
		<br>
	</div>
</article>
<%@ include file="../footer.jsp"%>