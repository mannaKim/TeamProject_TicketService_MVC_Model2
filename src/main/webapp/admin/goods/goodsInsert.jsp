<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<article>
  	<h1>굿즈 등록</h1>
    <form name="frm" method="post" enctype="multipart/form-data">
    	<table>
			<tr>
				<th>상품분류</th>
				<td colspan="5">
					<select name="kind">
						<option value="0">선택</option>
						<c:forEach items="${goodsKindList}" var="goodsKind" varStatus="status">
							<option value="${status.count}">
								${goodsKind}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td colspan="5">
					<input type="text" name="name" maxlength="100">
				</td>
			</tr>
			<tr>
				<th>원가[A]</th>
				<td><input type="text" name="price1" onkeyup="calculatePrice();"></td>
				<th>판매가[B]</th>
				<td><input type="text" name="price2" onkeyup="calculatePrice();"></td>
				<th>[B-A]</th>
				<td><input type="text" name="price3"></td>
			</tr>
			<tr>
				<th>제품 설명</th>
				<td colspan="5">
          			<textarea name="content" rows="8" cols="70"></textarea>
        		</td>
			</tr> 
			<tr>
				<th>상품 대표이미지</th>
				<td colspan="2">
					<input type="file" name="image">
				</td>
				<th>상품 상세이미지</th>
				<td colspan="2">
					<input type="file" name="detail_img">
				</td>
			</tr>	
    	</table>
    	<input type="button" value="상품등록" onClick="go_goodsInsert();">
    	<input type="button" value="목록으로" onClick="location.href='ticket.do?command=adminGoodsList&page=1'">
  	</form>
</article>
<%@ include file="/footer.jsp" %>