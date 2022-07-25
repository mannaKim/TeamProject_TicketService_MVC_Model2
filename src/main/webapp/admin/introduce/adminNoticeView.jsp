<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
	<article id="admin_noticeView">
    	<table>
    	<tr>
    		<th width="250" height="30">작성자</th>
    		<th width="250" height="30">제목</th>
    		<th width="250" height="30">작성일</th>
    	</tr>
    	<tr>
    		<td height="50">${notice.id}</td>
    		<td height="50">${notice.title}</td>
    		<td height="50"><fmt:formatDate value="${notice.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    	</tr>
    	<tr>
    		<td colspan="4" height="100">${notice.content}</td>
    	</tr>
    	</table>
    	<br>
    	<div id="noticeView_btn">
	    	<input type="button" class="adminbtn" value="목록으로" onClick="location.href='ticket.do?command=adminNotice'" style="width:100px; height:30px;">
	    	<input type="button" class="adminbtn" value="수정하기" onClick="checkPass('${notice.ntnum}', 'update');" style="width:100px; height:30px;">
	    	<input type="button" class="adminbtn" value="삭제하기" onClick="checkPass('${notice.ntnum}', 'delete');" style="width:100px; height:30px;">
	    </div>
    </article>

<%@ include file="../admin_footer.jsp" %>