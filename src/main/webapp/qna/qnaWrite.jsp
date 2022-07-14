<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  

<article>
<h2> 1:1 문의 </h2>

<form name="writeFrm" method="post" action="ticket.do">
	<input type="hidden" name="command" value="qnaWrite">
		<table id="write">
			<tr>
				<th>문의종류</th>
				<td colspan="5">
					<select name="kind">
						<option value="">선택</option>
						<c:forEach items="${kindList}" var="kindName" varStatus="status">
							<option value="${status.count}">${kindName}</option>
							<%-- <input type="hidden" name="kind" value="${status.count}">	 --%>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr><th>제목</th>
				<td width="343" colspan="5">
					<input type="text" name="subject" size="47" maxlength="100">${qnaVO.subject}
				</td>
			</tr>
			<tr>
				<th>문의내용</th>
				<td colspan="5">
					<textarea name="content" rows="8" cols="70">${qnaVO.content}</textarea>
				</td>
			</tr>
		</table>
		<input class="btn" type="button" value="작성" onClick="go_write();">
		<!-- 작성 버튼을 누르면 작성 내용 확인 후 QnaWriteAction 으로 이동합니다.  -->
		<input class="btn" type="button" value="취소" 
			onClick="location.href='ticket.do?command=qna'">
		<!-- 취소 버튼을 누르면 작성 내용 확인 후 qnalist.jsp 로 이동합니다.  -->
	</form>
</article>



   
