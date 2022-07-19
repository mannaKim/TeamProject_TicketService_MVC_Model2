<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
    <article>
    	<form id="noticeForm">
    	<h1>공지사항</h1>
    		<table border="1">
    			<tr>
    				<th width="200" height="50">번호</th>
    				<th width="400" height="50">제목</th>
    				<th width="100" height="50">작성자</th>
    				<th width="150" height="50">조회수</th>
    				<th width="300" height="50">날짜</th>
    			</tr>
    			<c:forEach items="${noList}" var="noticeVO">
    				<tr>
    					<td height="50">${noticeVO.ntnum}</td>
    					<td height="50">
    					<a href="ticket.do?command=noticeView&ntnum=${noticeVO.ntnum}">${noticeVO.title}</a>
    						<c:if test="${noticeVO.readcount>=15}">✨</c:if>
    					</td>
    					<td height="50">${noticeVO.id}</td>
    					<td height="50">${noticeVO.readcount}</td>
    					<td height="50"><fmt:formatDate value="${noticeVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    				</tr>
    			</c:forEach>
    		</table><br><br>
    		<!-- 여기서부터 페이지 입니다. -->
    <div id ="paging">
		<!-- 페이지가 클릭될때마다 이동할 링크 기본경로를 JSTL변수에 저장. -->
		<c:url var = "action" value="ticket.do?command=notice"></c:url>
		
		<!-- prev표시 : 전달된 paging의 prev변수가 true이면 표시, false면 표시하지 않음. -->
		<c:if test="${paging.prev}">
			<a href="${action}&page=${paging.beginPage-1}">prev</a>&nbsp;
			<!-- 링크되는 주소 -> board.do?command=main&page?? -->
			<!-- 맨 왼쪽 페이지(beginPage보다 1페이지 작은 페이지로 이동 -->
		</c:if>
		
		<!-- beginPage부터 endPage값 까지 페이지 표시 & 해당페이지에 링크-->
		<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
			<c:choose>
				<c:when test="${paging.page==index}">
					<span style="color:red">${index}&nbsp;</span>
				</c:when>
				<c:otherwise>
					<a href="${action}&page=${index}">${index}&nbsp;</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<!-- next표시 : 전달된 paging의 next변수가 true이면 표시, false면 표시하지 않음. -->
		<c:if test="${paging.next}">
			<a href="${action}&page=${paging.endPage+1}">next</a>&nbsp;
			<!-- 링크되는 주소 -> board.do?command=main&page?? -->
			<!-- 맨 오른쪽 페이지(endPage보다 1페이지 큰 페이지로 이동 -->
		</c:if>
	</div>
		<div id="buttons">
    		<input type="button" value="돌아가기" class="submit" onClick="location.href='ticket.do?command=index'">
    	</div>
    	</form>
    </article>
    
    <%@ include file="../footer.jsp" %>