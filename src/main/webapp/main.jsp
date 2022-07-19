<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

		<main>
            <div id="page01" class="page">
                <div id="ticketbox">
                    <div id="tickettitle">
                        <div id="ticketname">
                            <strong>전시예약</strong>
                            <p>전시예약하러가기! 전시예약하러가기!</p>
                            <a href="#">예매하러가기</a>
                        </div>
                    </div>
                    <div id="ticketimage">
                    <c:forEach items="${ticketList}" var="ticketListVO">
                        	<div id="imgbox">                  
									<!-- 상품한개, 한칸 -->
									<a href="ticket.do?command=">
										<img src="ticket_image/${ticketListVO.image}"/>
									</a>
                        	</div>
                        </c:forEach>
                        <div id="remot">▶</div>
                        <div id="lbutton">←</div>
                        <div id="rbutton">→</div>
                        <div id="currentNum">1/5</div>
                    </div>
                </div>
            </div>

            <div id="page02" class="page">
                <div id="goodsbox"></div>
            </div>

            <div id="page03" class="page">
                <div id="qnabox">
                    <div id="topqna">
                        <div id="qnaname">문의하기</div>
                    </div>
                    <div id="botqna">
                        <div id="qnatext">문의하기 내용입니다! 문의하기 내용입니다!<br>문의하기 내용입니다!</div>
                        <a href="" >이동하기</a>
                    </div>
                </div>
            </div>
           
        </main>

<%@ include file="footer.jsp" %>