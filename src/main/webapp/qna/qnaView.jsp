<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="qna/qna.css" rel="stylesheet">
<article style="margin-top: 150px;">
	<div class="qna_head_m">
		<h2>1:1 문의</h2>
	</div>
	<form>
		<table class="qnatable">
			<tr>
				<th>제목</th>
				<td class="qna_ht" align="left">${qnaVO.subject}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td class="qna_ht" align="left"><fmt:formatDate value="${qnaVO.indate}" type="date" /></td>
			</tr>
			<tr>
				<th>문의내용</th>
				<td class="qna_ttt" align="left">${qnaVO.content}</td>
			</tr>
		</table>
		<div class="clear"></div>
		<div class="qna_bts_1">
			<input type="button" value="목록으로" class="qna_bu" 
				onclick="location.href='ticket.do?command=qna'">
			<!-- 목록 버튼을 누르면 qnalist.jsp 로 이동합니다.  -->
		</div>
	</form>

	<form action="ticket.do" method="post" name="frm_reply" class="qna_rp">
		<input type="hidden" name="command" value="qnaReply" /> <input
			type="hidden" name="qnanum" value="${qnaVO.qseq}" />
		<table>
			<c:forEach items="${replylist}" var="reply">
				<c:choose>
					<c:when test="${reply.content==null}">
					</c:when>
					<c:otherwise>
						<tr>
							<th width="100">작성자</th>
							<th align="left" class="qna_wr">답변 내용</th>
							<th>날짜</th>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr align="center">
					<td>${reply.id}</td>
					<td align="left">&nbsp; ${reply.content}</td>
					<td><fmt:formatDate value="${reply.indate}" type="date" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</article>

<%@ include file="../footer.jsp"%>