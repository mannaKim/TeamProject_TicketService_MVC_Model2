<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp"%>
<link rel="stylesheet" href="../../qna/qna.css">
<article  id="admin_notice">
	<div class="qna_head">
		<h2 align="center">1:1 문의 확인</h2>
	</div>
	<form>
		<table  id="notice_table" class="aqna_table" style="border-collapse: collaps;">
			<tr>
				<th style="border-top: 0;">제목</th>
				<td class="qna_ht" align="left" style="border-top: 0;">${qnaVO.subject}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td class="qna_ht" align="left"><fmt:formatDate
						value="${qnaVO.indate}" type="date" /></td>
			</tr>
			<tr>
				<th style="border-bottom: 0;">문의내용</th>
				<td class="qna_ttt" align="left" style="border-bottom: 0;">${qnaVO.content}</td>
			</tr>
		</table>
		<div class="clear"></div>
		<div class="qna_bts_1">
			<input type="button" class="adminbtn" value="목록" style="width:150px;height:45px;"
				onclick="location.href='ticket.do?command=aqna'">
			<!-- 목록 버튼을 누르면 qnalist.jsp 로 이동합니다.  -->
		</div>
	</form>

	<form action="ticket.do" method="post" name="frm_reply" class="qna_rp">
		<input type="hidden" name="command" value="qnaReply" /> 
		<input type="hidden" name="qnanum" value="${qnaVO.qseq}" />
		<table>
			<tr>
				<th class="qna_w">작성자</th>
				<th align="left" class="qna_wr">답변 내용</th>
				<th>날짜</th>
				<th>답변 작성</th>
			</tr>
			<tr>
				<td align="center">${loginUser.id}<input type="hidden" name="id"
					value="${loginUser.id}"></td>
				<td align="left"><input type="text" name="content" size="80"
					class="qna_h_re"></td>
				<td></td>
				<td><input type="submit" class="adminbtn" value="작성" style="width:100px;height:45px;"
					onClick="return reply_check();"></td>
				<!-- 답변 작성 버튼을 누르면 내용 확인 후 QnaReplyAction 으로 이동합니다.  -->
			</tr>
			<c:forEach items="${replylist}" var="reply">
			<input type="hidden" name="renum" value="${reply.renum}" />
				<tr>
					<td align="center">${reply.id}</td>
					<td align="left">&nbsp;${reply.content}</td>
					<td><fmt:formatDate value="${reply.indate}" type="date" /></td>
					<td><input type="button" class="adminbtn" value="삭제" style="width:100px;height:45px;"
						id="qna_re_d" onClick="reply_delete('${reply.renum}','${qnaVO.qseq}');"></td>
				</tr>
			</c:forEach>
		</table>
	</form>



</article>
