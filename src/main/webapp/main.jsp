<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

		<main>
            <div id="page01" class="page">
                <div id="ticketbox">
                    <div id="tickettitle">
                        <div id="ticketname">
                            <strong>전시예약</strong>
                            <p>전시예약하러가기!전시예약하러가기!</p>
                            <a href="ticket.do?command=ticketingList">예매하러가기</a>
                        </div>
                    </div>
                    <div id="ticketimage">
                    	<div id="imgbox">
                    		<c:forEach items="${ticketList}" var="ticketListVO">        
									<!-- 상품한개, 한칸 -->
									<a href="ticket.do?command=">
										<img src="ticket_image/${ticketListVO.image}"/>
									</a>
                        	</c:forEach>
                        </div>
                        <div id="remot">▶</div>
                        <div id="lbutton">←</div>
                        <div id="rbutton">→</div>
                        <div id="currentNum">1/5</div>
                    </div>
                </div>
            </div>

            <div id="page02" class="page">
                <div id="goodsbox">
                	<div id="slide_banner">
						<div id="banner_imgs">
							<a href="ticket.do?command=goodsMain"><img class="b_img"
								src="goods/goods_images/sub_images/welcome_wide_1.png"></a><a
								href="ticket.do?command=goodsDetail&gseq=21"><img class="b_img"
								src="goods/goods_images/sub_images/welcome_wide_2.jpg"></a><a
								href="ticket.do?command=goodsSearch&page=1&key=피너츠"><img
								class="b_img" src="goods/goods_images/sub_images/welcome_wide_3.png"></a><a
								href="ticket.do?command=goodsDetail&gseq=22"><img class="b_img"
								src="goods/goods_images/sub_images/welcome_wide_4.jpg"></a>
						</div>
						<div id="goods_remot">
							<ul>
								<li onClick="moveNum(0)"></li>
								<li onClick="moveNum(1)"></li>
								<li onClick="moveNum(2)"></li>
								<li onClick="moveNum(3)"></li>
							</ul>
						</div>
						<div id="goods_lbutton" onClick="moveLeft();"
							style="background-image: url(goods/goods_images/sub_images/left.png);"></div>
						<div id="goods_rbutton" onClick="moveRight();"
							style="background-image: url(goods/goods_images/sub_images/right.png);"></div>
					</div>
                </div>
            </div>

            <div id="page03" class="page">
                <div id="qnabox">
                    <div id="topqna">
                        <div id="qnaname">문의하기</div>
                    </div>
                    <div id="botqna">
                        <div id="qnatext">문의하기 내용입니다! 문의하기 내용입니다!<br>문의하기 내용입니다!</div>
                        <a href="ticket.do?command=qna">이동하기</a>
                    </div>
                </div>
            </div>
           
        </main>

<%@ include file="footer.jsp" %>