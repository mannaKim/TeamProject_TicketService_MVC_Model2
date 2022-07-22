<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="css/intro.css" rel="stylesheet">
<article>
<form id="eventform" name="frm">
	<table>
		<tr>
			<th width="1200px;" height="70px" style="text-align:center; font-size:25px;">${eventVO.title}
			<span style="float:right; font-size:16px;"> <fmt:formatDate value="${eventVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate>&nbsp;&nbsp;| 조회 : ${eventVO.readcount} </span></th>
		</tr>
		<tr>
			<th height="50" style="text-align:left; font-size:16px;">이벤트 기간 : ${eventVO.evdate}</th>
		</tr>
		<tr>
			<th height="50" style="text-align:left; font-size:16px;">당첨자 발표일 : ${eventVO.evperson}</th>
		</tr>
		<tr>
		<th colspan="5" align="center">
			<img src="ticket_image/${eventVO.eimage2}" style="width:700px; height:1165px">
		</th>
	</tr>
	</table>
	</form><br><br>
	
	<br><br>
	<div id="intro_buttons" style="margin-bottom:40px;">
		<input type="button" class="submit" value="목록으로" onClick="location.href='ticket.do?command=event'">
	</div>
	<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
	<form action="ticket.do" method="post" name="frm_event" id="frm_event">
		<input type="hidden" name="command" value="eventReply">
		<input type="hidden" name="evnum" value="${eventVO.evnum}">
		<table border="1">
			<tr>
				<th width="300px;" height="50px;">작성자</th>
				<th>내용</th>
				<th width="150">이벤트평가</th>
				<th width="200">작성일</th>
				<th width="150">추가/삭제</th>
			</tr>
			<tr align="center">
				<td height="60px;">${loginUser.id}<input type="hidden" name="id" value="${loginUser.id}"></td>
				<td>
					<input type="text" name="reply" size="80" placeholder="댓글을 입력하세요!" style="height:45px;"> 
				</td>
				<td>
					<select name="rate">
					    <option value="0">평점선택</option>
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
					<input type="submit" class="reply_event" value="댓글작성" onClick="return reply_check();">
				</td>
			</tr>
			<c:forEach items="${eventRP}" var="ereply">
				<tr align="center">
					<td height="60px;">${ereply.id}</td>
					<td>${ereply.content}</td>
					<td>
						<c:if test="${ereply.rate==1}">
            			<font color="#E5BE43">★</font>
            		</c:if>
            		<c:if test="${ereply.rate==2}">
           				<font color="#E5BE43">★★</font>
           		 	</c:if>
            		<c:if test="${ereply.rate==3}">
            			<font color="#E5BE43">★★★</font>
            		</c:if>
            		<c:if test="${ereply.rate==4}">
           				<font color="#E5BE43">★★★★</font>
            		</c:if>
            			<c:if test="${ereply.rate==5||ereply.rate==null}">
           			<font color="#E5BE43">★★★★★</font>
            		</c:if>
					</td>
					<td>
						<fmt:formatDate value="${ereply.writedate}" pattern="MM/dd HH:mm"></fmt:formatDate>
					</td>
					<td>
						<c:if test="${ereply.id == loginUser.id}">
							<input type="button" class="reply_event" value="삭제" onClick="location.href='ticket.do?command=delRep&replynum=${ereply.replynum}&evnum=${ereply.evnum}'">
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</article>

<%@ include file="../footer.jsp" %>