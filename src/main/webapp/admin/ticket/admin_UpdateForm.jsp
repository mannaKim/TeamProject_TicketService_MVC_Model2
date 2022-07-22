<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../admin_header.jsp" %>

<article>
<div id="warp" align="center">
<form method="post" enctype="multipart/form-data" action="ticket.do?command=admin_ticketUpdate">
	<input type="hidden" name="tpseq" value="${ticketVO.tpseq}">
	<input type="hidden" name="oldPicture" value="${ticketVO.image}">
	<table id="t_writebox" >
			<tr><th colspan="2">행사등록</th></tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr><td id="t_writebox_title">행사명</td>
				<td width="343">
		       		<input type="text" name="name" value="${ticketVO.name}" size="80">
		    	</td>
		    </tr>
		    <tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">행사 기간</td>
				<td>
					<input type="text" name="sdate" value="<fmt:formatDate pattern="yyyy.MM.dd" value="${sdate}" type="date" />" size="11">
				 ~ <input type="text" name="edate" value="<fmt:formatDate pattern="yyyy.MM.dd" value="${edate}" type="date" />" size="11">
			</td>
			</tr> 
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">가격(일반)</td>
				<td width="70">
					<input type="text" name="price1" value="${ticketVO.price1}" size="20">
				</td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
		  		<td id="t_writebox_title">가격(어린이)</td>
		  		<td width="70">
		  			<input type="text" name="price2" value="${ticketVO.price2}" size="20">
		  		</td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">할인가격</td><td width="72">
				<input type="text" name="price3" value="${ticketVO.price3}" size="20">
			</td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
		  		<td id="t_writebox_title">나이</td>
		  		<td width="70">
		  			<input type="text" name="age" value="${ticketVO.age}" size="20">
		  		</td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">장소</td><td width="72">
				<input type="text" name="place" value="${ticketVO.place}" size="80"></td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">공연입장 시간</td><td width="72">
				<input type="text" name="daytime" value="${ticketVO.daytime}" size="20">
			</td>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">관람 시간</td><td width="72">
				<input type="text" name="showtime" value="${ticketVO.showtime}" size="20">
			</td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">행사 소개</td>
				<td>
					<textarea cols="70" rows="15" name="content"></textarea>
				</td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
			<tr>
				<td id="t_writebox_title">행사 이미지</td>
				<td width="343">
					<input type="file" name="image">
				</td>
			</tr>
			<tr><td id="t_admin_listbox_line" colspan="2"></td><tr>
		</table>
		<div align="center" style="margin-top: 10px;">
			<input type="submit" value="수정" class="adminbtn">
			<input type="reset" value="다시작성" class="adminbtn">
			<input type="button" value="목록" class="adminbtn" onClick="location.href='ticket.do?command=admin_ticketList'">
		</div>
</form>

</div>
</article>