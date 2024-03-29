<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../mypage/sub_image_menu.jsp"%>
<link href="qna/qna.css" rel="stylesheet">

<article>
	<div class="qna_px">
		<div style="width:1000px;text-align:left;margin:40px auto 20px;">
			<h1>나의 문의</h1>
		</div>
		<form name="formm" method="post">
			<table id="qna_list">
				<tr>
					<th>번호</th>
					<th align="left" class="qna_wr">제목</th>
					<th>등록일</th>
					<th>작성자</th>
					<th>답변여부</th>
				</tr>
				<c:choose>
					<c:when test="${empty qnalist}">
						<tr>
							<td colspan="4" class="qna_empty">작성한 글이 없습니다</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach items="${qnalist}" var="qnaVO">
							<tr>
								<td>${qnaVO.qseq}</td>
								<td align="left" class="qna_wr"><a
									href="ticket.do?command=qnaMyView&qseq=${qnaVO.qseq}"> <!-- 제목의 링크를 누르면 게시글 번호와 함께 QnaJustViewAction 으로 이동합니다  -->
										<c:choose>
											<c:when test="${qnaVO.kind==1}">
											[전시]
										</c:when>
											<c:when test="${qnaVO.kind==2}">
											[회원안내]
										</c:when>
											<c:when test="${qnaVO.kind==3}">
											[관람/예약]
										</c:when>
											<c:when test="${qnaVO.kind==4}">
											[굿즈]
										</c:when>
											<c:otherwise>
											[기타]
										</c:otherwise>
										</c:choose> &nbsp; ${qnaVO.subject}
								</a> <c:if test="${qnaVO.replycnt>0}">
										<span style="color: #3CB371; font-weight: bold;">[${qnaVO.replycnt}]</span>
									</c:if></td>
								<td><fmt:formatDate value="${qnaVO.indate}" type="date" /></td>
								<td>${qnaVO.id}</td>
								<td>
									<c:choose>
										<c:when test="${qnaVO.rep=='1' }"> N </c:when>
										<c:otherwise> Y </c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<div class="clear"></div>
			<br>
			<jsp:include page="../paging.jsp">
				<jsp:param value="ticket.do?command=qnare" name="command" />
			</jsp:include>
			<br>
			<div class="clear"></div>
			<div class="qna_bts_1">
				<input type="button" value="1:1 문의하기" class="qna_bu"
					onClick="location.href='ticket.do?command=qnaWriteForm'">
				<!-- 문의하기 버튼을 누르면 QnaWirteFormAction 으로 이동합니다.  -->
			</div>
			<div class="clear"></div>
			<br>
		</form>
	</div>
</article>
<%@ include file="../footer.jsp"%>
