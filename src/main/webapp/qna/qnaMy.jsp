<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../mypage/sub_image_menu.jsp"%>
<link href="qna/qna.css" rel="stylesheet">

<article style="margin-bottom: 100px;">
	<div class="qna_head_my">
		<h3>나의 문의</h3>
	</div>
	<form name="formm" method="post">
		<table id="qna_list">
			<tr>
				<th>번호</th>
				<th align="left" class="qna_wr">제목</th>
				<th>등록일</th>
				<th>작성자</th>
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
							<!-- <td><c:choose>
					<c:when test="${qnaVO.rep=='1' }"> N </c:when>
					<c:when test="${qnaVO.rep=='2' } "> Y </c:when>
				</c:choose></td>   답변여부는 해결을 하지 못해 나중에 해보는 것으로... -->
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div class="clear"></div>

		<div id="paging" class="qna_pag">
			<c:url var="action" value="ticket.do?command=qnare" />
			<c:if test="${paging.prev}">
				<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
		</c:if>
			<c:forEach begin="${paging.beginPage}" end="${paging.endPage}"
				var="index">
				<c:choose>
					<c:when test="${paging.page==index}">
						<span style="color: #2F4F4F">${index}&nbsp;</span>
					</c:when>
					<c:otherwise>
						<a href="${action}&page=${index}">${index}</a>&nbsp;
				</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next}">
				<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
		</c:if>
		</div>
		<div class="clear"></div>
		<br>

		<div class="clear"></div>
		<br>
	</form>
</article>
<%@ include file="../footer.jsp"%>
