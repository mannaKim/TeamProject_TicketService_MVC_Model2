<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<form method="post" name="frm" action="ticket.do?command=goodsSearch&page=1">
	<input type="text" name="key" value="${key}">
	<input type="submit" value="검색">
</form>
<table>
	<tr>
		<td><img src="goods/sub_images/gs_icon_01.png" onClick="location.href='ticket.do?command=goodsCategory&kind=1'"></td>
		<td><img src="goods/sub_images/gs_icon_02.png" onClick="location.href='ticket.do?command=goodsCategory&kind=2'"></td>
		<td><img src="goods/sub_images/gs_icon_03.png" onClick="location.href='ticket.do?command=goodsCategory&kind=3'"></td>
		<td><img src="goods/sub_images/gs_icon_04.png" onClick="location.href='ticket.do?command=goodsCategory&kind=4'"></td>
		<td><img src="goods/sub_images/gs_icon_05.png" onClick="location.href='ticket.do?command=goodsCategory&kind=5'"></td>
	</tr>
	<tr>
		<td><a href="ticket.do?command=goodsCategory&kind=1">문구</a></td>
		<td><a href="ticket.do?command=goodsCategory&kind=2">디지털</a></td>
		<td><a href="ticket.do?command=goodsCategory&kind=3">가방 · 파우치</a></td>
		<td><a href="ticket.do?command=goodsCategory&kind=4">취미용품</a></td>
		<td><a href="ticket.do?command=goodsCategory&kind=5">패션 · 잡화</a></td>
	</tr>
</table>