<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>

<article>
	<div>
		<h1>Item</h1>
    	<form method="post" name="goodsFrm">
      		<input type="hidden" name="gseq" value="${GoodsVO.gseq}">
        	<span style="float:left; margin-right:20px;">
          		<img src="${GoodsVO.image}" style="border-radius:20px">
        	</span>
        	<h2>${GoodsVO.name}</h2>
        	<label>가 격 : </label>${GoodsVO.price2}원<br>
        	<label>수 량 : </label>
			<button type="button" onClick="count(-1);">-</button>
			<input type="text" name="quantity" size="2" value="1" readonly>
			<button type="button" onClick="count(1);">+</button>
			<br><br>
			<div id="buttons">
        		<input type="button" value="장바구니" onClick="go_cart();">
       			<input type="button" value="즉시구매" onClick="go_order();">
        		<input type="button" value="뒤로" onClick="history.go(-1);">
      		</div>
    	</form>
    	<div class="clear"></div>
      	<hr>
      	<div class="clear"></div>
      	<img src="${GoodsVO.detail_img}"><br><br>
  	</div>
</article>
<%@ include file="../footer.jsp" %>