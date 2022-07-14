<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="intro_header.jsp" %>
    <%@ include file="sub_image_menu.jsp" %>
    <div id="wrap" align="center">
    	<form>
    		<table border="1">
    			<tr>
    				<th width="100">번호</th>
    				<th width="300">제목</th>
    				<th width="100">작성자</th>
    				<th width="50">조회수</th>
    				<th width="200">날짜</th>
    			</tr>
    			<c:forEach items="${noList}" var="noticeVO">
    				<tr>
    					<td width="100">${noticeVO.ntnum}</td>
    					<td width="300">
    					<a href="ticket.do?command=noticeView&ntnum=${noticeVO.ntnum}">${noticeVO.title}</a>
    						<c:if test="${noticeVO.readcount>=15}">✨</c:if>
    					</td>
    					<td width="100">${noticeVO.id}</td>
    					<td width="50">${noticeVO.readcount}</td>
    					<td width="200"><fmt:formatDate value="${noticeVO.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
    				</tr>
    			</c:forEach>
    		</table><br><br>
    		<input type="button" value="돌아가기" onClick="location.href='ticket.do?command=index'">
    	</form>
    </div>
    
    <%@ include file="../footer.jsp" %>