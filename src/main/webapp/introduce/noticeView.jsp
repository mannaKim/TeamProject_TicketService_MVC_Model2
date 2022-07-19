<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    <article>
    <form id="noticeView">
    	<table>
    	<tr>
    		<th colspan="4" width="1200" height="75">${notice.title}</th>
    	</tr>
    	<tr>
    		<th width="100" height="50" colspan="4" style="text-align:left; font-size:16px;">작성자 : ${notice.id}</th>
    	</tr>
    	<tr>
    		<th height="50" style="text-align:left; font-size:16px;">작성일 : <fmt:formatDate value="${notice.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></th>	
    		<th width="100">조회수 : ${notice.readcount}</th>
    	</tr>
    	<tr>
    		<th colspan="4" height="300">${notice.content}</th>
    	</tr>
    	</table><br><br>
    	<div id="buttons">
    	<input type="button" class="submit" value="목록으로" onClick="location.href='ticket.do?command=notice'">
    	</div>
    </form>
    </article>
    
    <%@ include file="../footer.jsp" %>