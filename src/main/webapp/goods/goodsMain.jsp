<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article class="underHeader">
	<!-- 굿즈 검색창 -->
	<br><br>
	<div class="goods_subMenu">
		<form class="goods_searchBox" method="post" name="frm"
			action="ticket.do?command=goodsSearch&page=1">
			<div class="goods_search">
				<input type="text" name="key" value="${key}" size="45">
			</div>
			<div class="goods_searchBtn">
				<input type="submit" value="">
			</div>
		</form>
	</div>
	<br><br>
	<!-- 슬라이드 배너 -->
	<div class="background_white">
		<div id="slide_banner">
			<div id="banner_imgs">
				<a href="ticket.do?command=goodsMain"><img class="b_img"
					src="goods/goods_images/sub_images/welcome_wide_1.png"></a><a
					href="ticket.do?command=goodsDetail&gseq=21"><img class="b_img"
					src="goods/goods_images/sub_images/welcome_wide_2.jpg"></a><a
					href="ticket.do?command=goodsSearch&page=1&key=피너츠"><img
					class="b_img"
					src="goods/goods_images/sub_images/welcome_wide_3.png"></a><a
					href="ticket.do?command=goodsDetail&gseq=22"><img class="b_img"
					src="goods/goods_images/sub_images/welcome_wide_4.jpg"></a>
			</div>
			<div id="goods_remot">
				<ul>
					<li onClick="moveNum(0)"></li>
					<li onClick="moveNum(1)"></li>
					<li onClick="moveNum(2)"></li>
					<li onClick="moveNum(3)"></li>
				</ul>
			</div>
			<div id="goods_lbutton" onClick="moveLeft();"></div>
			<div id="goods_rbutton" onClick="moveRight();"></div>
		</div>
	</div>
	<!-- 베스트 상품 -->
	<div class="background_white">
		<div class="goodsBox">
			<div class="goodsBox_main">
				<h2>Best-Seller</h2>
				<c:forEach items="${bestList}" var="gvo">
					<div class="goods">
						<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}"> <img
							src="goods/goods_images/${gvo.image}">
							<p>${gvo.name}</p>
						</a>
						<h3>
							<fmt:formatNumber value="${gvo.price2}" type="currency" />
						</h3>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<!-- 카테고리 메뉴 -->
	<div class="goods_categoryBox">
		<table>
			<tr>
				<td><img src="goods/goods_images/sub_images/gs_icon_01.png"
					width="140px"
					onClick="location.href='ticket.do?command=goodsCategory&kind=1'"></td>
				<td><img src="goods/goods_images/sub_images/gs_icon_02.png"
					width="140px"
					onClick="location.href='ticket.do?command=goodsCategory&kind=2'"></td>
				<td><img src="goods/goods_images/sub_images/gs_icon_03.png"
					width="140px"
					onClick="location.href='ticket.do?command=goodsCategory&kind=3'"></td>
				<td><img src="goods/goods_images/sub_images/gs_icon_04.png"
					width="140px"
					onClick="location.href='ticket.do?command=goodsCategory&kind=4'"></td>
				<td><img src="goods/goods_images/sub_images/gs_icon_05.png"
					width="140px"
					onClick="location.href='ticket.do?command=goodsCategory&kind=5'"></td>
			</tr>
			<tr>
				<td><a href="ticket.do?command=goodsCategory&kind=1">문구</a></td>
				<td><a href="ticket.do?command=goodsCategory&kind=2">디지털</a></td>
				<td><a href="ticket.do?command=goodsCategory&kind=3">가방 ·
						파우치</a></td>
				<td><a href="ticket.do?command=goodsCategory&kind=4">취미용품</a></td>
				<td><a href="ticket.do?command=goodsCategory&kind=5">패션 ·
						잡화</a></td>
			</tr>
		</table>
	</div>
	<!-- 신상품 -->
	<div class="background_white">
		<div class="goodsBox">
			<div class="goodsBox_main">
				<h2>MD's Pick</h2>
				<c:forEach items="${newList}" var="gvo">
					<div class="goods">
						<a href="ticket.do?command=goodsDetail&gseq=${gvo.gseq}"> <img
							src="goods/goods_images/${gvo.image}">
							<p>${gvo.name}</p>
						</a>
						<h3>
							<fmt:formatNumber value="${gvo.price2}" type="currency" />
						</h3>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</article>
<%@ include file="../footer.jsp"%>