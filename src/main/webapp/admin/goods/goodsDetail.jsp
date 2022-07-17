<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<article>
  	<h1>굿즈 상세</h1>
    <table>
		<tr>
			<th>상품분류</th>
			<td colspan="5">
				${goodsKind}
			</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td colspan="5">
				${gvo.name}
			</td>
		</tr>
		<tr>
			<th>원가[A]</th>
			<td>${gvo.price1}</td>
			<th>판매가[B]</th>
			<td>${gvo.price2}</td>
			<th>[B-A]</th>
			<td>${gvo.price3}</td>
		</tr>
		<tr>
			<th>제품 설명</th>
			<td colspan="5">
          		<p>${gvo.content}</p>
        	</td>
		</tr> 
		<tr>
			<th>상품 대표이미지</th>
			<td colspan="2">
				<img src="goods/goods_images/${gvo.image}" width="200">
			</td>
			<th>상품 상세이미지</th>
			<td colspan="2">
				<img src="goods/goods_images/${gvo.detail_img}" width="50">
			</td>
		</tr>	
    </table>
    <input type="button" value="상품수정" onClick="go_goodsModifyForm('${gvo.gseq}');">
    <input type="button" value="목록으로" onClick="location.href='ticket.do?command=adminGoodsList&page=1'">
</article>
<%@ include file="/footer.jsp" %>