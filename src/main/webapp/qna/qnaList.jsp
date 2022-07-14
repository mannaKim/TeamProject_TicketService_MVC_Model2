<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
<h2> 1:1 문의 </h2>
<form name="formm" method="post">
<table id="">
	<tr>	<th>번호</th><th>제목</th><th>등록일</th></tr>
	<c:forEach items="${qnalist}"  var="qnaVO">
		<tr ><td> ${qnaVO.qseq}</td>    
    		<td><a href="ticket.do?command=qnaView&qseq=${qnaVO.qseq}">
    		<!-- 제목의 링크를 누르면 게시글 번호와 함께 QnaJustViewAction 으로 이동합니다  -->
    		<c:choose>
			<c:when test="${qnaVO.kind==1}">
				[전시]
			</c:when>
			<c:when test="${qnaVO.kind==2}">
				[회원안내]
			</c:when>
			<c:when test="${qnaVO.kind==3}">
				[관람/예약]
			</c:when>
			<c:when test="${qnaVO.kind==4}">
				[굿즈]
			</c:when>
			<c:otherwise>
				[기타]
			</c:otherwise>
		</c:choose>
    		&nbsp; ${qnaVO.subject}</a>	
    		<c:if test="${qnaVO.replycnt>0}">
						<span style="color:red;font-weight:bold;">[${qnaVO.replycnt}]</span>
					</c:if>
					</td>           
       		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
       		<!-- <td><c:choose>
				<c:when test="${qnaVO.rep=='1' }"> N </c:when>
				<c:when test="${qnaVO.rep=='2' } "> Y </c:when>
			</c:choose></td>   답변여부는 해결을 하지 못해 나중에 해보는 것으로... -->
   		</tr>
  	</c:forEach>
</table>
<div class="clear"></div>

<div id="paging" >
	<c:url var="action" value="ticket.do?command=qna" />
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
	<input type="button"  value="1:1 문의하기"  class="submit" onClick="location.href='ticket.do?command=qnaWriteForm'"> 
	<!-- 문의하기 버튼을 누르면 QnaWirteFormAction 으로 이동합니다.  -->
</div>
<div  class="clear"></div><br>
</form>


</article>

