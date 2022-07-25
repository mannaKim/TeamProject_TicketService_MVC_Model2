<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<article id="admin_goods">
  	<h2 align="center">굿즈 리스트</h2>
  	<br>
    <form name="frm" method="post">
    	<table id="search_table">
	    	<tr>
	    		<td><a href="#" onClick="go_totalGoodsList();">전체보기</a></td>
	    		<td><a href="#" onClick="go_goodsCategory('1');">문구</a></td>
	    		<td><a href="#" onClick="go_goodsCategory('2');">디지털</a></td>
	    		<td><a href="#" onClick="go_goodsCategory('3');">가방 · 파우치</a></td>
	    		<td><a href="#" onClick="go_goodsCategory('4');">취미용품</a></td>
	    		<td><a href="#" onClick="go_goodsCategory('5');">패션 · 잡화</a></td>
	    	</tr>
      		<tr>
        		<td colspan="5">
          			<input type="text" name="key" value="${key}" size="25">
          			<input type="button" class="adminbtn" value="검색" onClick="go_searchGoodsList();">
        		</td>
        		<td>
        			<!-- <a href="#" onClick="go_goodsInsertForm();">상품등록</a> -->
        			<input type="button" class="adminbtn" value="상품등록" onClick="go_goodsInsertForm();">
        		</td>
      		</tr>
      	</table>
  	</form>
  	<c:choose>
  		<c:when test="${empty goodsList}">
  			<table id="goods_table">
  				<tr>
  					<td>'${key}'에 대한 검색 결과가 없습니다.</td>
  				</tr>
  			</table>
  		</c:when>
  		<c:otherwise>
  			<table id="goods_table">
		  		<tr>
		  			<th width="80">번호</th>
		  			<th width="100">분류</th>
		  			<th colspan="2">상품명</th>
		      		<th width="100">등록일</th>
		      		<th width="100">판매유무</th>
		      	</tr>
		    	<c:forEach items="${goodsList}" var="gvo">
		      		<tr>
		        		<td align="center">${gvo.gseq}</td>
		        		<td>${goodsKindList[gvo.kind]}</td>
		        		<td width="150">
		          			<a href="#" onClick="go_goodsDetail('${gvo.gseq}');">
		          				<img src="goods/goods_images/${gvo.image}" width="100px">
		          			</a>
		        		</td>
		        		<td>
		          			<a href="#" onClick="go_goodsDetail('${gvo.gseq}');">${gvo.name}</a>
		        		</td>
		        		<td><fmt:formatDate value="${gvo.indate}"/></td>
		        		<td>
		        			<c:choose>
		        				<c:when test='${gvo.useyn=="n"}'>판매중지</c:when>
					            <c:otherwise>판매중</c:otherwise>
					        </c:choose>
		        		</td>
		      		</tr>
		    	</c:forEach>
		  	</table>
  		</c:otherwise>
  	</c:choose>
  	<br><br>
  	<jsp:include page="/paging.jsp">
    	<jsp:param value="ticket.do?command=adminGoodsList" name="command"/>
  	</jsp:include>
</article>
<%@ include file="../admin_footer.jsp" %>