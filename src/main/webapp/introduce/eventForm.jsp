<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="intro_header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>

<div id="wrap" style="width:1300px; margin:0 auto">
<h1>이벤트</h1>
	<c:forEach items="${event}" var="eventVO">
		<div id="imgbox" style="width:500px; height:400px; box-shadow:3px 3px 3px 3px gray; float:left; margin-left:100px; margin-top:20px;">
			<a href="ticket.do?command=eventDetail&evnum=${eventVO.evnum}">
				<img src="ticket_image/${eventVO.eimage}" style="width:500px;"/>
			</a>
			<h2>${eventVO.etitle}</h2>
			<h3>이벤트 기간 : ${eventVO.evdate}</h3>
			<h3>당첨자 발표일 : ${eventVO.evperson}</h3>
		</div>
	</c:forEach>

</div>

<%@ include file="../footer.jsp" %>