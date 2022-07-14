<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
<h1>TicketList</h1>
<form name="formm" method="post">
<div>
<div>
	<div>
	<!-- <h3>총<span class="red" id="count"></span>건 <span>(행사명을 클릭하시면 상세보기 페이지로 연결됩니다.)</span></h3> -->
	<ul>
		<li>
			<a href="#none">
				<img class="off" src="">
				<img class="on" src="">
			</a>
		</li>
		<li>
			<a href="#none">
				<img class="off" src="">
				<img class="on" src="">
			</a>
		</li>
	</ul>
	</div>
</div>
<div>
<table>
	<colgroup>
		<col style="width: *%" />
		<col style="width: 25%" />
		<col style="width: 24%" />
		<col style="width: 120px" />
	</colgroup>
	<thead>
		<tr>
			<th scope="col">행사명</th>
			<th scope="col" id="changeText">기간</th>
			<th scope="col">장소</th>
			<th scope="col">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ticketList}" var="ticket_productVO">
			<tr>
				<td><a href="ticket.do?command=ticketshow&tpseq=${ticket_productVO.tpseq}"> 
					<img src="ticket_images/${ticket_productVO.image}" width="30">
						&nbsp;${ticket_productVO.name}
				</a></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd"
						value="${ticket_productVO.sdate}" type="date" /> ~ <fmt:formatDate
						pattern="yyyy/MM/dd" value="${ticket_productVO.edate}"
						type="date" /></td>
				<td>${ticket_productVO.place}</td>
				<td>
					<a href="ticket.do?command=ticketingForm&tpseq=${ticket_productVO.tpseq}"
						class="btnCancel">예매하기</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>

</form>
</article>

<%@ include file="../footer.jsp" %>