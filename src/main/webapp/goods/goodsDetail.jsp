<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article>
	<!-- 굿즈 검색창 -->
	<br>
	<br>
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
	<br>
	<br>
	<!-- 굿즈 디테일 -->
	<div class="goodsBox">
		<form method="post" name="goodsFrm">
			<input type="hidden" name="gseq" value="${GoodsVO.gseq}">
			<div class="goodsDetail_img1">
				<img src="goods/goods_images/${GoodsVO.image}">
			</div>
			<div class="goodsDetail">
				<h2>${GoodsVO.name}</h2>
				<hr>
				<table>
					<tr>
						<td width="100px">판매가 :</td>
						<td><h3>${GoodsVO.price2}원</h3></td>
					</tr>
					<tr>
						<td>수량 :</td>
						<td>
							<button type="button" class="goodsQuantity" onClick="count(-1);">-</button> <input
							type="text" name="quantity" size="2" value="1" readonly>
							<button type="button" class="goodsQuantity" onClick="count(1);">+</button>
						</td>
					</tr>
				</table>
				<div class="goodsButton">
					<input type="button" value="장바구니" class="goodsButton1"
						onClick="go_Gcart();"> <input type="button" value="즉시구매"
						class="goodsButton2" onClick="go_Gorder();">
				</div>
			</div>
		</form>
		<div class="clear"></div>
		<hr>
		<div class="clear"></div>
		<div class="goodsDetail_img2">
			<img src="goods/goods_images/${GoodsVO.detail_img}">
		</div>
	</div>
</article>
<%@ include file="../footer.jsp"%>