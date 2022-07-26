<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<title>TicketService</title>
	<link href="css/ticket.css" rel="stylesheet">
	<link href="css/goods.css" rel="stylesheet">
	<link href="css/ticketingbtn.css" rel="stylesheet">
	<link href="css/calendar.css" rel="stylesheet">
	<link href="css/mypage.css" rel="stylesheet">
	<script src="script/jquery-3.6.0.js"></script>
	<script src="script/main.js"></script>
	<script src="script/member.js"></script>
	<script src="script/mypage.js"></script>
	<script src="script/goods.js"></script>
	<script src="script/intro.js"></script>
	<script src="script/ticketing.js"></script>
	<script src="script/qna.js"></script>
</head>
<body>
	<div id="wrap">
        <header>
            <div id="top">
                <div id="login">
                    <nav id="user_menu">
                        <ul>
                            <c:choose>
                                <c:when test="${empty loginUser}">
                                    <li><a href="#" onClick="go_login();">MyPage</a></li>
                                    <li><a href="ticket.do?command=termsAndConditions">회원가입</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li>${loginUser.name}(${loginUser.id})</li>
                                    <li><a href="ticket.do?command=logout">LOGOUT</a></li>
                                    <li><a href="ticket.do?command=mypage">MyPage</a></li>
                                    <li><a href="ticket.do?command=goodsCartList">Cart</a></li>
                                    <c:if test="${loginUser.admin=='1'}">	
                                        <li><a href="ticket.do?command=adminNotice&page=1">Admin</a></li>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </nav>
                </div>
                <div id="logo">
                    <div id="logobox">
                        <a href="ticket.do?command=index"><img src="ticket_image/logo.png"/></a>
                    </div>
                    <div id="menubox">
                        <input type="checkbox" id="menuicon">
                        <label for="menuicon">
                            <span></span>
                            <span></span>
                            <span></span>
                        </label>
                        <div id="sidebar" class="sidebar">
                            <div class="accordion">
                                <div class="contentBx">
                                    <div class="label">소개</div>
                                    <div class="content">
                                    	<p><a href="ticket.do?command=introduce">회사소개</a></p>
                                    	<p><a href="ticket.do?command=notice">공지사항</a></p>
                                    	<p><a href="ticket.do?command=event">이벤트</a></p>
                                    </div>
                                </div>
                                <div class="contentBx">
                                    <div class="label">전시/공연 예약</div>
                                    <div id="content02" class="content">
                                    <p><a href="ticket.do?command=ticketingList">전시 둘러보기</a></p>   
                                    </div>
                                </div>
                                <div class="contentBx">
                                    <div class="label"><a href="ticket.do?command=goodsMain">굿즈</a></div>
                                    <div id="content03" class="content">
                                    <p><a href="ticket.do?command=goodsCategory&kind=1&page=1">문구</a></p>
                                    <p><a href="ticket.do?command=goodsCategory&kind=2&page=1">디지털</a></p>
                                    <p><a href="ticket.do?command=goodsCategory&kind=3&page=1">가방 · 파우치</a></p>
                                    <p><a href="ticket.do?command=goodsCategory&kind=4&page=1">취미용품</a></p>
                                    <p><a href="ticket.do?command=goodsCategory&kind=5&page=1">패션 · 잡화</a></p>
                                    </div>
                                </div>
                                <div class="contentBx">
                                    <div class="label"><a href="ticket.do?command=qna">문의게시판</a></div>
                                     <div id="content04" class="content">
	                                    <p><a href="ticket.do?command=qnaWriteForm">1:1문의하기</a></p>
	                                    <p><a href="ticket.do?command=qnafnq&kind=1">FAQ</a></p>
                                    </div>
                                </div>
                            </div>
                            <script>
                                const accordion = document.getElementsByClassName('contentBx');
                        
                                for(i=0; i<accordion.length; i++){
                                    accordion[i].addEventListener('click', function(){
                                        this.classList.toggle('active');
                                    })
                                }
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </header>
	
