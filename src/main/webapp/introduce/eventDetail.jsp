<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="intro_header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>

<div id="wrap" align="center">
<form name="frm">
	<table border="1">
		<tr>
			<td style="text-align:center;" height="50">${eventVO.etitle}
			<span style="float:right;"> <fmt:formatDate value="${eventVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate>&nbsp;&nbsp;| 조회 : ${eventVO.readcount} </span></td>
		</tr>
		<tr>
			<td height="50">이벤트 기간 : ${eventVO.evdate}</td>
		</tr>
		<tr>
			<td height="50">당첨자 발표일 : ${eventVO.evperson}</td>
		</tr>
		<tr>
		<td colspan="5" align="center">
			<img src="ticket_image/${eventVO.eimage2}">
		</td>
	</tr>
	</table>
	</form><br><br>
	<input type="button" value="수정" onClick="location.href='ticket.do?command=updateEvent&evnum=${eventVO.evnum}'">
	<input type="button" value="목록으로" onClick="location.href='ticket.do?command=event'">
	<br><br>
	
	<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
	<form action="ticket.do" method="post" name="frm_event">
		<input type="hidden" name="command" value="eventReply">
		<input type="hidden" name="evnum" value="${eventVO.evnum}">
		<table border="1">
			<tr>
				<th width="100">작성자</th>
				<th>내용</th>
				<th width="100">평점</th>
				<th width="100">작성일</th>
				<th width="100">추가/삭제</th>
			</tr>
			<tr align="center">
				<td>${loginUser.id}<input type="hidden" name="id" value="${loginUser.id}"></td>
				<td>
					<input type="text" name="reply" size="80">
				</td>
				<td>
					<select name="rate">
					    <option value="">평점선택</option>
					    <option value="1">★</option>
					    <option value="2">★★</option>
					    <option value="3">★★★</option>
					    <option value="4">★★★★</option>
					    <option value="5">★★★★★</option>
					</select>
				</td>
				<td>
					<fmt:formatDate value="${now}" pattern="MM/dd HH:mm"></fmt:formatDate>
				</td>
				<td>
					<input type="submit" value="댓글작성" onClick="return reply_check();">
				</td>
			</tr>
			<c:forEach items="${eventRP}" var="ereply">
				<tr align="center">
					<td>${ereply.id}</td>
					<td>${ereply.content}</td>
					<td>
						<c:if test="${ereply.rate==1}">
            			<font color="#B2CCFF">★</font>
            		</c:if>
            		<c:if test="${ereply.rate==2}">
           				<font color="#B2CCFF">★★</font>
           		 	</c:if>
            		<c:if test="${ereply.rate==3}">
            			<font color="#B2CCFF">★★★</font>
            		</c:if>
            		<c:if test="${ereply.rate==4}">
           				<font color="#B2CCFF">★★★★</font>
            		</c:if>
            			<c:if test="${ereply.rate==5||ereply.rate==null}">
           			<font color="#B2CCFF">★★★★★</font>
            		</c:if>
					</td>
					<td>
						<fmt:formatDate value="${ereply.writedate}" pattern="MM/dd HH:mm"></fmt:formatDate>
					</td>
					<td>
						<c:if test="${ereply.id == loginUser.id}">
							<input type="button" value="삭제" onClick="location.href='ticket.do?command=delRep&replynum=${ereply.replynum}&evnum=${ereply.evnum}'">
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>

<%@ include file="../footer.jsp" %>