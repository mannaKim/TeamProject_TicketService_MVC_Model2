<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_image_menu.jsp"%>
<article>
	<div class="goodsBox">
		<h1>관람 정보</h1>
		<c:choose>
			<c:when test="${ TicketCartList.size()==0 }">
				<div class="emptyGoodsCart">
					<img src="./goods/goods_images/sub_images/emptyOrder.png">
					<h3>예매 내역이 없습니다.</h3>
				</div>
				<div class="goodsCartButton">
					<input type="button" value="예매하러 가기" class="goodsButton1"
						onClick="location.href='ticket.do?command=goodsMain'">
				</div>
			</c:when>
			<c:otherwise>
				<div class="goodsCart">
					<table>
						<tr>
							<th>예매일</th>
							<th>주문자</th>
							<th>공연명</th>
							<th>관람일시</th>
							<th>매수</th>
							<th>예매상태</th>
						</tr>
						<c:forEach items="${ TicketCartList }" var="TcartVO">
							<jsp:useBean id="now" class="java.util.Date" />
							<fmt:formatDate pattern="yyyy.MM.dd" value="${now}" var="today" />
							<!-- 오늘날짜 -->
							<fmt:formatDate pattern="yyyy.MM.dd" value="${TcartVO.choisdate}"
								type="date" var="choisdate" />
							<tr>
								<td><fmt:formatDate pattern="yyyy.MM.dd"
										value="${TcartVO.indate}" type="date" /></td>
								<td>${ TcartVO.mname }</td>
								<td><a
									href="ticket.do?command=ticketShowMypage&tpseq=${TcartVO.tpseq}">
										${ TcartVO.pname } </a></td>
								<td>${ choisdate } - ${ TcartVO.daytime }</td>
								<td>${ TcartVO.quantity1 + TcartVO.quantity2 }매<br>
									(일반:${ TcartVO.quantity1 } 어린이:${ TcartVO.quantity2 })
								</td>
								<td><c:if test="${ choisdate > today }">
										<a href="ticket.do?command=ticketShowMypage&tpseq=${TcartVO.tpseq}">
											예매완료
										</a>
									</c:if> <c:if test="${ choisdate <= today }">
									관람기간 종료
								</c:if></td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<jsp:include page="../paging.jsp">
						<jsp:param value="ticket.do?command=ticketCartList" name="command" />
					</jsp:include>
					<br>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</article>
<%@ include file="../footer.jsp"%>