<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article>
	<%@ include file="sub_image_menu.jsp"%>
	<div class="goodsBox">
		<h1>'${key}'에 대한 검색 결과</h1>
		<c:choose>
			<c:when test="${empty searchList}">
				<div class="goodsEmpty">
					<h3>· '${key}'에 대한 검색 결과가 없습니다.</h3>
					<h3>· 입력한 검색어의 철자 또는 띄어쓰기가 정확한지 다시 한번 확인해 주세요.</h3>
					<h3>· 검색어의 단어 수를 줄이거나, 보다 일반적인 검색어를 사용하여 검색해 보세요.</h3>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="${searchList}" var="gvo">
					<div class="goodsCategory">
						<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}"> <img
							src="goods/goods_images/${gvo.image}">
						</a> <a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}">
							<h2>${gvo.name}</h2>
						</a>
						<h3>
							<fmt:formatNumber value="${gvo.price2}" type="currency" />
						</h3>
						<span>${gvo.content}</span>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<jsp:include page="../paging.jsp">
			<jsp:param value="ticket.do?command=goodsSearch" name="command" />
		</jsp:include>
		<br>
	</div>
</article>
<%@ include file="../footer.jsp"%>