<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<article id="admin_event">
<h2 align="center">이벤트목록</h2>
	<div id="adminEvent_btn">
		<input type="button" class="adevent_btn" value="이벤트등록" onClick="go_evwrt();" style="width:150px; height:35px;">
	</div>
	<table>
		<tr>
			<th width="20" height="40">No.</th>
    		<th width="200" height="40">서브이미지</th>
    		<th width="70" height="40">관리자</th>
    		<th width="170" height="40">제목</th>
    		<th width="230" height="40">이벤트기간</th>
    		<th width="100" height="40">당첨자발표일</th>
    		<th width="200" height="40">업로드날짜</th>
		</tr>
		<c:forEach items="${eventList}" var="eventVO">
    				<tr>
    					<td height="90">${eventVO.evnum}</td>
    					<td height="90">
    						<img src="ticket_image/${eventVO.eimage}" style="width:200px; height:70px;" />
    					</td>
    					<td height="90">${eventVO.id}</td>
    					<td height="90">
    						<a href="#" onClick="go_event('${eventVO.evnum}');">${eventVO.title}</a>
    					</td>
    					<td height="90">${eventVO.evdate}</td>
    					<td height="90">${eventVO.evperson}</td>
    					<td height="90"><fmt:formatDate value="${eventVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    				</tr>
    			</c:forEach>
	</table>
	<br>
	<!-- 여기서 value값으로 보내는 command를 paging.jsp로 보내서 action태그에 value로 전달함. -->
	<jsp:include page="/paging.jsp">
		<jsp:param name="command" value="ticket.do?command=adminEvent" />
	</jsp:include>
	
</article>
<%@ include file="../admin_footer.jsp" %>