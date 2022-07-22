<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article class="article">
<form name="formm" method="post">
<div id="t_listBox">
<br><br><br>
<h2>진행중인 프로그램</h2><hr>
<c:forEach items="${ticketList}" var="ticket_productVO">
<jsp:useBean id="now" class="java.util.Date" /><!-- var="today" -->
<fmt:formatDate pattern="yyyy/MM/dd" value="${now}" var="today"/><!-- 오늘날짜 -->	
<fmt:parseDate var="sdate" value="${ticket_productVO.sdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
<fmt:parseDate var="edate" value="${ticket_productVO.edate}" pattern="yyyy-MM-dd HH:mm:ss"/>
<fmt:formatDate	pattern="yyyy/MM/dd" value="${sdate}" var="stdate" />
<fmt:formatDate	pattern="yyyy/MM/dd" value="${edate}" var="enddate" />

<table id="t_list">
	<tr>
		<th rowspan="2">
			<img src="ticket_image/${ticket_productVO.image}" width="190">
		</th>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td colspan="2" >
						<a href="ticket.do?command=ticketshow&tpseq=${ticket_productVO.tpseq}">
						● ${ticket_productVO.name}
						<c:if test="${ today > enddate }"><font color="gray">(행사종료)</font></c:if></a>
					</td>
					
				</tr>
				<tr>
					<td id="t_line"> 일정</td>
					<td>
						<fmt:formatDate pattern="yyyy/MM/dd" value="${sdate}" type="date" /> ~ 
						<fmt:formatDate	pattern="yyyy/MM/dd" value="${edate}" type="date" />
					</td>
				</tr>
				<tr>
					<td id="t_line"> 장소</td>
					<td>${ticket_productVO.place}</td>
				</tr>
				<tr>
					<td id="t_line"> 공연정보</td>
					<td>공연시간 : ${ticket_productVO.showtime}<br>
						시작시간 : ${ticket_productVO.daytime}</td>
				</tr>
				<tr>
					<td id="t_line"> 가격</td>
					<td>일　반 : ${ticket_productVO.price1} 원<br>
						어린이 : ${ticket_productVO.price2} 원</td>
				</tr>
				<tr>
					<td colspan="2" >
					<c:choose>
						<c:when test="${ today < enddate }">
							<c:choose>
								<c:when test="${ today < stdate }">
									<a href="ticket.do?command=ticketshow&tpseq=${ticket_productVO.tpseq}"
										class="btnCancel">상세정보</a>
									<a class="startbtnCancel">예매준비중</a>
								</c:when>
								<c:otherwise>
									<a href="ticket.do?command=ticketshow&tpseq=${ticket_productVO.tpseq}"
										class="btnCancel">상세정보</a>
									<a href="ticket.do?command=ticketingForm&tpseq=${ticket_productVO.tpseq}"
										class="btnCancel">예매하기</a>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise >
							<c:if test="${ today > enddate }">
								<a class="endbtnCancel">종료</a>
							</c:if>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

</c:forEach>
</div>

<div class="clear"></div>
<br><br><br><br>


</form>
</article>

<%@ include file="../footer.jsp" %>