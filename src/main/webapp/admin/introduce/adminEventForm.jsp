<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>
<div id="wrap" align="center">
<h1>이벤트목록</h1>
	<table border="1">
		<tr>
			<th width="50">번호</th>
    		<th width="200">서브이미지</th>
    		<th width="50">작성자</th>
    		<th width="100">제목</th>
    		<th width="200">이벤트기간</th>
    		<th width="200">당첨자발표일</th>
    		<th width="200">업로드날짜</th>
		</tr>
		<c:forEach items="${eventList}" var="eventVO">
    				<tr>
    					<td width="100">${eventVO.evnum}</td>
    					<td>
    						<img src="ticket_image/${eventVO.eimage}" style="width:200px;" />
    					</td>
    					<td width="100">${eventVO.id}</td>
    					<td width="200">
    						<a href="#" onClick="go_event('${eventVO.evnum}');">${eventVO.title}</a>
    					</td>
    					<td width="50">${eventVO.evdate}</td>
    					<td width="50">${eventVO.evperson}</td>
    					<td width="200"><fmt:formatDate value="${eventVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    				</tr>
    			</c:forEach>
	</table>
	<br><br>
	<form name="frm" method="post">
	<table border="1">
		<tr>
			<td><input type="button" class="btn" value="이벤트등록" onClick="go_evwrt();"></td>
		</tr>
	</table>
</form>
	
	<!-- 여기서 value값으로 보내는 command를 paging.jsp로 보내서 action태그에 value로 전달함. -->
	<jsp:include page="/admin/paging/paging.jsp">
		<jsp:param name="command" value="ticket.do?command=adminEvent" />
	</jsp:include>
</div>

<%@ include file="../../footer.jsp" %>