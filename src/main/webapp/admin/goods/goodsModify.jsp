<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<article>
  	<h1>굿즈 등록</h1>
    <form name="frm" method="post" enctype="multipart/form-data">
    	<input type="hidden" name="gseq" value="${gvo.gseq}">
    	<input type="hidden" name="oldImage" value="${gvo.image}">
    	<input type="hidden" name="oldDetail_img" value="${gvo.detail_img}">
    	<table>
			<tr>
				<th>상품분류</th>
				<td colspan="5">
					<select name="kind">
						<c:forEach items="${goodsKindList}" var="goodsKind" varStatus="status">
							<c:choose>
								<c:when test="${gvo.kind==status.count}">
									<option value="${status.count}" selected>
										${goodsKind}
									</option>
								</c:when>
								<c:otherwise>
									<option value="${status.count}">
										${goodsKind}
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td colspan="5">
					<input type="text" name="name" maxlength="100" value="${gvo.name}">
				</td>
			</tr>
			<tr>
				<th>원가[A]</th>
				<td><input type="text" name="price1" onkeyup="calculatePrice();" value="${gvo.price1}"></td>
				<th>판매가[B]</th>
				<td><input type="text" name="price2" onkeyup="calculatePrice();" value="${gvo.price2}"></td>
				<th>[B-A]</th>
				<td><input type="text" name="price3" value="${gvo.price3}"></td>
			</tr>
			<tr>
				<th>베스트상품 표기</th>
				<td>
					<c:choose>
            			<c:when test='${gvo.bestyn=="y"}'>
              				<input type="radio" name="bestyn" value="y" checked="checked">O
              				<input type="radio" name="bestyn" value="n">X
            			</c:when>
            			<c:otherwise>
             				<input type="radio" name="bestyn" value="y">O
              				<input type="radio" name="bestyn" value="n" checked="checked">X
            			</c:otherwise>
          			</c:choose>
				</td>
				<th>판매유무</th>
        		<td>
          			<c:choose>
            			<c:when test='${gvo.useyn=="y"}'>
              				<input type="radio" name="useyn" value="y" checked="checked">O
              				<input type="radio" name="useyn" value="n">X
            			</c:when>
            			<c:otherwise>
              				<input type="radio" name="useyn" value="y">O
              				<input type="radio" name="useyn" value="n" checked="checked">X
            			</c:otherwise>
          			</c:choose>
        		</td>
			</tr>
			<tr>
				<th>제품 설명</th>
				<td colspan="5">
          			<textarea name="content" rows="8" cols="70">
          				${gvo.content}
          			</textarea>
        		</td>
			</tr> 
			<tr>
				<th>상품 대표이미지</th>
				<td colspan="5">
					<img src="goods/goods_images/${gvo.image}" width="200">
					<br>
					<input type="file" name="image">
				</td>
			</tr>
			<tr>
				<th>상품 상세이미지</th>
				<td colspan="5">
					<img src="goods/goods_images/${gvo.detail_img}" width="200">
					<br>
					<input type="file" name="detail_img">
				</td>
			</tr>	
    	</table>
    	<input type="button" value="상품수정" onClick="go_goodsModify();">
    	<input type="button" value="수정취소" onClick="go_goodsDetail('${gvo.gseq}');">
  	</form>
</article>
<%@ include file="/footer.jsp" %>