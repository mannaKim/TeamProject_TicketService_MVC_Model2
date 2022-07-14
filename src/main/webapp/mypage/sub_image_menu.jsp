<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">

<nav id="sub_menu">
  <ul>
  	<li><a href="ticket.do?command=">나의 관람 정보 (My Ticket 뭐 이런식으로 구매한 티켓 내역 보여주기,,)</a></li>
    <li><a href="ticket.do?command=goodsCartList">장바구니</a></li>
    <li><a href="ticket.do?command=allGoodsOrderList">나의 주문 정보</a></li>
    <li><a href="#" onClick="checkPwd('modifyMemberForm');">회원정보 수정</a></li>
    <li><a href="#" onClick="checkPwd('withdrawalForm');">회원탈퇴</a></li>
  </ul>
</nav>