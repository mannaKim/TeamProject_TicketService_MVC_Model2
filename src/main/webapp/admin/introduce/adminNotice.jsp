<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<article id="admin_notice">
<h2 align="center">공지사항 관리페이지</h2>
	<table id="notice_table">
		<tr>
			<th width="100" height="40">공지No.</th>
    		<th width="300" height="40">제목</th>
    		<th width="100" height="40">관리자</th>
    		<th width="200" height="40">업로드날짜</th>
		</tr>
		<c:forEach items="${noticeList}" var="noticeVO">
    				<tr>
    					<td height="50">${noticeVO.ntnum}</td>
    					<td height="50">
    					<a href="#" onClick="go_notice('${noticeVO.ntnum}');">${noticeVO.title}</a>
    						<c:if test="${noticeVO.readcount>=15}">✨</c:if>
    					</td>
    					<td height="50">${noticeVO.id}</td>
    					<td height="50"><fmt:formatDate value="${noticeVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    				</tr>
    		</c:forEach>
		</table>
	<form name="frm" method="post" id="adminNotice_serbox">
		<table>
			<tr>
				<td><input type="text" name="key" value="${key}" style="width:170px; height:20px;">
				<input type="button" class="btn" value="검색" onClick="go_search('adminNotice');" style="height:25px;">
				<input type="button" class="btn" value="전체보기" onClick="go_total('adminNotice');" style="height:25px;">
				<input type="button" class="btn" value="공지사항등록" onClick="go_nowrt();" style="height:25px;">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<!-- 여기서 value값으로 보내는 command를 paging.jsp로 보내서 action태그에 value로 전달함. -->
	<jsp:include page="/paging.jsp">
		<jsp:param name="command" value="ticket.do?command=adminNotice" />
	</jsp:include>
</article>
<%@ include file="../admin_footer.jsp" %>