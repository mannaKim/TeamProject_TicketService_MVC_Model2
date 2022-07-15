<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<article>
  	<h1>굿즈 리스트</h1>
    <form name="frm" method="post">
    	<table>
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
          			상품명<input type="text" name="key" value="${key}">
          			<input type="button" value="검색" onClick="go_searchGoodsList();">
        		</td>
        		<td>
        			<a href="#" onClick="go_goodsInsert();">상품등록</a>
        		</td>
      		</tr>
      	</table>
  	</form>
  	  	<c:choose>
  		<c:when test="${empty goodsList}">
  			<table>
  				<tr>
  					<td>'${key}'에 대한 검색 결과가 없습니다.</td>
  				</tr>
  			</table>
  		</c:when>
  		<c:otherwise>
  			<table>
		  		<tr>
		  			<th>번호</th>
		  			<th>분류</th>
		  			<th colspan="2">상품명</th>
		      		<th>등록일</th>
		      		<th>판매유무</th>
		      	</tr>
		    	<c:forEach items="${goodsList}" var="gvo">
		    		<c:if test="${gvo.kind==goodsKind}">
			      		<tr>
			        		<td height="23" align="center">${gvo.gseq}</td>
			        		<c:forEach items="${gvo.kind}" var="index">
			        			<td>${goodsKindList[index]}</td>
			        		</c:forEach>
			        		<td>
			          			<a href="#" onClick="go_detail('${gvo.gseq}');">
			          				<img src="${gvo.image}" width="100px">
			          			</a>
			        		</td>
			        		<td style="text-align:left; padding-left:50px;">
			          			<a href="#" onClick="go_detail('${gvo.gseq}');">${gvo.name}</a>
			        		</td>
			        		<td><fmt:formatDate value="${gvo.indate}"/></td>
			        		<td>
			        			<c:choose>
			        				<c:when test='${gvo.useyn=="n"}'>판매중지</c:when>
						            <c:otherwise>판매중</c:otherwise>
						        </c:choose>
			        		</td>
			      		</tr>
			      	</c:if>
		    	</c:forEach>
		  	</table>
  		</c:otherwise>
  	</c:choose>
  	<br><br>
  	<jsp:include page="/paging.jsp">
    	<jsp:param value="ticket.do?command=adminGoodsList" name="command"/>
  	</jsp:include>
</article>
<%@ include file="/footer.jsp" %>