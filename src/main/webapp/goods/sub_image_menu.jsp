<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
	<!-- 굿즈 검색창 -->
	<br><br>
	<div class="goods_subMenu">
        <form class="goods_searchBox" method="post" name="frm" action="ticket.do?command=goodsSearch&page=1">
            <div class="goods_search"><input type="text" name="key" value="${key}" size="45"></div>
            <div class="goods_searchBtn"><input type="submit" value=""></div>
        </form>
    </div>
    <br><br>
    <!-- 카테고리 메뉴 -->
    <div class="background_white">
    <div class="goods_categoryBox">
            <table>
                <tr>
                    <td><img src="goods/goods_images/sub_images/gs_icon_01.png" width="140px" onClick="location.href='ticket.do?command=goodsCategory&kind=1'"></td>
                    <td><img src="goods/goods_images/sub_images/gs_icon_02.png" width="140px" onClick="location.href='ticket.do?command=goodsCategory&kind=2'"></td>
                    <td><img src="goods/goods_images/sub_images/gs_icon_03.png" width="140px" onClick="location.href='ticket.do?command=goodsCategory&kind=3'"></td>
                    <td><img src="goods/goods_images/sub_images/gs_icon_04.png" width="140px" onClick="location.href='ticket.do?command=goodsCategory&kind=4'"></td>
                    <td><img src="goods/goods_images/sub_images/gs_icon_05.png" width="140px" onClick="location.href='ticket.do?command=goodsCategory&kind=5'"></td>
                </tr>
                <tr>
                    <td><a href="ticket.do?command=goodsCategory&kind=1">문구</a></td>
                    <td><a href="ticket.do?command=goodsCategory&kind=2">디지털</a></td>
                    <td><a href="ticket.do?command=goodsCategory&kind=3">가방 · 파우치</a></td>
                    <td><a href="ticket.do?command=goodsCategory&kind=4">취미용품</a></td>
                    <td><a href="ticket.do?command=goodsCategory&kind=5">패션 · 잡화</a></td>
                </tr>
            </table>
        </div>
        </div>