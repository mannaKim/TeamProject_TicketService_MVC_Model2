<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 슬라이드 배너 -->
<div id="slide_banner">
	<div id="banner_imgs">
		<a href="ticket.do?command=goodsMain"><img class="b_img"
			src="goods/goods_images/sub_images/welcome_wide_1.png"></a><a
			href="ticket.do?command=goodsDetail&gseq=21"><img class="b_img"
			src="goods/goods_images/sub_images/welcome_wide_2.jpg"></a><a
			href="ticket.do?command=goodsSearch&page=1&key=피너츠"><img
			class="b_img" src="goods/goods_images/sub_images/welcome_wide_3.png"></a><a
			href="ticket.do?command=goodsDetail&gseq=22"><img class="b_img"
			src="goods/goods_images/sub_images/welcome_wide_4.jpg"></a>
	</div>
	<div id="remot">
		<ul>
			<li onClick="moveNum(0)"></li>
			<li onClick="moveNum(1)"></li>
			<li onClick="moveNum(2)"></li>
			<li onClick="moveNum(3)"></li>
		</ul>
	</div>
	<div id="lbutton" onClick="moveLeft();"
		style="background-image: url(goods/goods_images/sub_images/left.png);"></div>
	<div id="rbutton" onClick="moveRight();"
		style="background-image: url(goods/goods_images/sub_images/right.png);"></div>
</div>
<%@ include file="sub_image_menu.jsp"%>
<!-- 신상품 -->
<h2>MD's Pick</h2>
<div>
	<c:forEach items="${newList}" var="gvo">
		<div>
			<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}"> <img
				src="goods/goods_images/${gvo.image}">
				<h4>${gvo.name}</h4>
				<h3>
					<fmt:formatNumber value="${gvo.price2}" type="currency" />
				</h3>
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
			<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}"> <img
				src="goods/goods_images/${gvo.image}">
				<h4>${gvo.name}</h4>
				<h3>
					<fmt:formatNumber value="${gvo.price2}" type="currency" />
				</h3>
			</a>
		</div>
	</c:forEach>
</div>
<%@ include file="../footer.jsp"%>