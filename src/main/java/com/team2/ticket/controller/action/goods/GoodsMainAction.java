package com.team2.ticket.controller.action.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dto.GoodsVO;

public class GoodsMainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//굿즈 정보 리쿼스트에 담아가기
		GoodsDao gdao = GoodsDao.getInstance();
		ArrayList<GoodsVO> bestList = gdao.getBestList();
		ArrayList<GoodsVO> newList = gdao.getNewList();
		
		request.setAttribute("bestList", bestList);
		request.setAttribute("newList", newList);
				
		request.getRequestDispatcher("goods/goodsMain.jsp").forward(request, response);
	}

}
