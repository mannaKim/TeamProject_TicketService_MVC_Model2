<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>

<article id="admin_notice">
	<h2 align="center">1:1 문의 관리 </h2>
	<form name="formm" method="post">
		<table id="notice_table">
			<tr>	<th width="100" height="40">번호</th>
    		<th width="300" height="40">제목</th>
    		<th width="100" height="40">등록일</th>
    		<th width="200" height="40">작성자</th>
    		<th width="100" height="40">답변여부</th>
    		</tr>
			<c:forEach items="${qnalist}"  var="qnaVO">
				<tr ><td height="50"> ${qnaVO.qseq}</td>    
		    		<td height="50"><a href="ticket.do?command=aqnaView&qseq=${qnaVO.qseq}">
		    		<!-- 제목의 링크를 누르면 게시글 번호와 함께 QnaJustViewAction 으로 이동합니다  -->
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
				</c:choose>
		    		&nbsp; ${qnaVO.subject}</a>	
		    		<c:if test="${qnaVO.replycnt>0}">
								<span style="color:#3CB371;font-weight:bold;">[${qnaVO.replycnt}]</span>
							</c:if>
							</td>           
		       		<td height="50"><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
		       		<td height="50"> ${qnaVO.id} </td>
		       		<td height="50"><c:choose>
						<c:when test="${qnaVO.rep=='1' }"> N </c:when>
						<c:otherwise> Y </c:otherwise>
					</c:choose></td> 
		   		</tr>
		  	</c:forEach>
		</table>
	<div class="clear"></div>
	
	</form>

</article>
