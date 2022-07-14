<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="intro_header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<div id="wrap" align="center">
	<form>
	<table border="1">
		<tr>
			<th width="400">제목</th>
			<th width="100">작성자</th>
			<th width="200">등록일</th>
		</tr>
		<c:forEach items="${itList}" var="itList">
			<tr>
				<th width="400">${itList.title}</th>
				<th width="100">${itList.id}</th>
				<th width="200"><fmt:formatDate value="${itList.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></th>
			</tr>
			<tr >
				<th colspan="3">${itList.content}</th>
			</tr>
			<tr>
				<td colspan="3" align="center"><img src="ticket_image/intro1.jpg" /></td>
			</tr>
		</c:forEach>
	</table><br><br>
	<input type="button" value="돌아가기" onClick="location.href='ticket.do?command=index'">
	</form>
</div>
<%@ include file="../footer.jsp" %>