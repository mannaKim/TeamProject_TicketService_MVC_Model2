<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ticket_header.jsp" %>
<div id="warp" align="center">
<form method="post" enctype="multipart/form-data" action="ticket.do?command=ticketShowUpdate">
	<input type="hidden" name="tpseq" value="${ticketVO.tpseq}">
	<input type="hidden" name="oldPicture" value="${ticketVO.image}">
	<table border="1">
		<tr>
			<th>상품명</th>
			<td><input type="text" name="name" value="${ticketVO.name}" size="80"></td>
		</tr>
		<tr>
			<th>시작시간</th>
			<td><input type="text" name="daytime" value="${ticketVO.daytime}" size="80"></td>
		</tr>
		<tr>
			<th>장소</th>
			<td><input type="text" name="place" value="${ticketVO.place}" size="80"></td>
		</tr>
		<tr>
			<th>연령</th>
			<td><input type="text" name="age" value="${ticketVO.age}" size="80"></td>
		</tr>
		<tr>
			<th>관람시간</th>
			<td><input type="text" name="showtime" value="${ticketVO.showtime}" size="80"></td>
		</tr>
		<tr>
			<th>금액</th>
			<td>성인 <input type="text" name="price1" value="${ticketVO.price1}" size="80">, 
			어린이 <input type="text" name="price2" value="${ticketVO.price2}" size="80"></td>
		</tr>
		<tr>
			<th>작품설명</th>
			<td><textarea cols="70" rows="15" name="content"></textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" name="image"></td>
		</tr>
	</table><br>
	<input type="submit" value="수정">
	<input type="reset" value="다시작성">
	<input type="button" value="목록" onClick="location.href='ticket.do?command=ticketshow'">

</form>

</div>


<%@ include file="../footer.jsp" %>