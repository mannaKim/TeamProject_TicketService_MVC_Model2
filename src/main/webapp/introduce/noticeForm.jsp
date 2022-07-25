<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="css/intro.css" rel="stylesheet">
<article>
	<form id="noticeForm">
		<h1>공지사항</h1>
		<table>
			<tr>
				<th width="50" height="50">No.</th>
				<th width="600" height="50">제목</th>
				<th width="100" height="50">작성자</th>
				<th width="100" height="50">조회</th>
				<th width="350" height="50">업로드날짜</th>
			</tr>
			<c:forEach items="${noList}" var="noticeVO">
				<tr>
					<td height="50">${noticeVO.ntnum}</td>
					<td height="50"><a
						href="ticket.do?command=noticeView&ntnum=${noticeVO.ntnum}">${noticeVO.title}</a>
						<c:if test="${noticeVO.readcount>=15}">✨</c:if></td>
					<td height="50">${noticeVO.id}</td>
					<td height="50">${noticeVO.readcount}</td>
					<td height="50"><fmt:formatDate value="${noticeVO.indate}"
							pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		<jsp:include page="/paging.jsp">
    		<jsp:param value="ticket.do?command=notice" name="command"/>
  		</jsp:include>
  		<br>
		<div id="intro_buttons">
			<input type="button" value="돌아가기" class="submit"
				onClick="location.href='ticket.do?command=index'">
		</div>
	</form>
</article>

<%@ include file="../footer.jsp"%>