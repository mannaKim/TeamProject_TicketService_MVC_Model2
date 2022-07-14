<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp" %>
<%@ include file="admin_image_menu.jsp" %>

<c:if test="${loginUser.admin == 1}">
	<table align="center" width="800" bgcolor="black" cellspacing="1">
		<tr bgcolor="white">
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>등급</th>
			<th>등급변경</th>
		<c:forEach items="${mList}" var="member">
			<tr bgcolor="white" align="center">
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.phone}</td>
				<td>${member.email}</td>
				<td><fmt:formatDate value="${member.indate}" pattern="YYYY/MM/dd EEEE"></fmt:formatDate></td>
				<td>
					<c:choose>
						<c:when test ="${member.admin==1}">
							관리자
						</c:when>
						<c:otherwise>
							일반사용자
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${member.id==loginUser.id}">
							<!-- 본인은 등급변경 못하도록 비워둠 -->
						</c:when>
						<c:when test="${member.admin==1}">
							<input type="button" value="일반으로 변경" 
							onClick="location.href='ticket.do?command=editadmin&id=${member.id}&admin=${member.admin}'"/>
						</c:when>
						<c:otherwise>
							<input type="button" value="관리자로 변경" 
							onClick="location.href='ticket.do?command=editadmin&id=${member.id}&admin=${member.admin}'"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tr>
	</table>

</c:if>


<%@ include file="../footer.jsp" %>   
    