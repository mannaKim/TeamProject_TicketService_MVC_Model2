<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../header.jsp"%>
<style>
.fnqkind {
	position: relective;
	margin: 0px auto;
	width: 1500px;
	box-sizing: border-box;
}
.allkind{
	margin-bottom: 100px;
	list-style: none;
}

.kind {
	text-align: center;
	border: 1px solid gray;
	width: 11%;
	float: left;
	cursor: pointer;
}
.kind a {
	height: 66px;
	text-decoration : none;
	text-align: center;
	vertical-align: middle;
	line-height: 80px;
	padding: 24px 20px;
}
.kind:hover{
	 background-color: gray;
	 color: white;
}
.kind a:hover, a:active{
 background-color: gray;
	 color: white;
}
.kind a:link, a:visited{
	 color: black;
}
</style>
<div class="fnqkind">
    <ul class="allkind">
    <li class="kind" ><a href="ticket.do?command=qnafnq&kind=1">전체보기</a></li>
    <li class="kind"><a href="ticket.do?command=qnafnq&kind=2">전시</a></li>
    <li class="kind"><a href="ticket.do?command=qnafnq&kind=3">회원안내</a></li>
    <li class="kind"><a href="ticket.do?command=qnafnq&kind=4">관람/예약</a></li>
    <li class="kind"><a href="ticket.do?command=qnafnq&kind=5">굿즈</a></li>
    </ul>
</div>