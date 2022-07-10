<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="join_header.jsp" %>
<div>
	<ol>
		<li>약관동의</li>
		<li>정보입력</li>
		<li class="">가입완료</li>
	</ol>
</div>
<div class="clear"></div>
<div>
	<c:choose>
		<c:when test="${result=='1'}">
			<h1>${memberVO.name}님! 회원가입이 완료되었습니다.</h1>
			<h2>가입하신 아이디는 <span>${memberVO.id}</span>입니다.</h2>
			<div>
				<input type="button" value="메인으로" onClick="location.href='ticket.do?command=index'">
				<input type="button" value="로그인" onClick="location.href='ticket.do?command=loginForm'">
			</div>
		</c:when>
		<c:otherwise>
			<h1>회원가입에 실패했습니다. 다시 시도하세요.</h1>
			<h2>계속 실패하면 관리자에게 문의하세요.</h2>
			<div>
				<input type="button" value="메인으로" onClick="location.href='ticket.do?command=index'">
				<input type="button" value="회원가입" onClick="location.href='ticket.do?command=termsAndConditions'">
			</div>
		</c:otherwise>
	</c:choose>
</div>
<%@ include file="../footer.jsp" %>