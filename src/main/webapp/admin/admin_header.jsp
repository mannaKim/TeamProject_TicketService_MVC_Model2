<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin</title>
	<link href="./css/ticket.css" rel="stylesheet">
	<script src="./member/member.js"></script>
	<script src="admin/script/admin.js"></script>
	<script src="admin/goods/adminGoods.js"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="ticket.do?command=index">
					로고<!-- 로고 이미지가 들어갈 자리 -->
				</a>
			</div>
			
			<nav id="top_menu"> <!-- LOGIN CART MYPAGE등등이 들어가는 코드 -->
			<ul>	
				<c:choose>
				  <c:when test="${empty loginUser}">
					<li><a href="ticket.do?command=loginForm">LOGIN</a></li>
				  </c:when>
				  <c:otherwise>
					<li>${loginUser.name}(${loginUser.id})</li>
					<li><a href="ticket.do?command=logout">LOGOUT</a></li>
					<li><a href="ticket.do?command=adminCheck">관리자 권한부여</a></li>
				  </c:otherwise>
				</c:choose>
			</ul>
		</nav>
		</header>