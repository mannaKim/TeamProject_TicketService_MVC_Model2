<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="member/css/member.css" rel="stylesheet">
  	<script src="member/member.js"></script>
</head>
<body>
	<h1>우편번호 검색</h1>	
	<div id="address_box">
    <form method="post" name="frm" action="ticket.do">
      <input type="hidden" name="command" value="findAddress">
      <div id="address_src">
      	<h3>주소(시/동/군)를(을) 입력하세요.</h3>
      	<input type="text" name="dong" style="width:310px; height:25px; font-size:18px;">
      	<input type="submit" value="찾기" class="submit" style="width:65px; height:30px;">
      </div>
    </form>
    <!-- 검색된 우편번호와 동이 표시되는 곳 -->
	    <table>
	      <tr id="address_title">
	        <th width="100">우편번호</th><th>주소</th>
	      </tr>
	      <c:forEach items="${addressList}" var="add">
	        <tr id="address_name">
	          <td class="address_name">
	            <!-- 함수 호출 형태 : result('123-123','서울시','서대문구','대현동') -->
	            <a href="#" onClick="save_address('${add.zip_num}','${add.sido}','${add.gugun}','${add.dong}');">
	              ${add.zip_num}
	            </a>
	          </td>
	          <td class="address_name">
	            <a href="#" onClick="save_address('${add.zip_num}','${add.sido}','${add.gugun}','${add.dong}');">
	              ${add.sido} ${add.gugun} ${add.dong}
	            </a>
	          </td>
	        </tr>
	      </c:forEach>
	    </table>
  </div>
</body>
</html>