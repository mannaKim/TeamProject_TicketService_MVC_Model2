<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<div id="wrap" align="center">
<h1>공지사항</h1>
<form name="frm" method="post">
	<table border="1">
		<tr>
			<td>검색
			<input type="text" name="key" value="${key}">
			<input type="button" class="btn" value="검색" onClick="go_search('adminNotice');">
			<input type="button" class="btn" value="전체보기" onClick="go_total('adminNotice');">
			<input type="button" class="btn" value="공지사항등록" onClick="go_nowrt();">
			</td>
		</tr>
	</table>
</form>

	<table border="1">
		<tr>
			<th width="100">번호</th>
    		<th width="300">제목</th>
    		<th width="100">작성자</th>
    		<th width="200">날짜</th>
		</tr>
		<c:forEach items="${noticeList}" var="noticeVO">
    				<tr>
    					<td width="100">${noticeVO.ntnum}</td>
    					<td width="300">
    					<a href="#" onClick="go_notice('${noticeVO.ntnum}');">${noticeVO.title}</a>
    						<c:if test="${noticeVO.readcount>=15}">✨</c:if>
    					</td>
    					<td width="100">${noticeVO.id}</td>
    					<td width="200"><fmt:formatDate value="${noticeVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    				</tr>
    			</c:forEach>
	</table>
	<br><br>
	
	<!-- 여기서 value값으로 보내는 command를 paging.jsp로 보내서 action태그에 value로 전달함. -->
	<jsp:include page="/admin/paging/paging.jsp">
		<jsp:param name="command" value="ticket.do?command=adminNotice" />
	</jsp:include>
</div>
<%@ include file="../../footer.jsp" %>