<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<article>
<nav id="sub_menu">
  <ul>
  	<li><a href="ticket.do?command=ticketCartList">나의 관람 정보</a></li>
    <li><a href="ticket.do?command=goodsCartList">장바구니</a></li>
    <li><a href="ticket.do?command=allGoodsOrderList">나의 주문 정보</a></li>
    <li><a href="#" onClick="checkPwd('modifyMemberForm');">회원정보 수정</a></li>
    <li><a href="#" onClick="checkPwd('withdrawalForm');">회원탈퇴</a></li>
  </ul>
</nav>
</article>
<!-- 최근 예매 내역 -->
<!-- 진행중인 구매 내역 -->
<%@ include file="../footer.jsp" %>