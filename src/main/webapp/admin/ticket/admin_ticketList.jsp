<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>

<article>
<br>
<h2 align="center">전시 리스트</h2>
<form name="formm" method="post">
<table id="t_admin_listbox">
	<tr>
		<th height="20">No.</th>
		<th height="20">행사명</th>
		<th height="20">행사기간</th>
		<th height="20">등록일</th>
		<th height="20">&nbsp;</th>
	</tr>
	<tr><td id="t_admin_listbox_line" colspan="5"></td><tr>
	<c:forEach items="${ticketList}" var="tpVO">
		<tr>
			<td>${tpVO.tpseq}</td>
			<td>${tpVO.name}</td>
			<td>
				<fmt:formatDate pattern="yyyy.MM.dd" value="${sdate}" type="date" />
			 ~ <fmt:formatDate pattern="yyyy.MM.dd" value="${edate}" type="date" />
			 </td>
			 <td><fmt:formatDate pattern="yyyy.MM.dd" value="${tpVO.indate}" type="date" /></td>
			<td id="btn">
				<input type="button" class="adminbtn" value="수정" onClick="updatePass('${tpVO.tpseq}');">
				<input type="button" class="adminbtn" value="삭제"  onClick="deletePass('${tpVO.tpseq}');">
			</td>
		</tr>
	</c:forEach>
	<tr><td id="t_admin_listbox_line" colspan="5"></td><tr>
</table>
<div id="t_admin_listboxbottom">
<table>
	<tr>
		<td>행사명 <input type="text" name="key" value="${key}">
			<input class="adminbtn" type="button" name="btn_search" value="검색" 
				onClick="go_ticketSearch('admin_ticketList');">
			<input class="adminbtn" type="button" name="btn_total" value="전체보기 " 
				onClick="go_ticketTotal('admin_ticketList');">
			<input class="adminbtn" type="button" name="btn_write" value="행사등록"  onClick="go_wrt();">
		</td>
	</tr>
</table>
</div>
<div id="paging" align="center" style="font-size:110%; font-weight:bold;">
<c:url var="action" value="ticket.do?command=admin_ticketList" />
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
</form>

</article>

