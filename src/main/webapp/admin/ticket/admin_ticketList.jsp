<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%@ include file="../admin_image_menu.jsp" %>

<article>
<h1>TicketList</h1>
<form name="formm" method="post">
<table border="1">
	<tr>
		<th>행사명</th>
		<th>기간</th>
		<th>장소</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach items="${ticketList}" var="tpVO">
		<tr>
			<td><a href="ticket.do?command=ticketshow&tpseq=${tpVO.tpseq}">&nbsp;${tpVO.name}</a></td>
			<td>
				<fmt:formatDate pattern="yyyy.MM.dd" value="${sdate}" type="date" />
			 ~ <fmt:formatDate pattern="yyyy.MM.dd" value="${edate}" type="date" />
			 </td>
			<td>${tpVO.place}</td>
			<td>
				<input type="button" value="수정" onClick="updatePass('${tpVO.tpseq}');">
				/<input type="button" value="삭제"  onClick="deletePass('${tpVO.tpseq}');">
			</td>
		</tr>
	</c:forEach>
</table>

<table>
	<tr>
		<td>행사명<input type="text" name="key" value="${key}">
			<input class="btn" type="button" name="btn_search" value="검색" 
				onClick="go_search('admin_ticketList');">
			<input class="btn" type="button" name="btn_total" value="전체보기 " 
				onClick="go_total('admin_ticketList');">
			<input class="btn" type="button" name="btn_write" value="행사등록"  onClick="go_wrt();">
		</td>
	</tr>
</table>

</form>
</article>

<%@ include file="../../footer.jsp" %>