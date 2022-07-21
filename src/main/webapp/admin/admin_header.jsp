<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>admin_header</title>
	<link href="admin/css/admin.css" rel="stylesheet">
	<link href="admin/css/adminGoods.css" rel="stylesheet">
	<script src="./member/member.js"></script>
	<script src="admin/script/admin.js"></script>
	<script src="admin/script/adminGoods.js"></script>
</head>
<body>
	<div id="admin_wrap">
		<header id="admin_header">
		<div id="admin_topMenu">
			<div id="admin_logo">
				<a href="ticket.do?command=index">
					<img src="ticket_image/logo.png">
				</a>
			</div>
			
			<div id="admin_topicon"> <!-- LOGIN CART MYPAGE등등이 들어가는 코드 -->
			<ul>	
				<c:choose>
				  <c:when test="${empty loginUser}">
					<li><a href="ticket.do?command=loginForm">LOGIN</a></li>
				  </c:when>
				  <c:otherwise>
					<li>${loginUser.name}(${loginUser.id})관리자</li>
					<li class="admin_li"><a href="ticket.do?command=logout">LOGOUT</a></li>
					<li class="admin_li"><a href="ticket.do?command=index">사용자 페이지</a></li>
					<li class="admin_li"><a href="ticket.do?command=adminNotice">관리자 페이지</a></li>
					<li class="admin_li"><a href="ticket.do?command=adminCheck">관리자 권한부여</a></li>
				  </c:otherwise>
				</c:choose>
			</ul>
			</div>
		</div>
		<div class="clear"></div>
		<div id="admin_subMenu">
			<div id="admin_subicon">
			  <ul>
			  	<li><a href="ticket.do?command=adminNotice">공지사항</a></li>
			    <li><a href="ticket.do?command=adminGoodsList&page=1&key=">굿즈관리</a></li>
			    <li><a href="ticket.do?command=adminGoodsOrderList&page=1">굿즈주문관리</a></li>
			    <li><a href="ticket.do?command=admin_ticketList">전시예약관리</a></li>
			    <li><a href="ticket.do?command=adminEvent">이벤트관리</a></li>
			    <li><a href="ticket.do?command=aqna">Q&amp;A관리</a></li>
			  </ul>
			 </div>
		</div>
	</header>