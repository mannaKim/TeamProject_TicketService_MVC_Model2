<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="intro_header.jsp" %>
    <%@ include file="sub_image_menu.jsp" %>
    <div id="wrap" align="center">
    	<table border="1">
    	<tr>
    		<th width="100">작성자</th>
    		<td width="200" align="center">${notice.id}</td>
    	</tr>
    	<tr>
    		<th>작성일</th>
    		<td align="center"><fmt:formatDate value="${notice.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    		<th width="100">조회수</th>
    		<td width="50" align="center">${notice.readcount}</td>
    	</tr>
    	<tr>
    		<th>제목</th>
    		<td colspan="3" align="center">${notice.title}</td>
    	</tr>
    	<tr>
    		<td colspan="4">${notice.content}</td>
    	</tr>
    	</table><br><br>
    	<input type="button" value="목록으로" onClick="location.href='ticket.do?command=notice'">
    	<input type="button" value="수정하기" onClick="checkPass('${notice.ntnum}', 'update');">
    	<input type="button" value="삭제하기" onClick="checkPass('${notice.ntnum}', 'delete');">    
    </div>
    
    <%@ include file="../footer.jsp" %>