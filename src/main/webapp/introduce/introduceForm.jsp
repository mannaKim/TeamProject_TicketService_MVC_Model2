<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="css/intro.css" rel="stylesheet">
<article>
	<form id="introForm">
	<table id="intro">
		<c:forEach items="${itList}" var="itList">
			<tr>
				<th width="1200" height="75" colspan="2">${itList.title}</th>
			</tr>
			<tr>
				<th width="1200" height="45" style="text-align:left; font-size:16px;">작성자 : ${itList.id}</th>
			</tr>
			<tr>
				<th width="1200" height="45" style="text-align:left; font-size:16px;">작성일 : <fmt:formatDate value="${itList.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></th>
			</tr>
			<tr>
				<th colspan="3" align="center"><img src="ticket_image/intro.png" /></th>
			</tr>
		</c:forEach>
	</table><br><br>
	<div id="intro_buttons">
		<input type="button" value="돌아가기" class="submit" onClick="location.href='ticket.do?command=index'">
	</div>
	</form>
</article>
<%@ include file="../footer.jsp" %>