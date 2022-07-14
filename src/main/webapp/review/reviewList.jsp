<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<script src="member/member.js"></script>
<article>
<h2> REVIEW </h2>
<form method="post">
<table id="">
	<tr>	<th>번호</th><th>제목</th><th>등록일</th><th>댓글</th></tr>
	<c:forEach items="${reviewList}"  var="qnaVO">
		<tr ><td> ${reviewVO.rseq}</td>    
    		<td><a href="shop.do?command=reviewView&rseq=${reviewVO.rseq}">${reviewVO.kind} &nbsp; ${reviewVO.subject}</a></td>      
       		<td><fmt:formatDate value="${reviewVO.indate}" type="date"/></td>
       		<td><c:choose>
				<c:when test="${reviewVO.rep==1}"> no </c:when>
				<c:when test="${reviewVO.rep==2}"> yes </c:when>
			</c:choose></td>    
   		</tr>
  	</c:forEach>
</table>
<div class="clear"></div>

<div id="paging" >
	<c:url var="action" value="shop.do?command=qnaList" />
	<c:if test="${paging.prev}">
		<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
	</c:if>
	<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
		<c:choose>
			<c:when test="${paging.page==index}">
				<span style="color:red">${index}&nbsp;</span>
			</c:when>
			<c:otherwise>
				<a href="${action}&page=${index}">${index}</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.next}">
		<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
	</c:if>
</div>
<div  class="clear"></div><br>

<div id="buttons">
	<input type="button"  value="리뷰쓰기"  class="submit" onClick="go_reform();"> 
</div>
<div  class="clear"></div><br>
</form>


</article>

