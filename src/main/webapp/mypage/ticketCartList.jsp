<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>


<article>
<h2>ticketCartList</h2>
<form>
<c:choose>
	<c:when test="${ TicketCartList.size()==0 }">
		<table border="1">
			<tr>
				<th>예매일</th><th>주문자</th><th>공연명</th><th>관림일시</th><th>매수</th><th>예매상태</th>
			</tr>
			<tr>
				<td colspan="5">
					<h3 style="color:red; text-align:center;">최근 예매내역이 없습니다.</h3>	
				</td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<th>예매일</th><th>주문자</th><th>공연명</th><th>관림일시</th><th>매수</th><th>예매상태</th>
			</tr>
		<c:forEach items="${ TicketCartList }" var="TcartVO">
	   	<jsp:useBean id="now" class="java.util.Date" />
		<fmt:formatDate pattern="yyyy.MM.dd" value="${now}"  var="today" /><!-- 오늘날짜 -->
	   	<fmt:formatDate pattern="yyyy.MM.dd" value="${TcartVO.choisdate}" type="date" var="choisdate" />
   			<tr>
				<td>
					<fmt:formatDate pattern="yyyy.MM.dd" value="${TcartVO.indate}" type="date"/>
				</td>
   				<td>${ TcartVO.mname }</td>
   				<td><a href="ticket.do?command=ticketShowMypage&tpseq=${TcartVO.tpseq}">
   					${ TcartVO.pname }</a></td>
   				<td>
	   				${ choisdate }-${ TcartVO.daytime }
   				</td>
   				<td>
   					${ TcartVO.quantity1 + TcartVO.quantity2 } 매<br>
   					(일반:${ TcartVO.quantity1 } 어린이:${ TcartVO.quantity2 })
   				</td>
   				<td>
   				
   					<c:if test="${ choisdate > today }">
   						<a href="ticket.do?command=ticketShowMypage&tpseq=${TcartVO.tpseq}">예매중/취소</a>					
   					</c:if>
					<c:if test="${ choisdate <= today }">
						종료
					</c:if>

   				</td>
   				
   			</tr>
  		</c:forEach>
		</table>
		<br>
		<div id="paging" align="center" style="font-size:110%; font-weight:bold;">
			<c:url var="action" value="ticket.do?command=ticketCartList" />
			<c:if test="${paging.prev}">
				<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
			</c:if>
			<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
				<c:choose>
					<c:when test="${paging.page==index}">
						<span style="color:red">${index}&nbsp;</span>
					</c:when>
					<c:otherwise>
					<a href="${action}&page=${index}&key=${key}">${index}</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next}">
				<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
			</c:if>
		</div>
	</c:otherwise>	
</c:choose>


</form>
</article>
<%@ include file="../footer.jsp" %>