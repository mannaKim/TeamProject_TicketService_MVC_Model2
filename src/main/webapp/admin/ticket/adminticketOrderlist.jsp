<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>
<%-- <%@ include file="../admin_image_menu.jsp" %> --%>

<article>
<br>
<h2 align="center">전시 예약 리스트</h2>
<form name="formm" method="post">
<table id="t_admin_listbox">
	<tr>
		<th>No.</th>
		<th>행사명</th>
		<th>구매자</th>
		<th>ID</th>
		<th>공연날짜</th>
		<th>구매티켓</th>
		<th>&nbsp;</th>
	</tr>
	<tr><td id="t_admin_listbox_line" colspan="7"></td><tr>
	<c:forEach items="${TicketCartList}" var="tcVO">
		<tr>
			<td>${tcVO.cseq}</td>
			<td>${tcVO.pname}</td>
			<td>${tcVO.mname}</td>
			<td>${tcVO.id}</td>
			<td>
				<fmt:parseDate var="sdate" value="${tcVO.choisdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:formatDate pattern="yyyy.MM.dd" value="${tcVO.choisdate}" type="date" />
			</td>
			<td>${tcVO.quantity1 + tcVO.quantity2}매 (일반:${tcVO.quantity1}매 어린이:${tcVO.quantity2}매)</td>
			<td id="btn">
				<input type="button" class="adminbtn" value="취소"  onClick="deletePass('${tcVO.tpseq}');">
			</td>
		</tr>
	</c:forEach>
	<tr><td id="t_admin_listbox_line" colspan="7"></td><tr>
</table>
<div id="t_admin_listboxbottom">
<table>
	<tr>
		<td>행사명 <input type="text" name="key" value="${key}">
			<input class="adminbtn" type="button" name="btn_search" value="검색" 
				onClick="go_ticketSearch('adminticketOrderlistForm');">
			<input class="adminbtn" type="button" name="btn_total" value="전체보기" 
				onClick="go_ticketTotal('adminticketOrderlistForm');">
		</td>
	</tr>
</table>
</div>
<div id="paging" align="center" style="font-size:110%; font-weight:bold;">
<c:url var="action" value="ticket.do?command=AdminticketOrderlistForm" />
<c:if test="${paging.prev}">
	<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
</c:if>
<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
	<c:choose>
		<c:when test="${paging.page==index}">
			<span style="color:red">${index}&nbsp;</span>
		</c:when>
		<c:otherwise>
			<a href="${action}&page=${index}&key=${key}">${index}</a>&nbsp;
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${paging.next}">
	<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
</c:if>
</div>


</article>

