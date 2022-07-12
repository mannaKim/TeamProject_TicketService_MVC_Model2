package com.team2.ticket.controller.action.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dto.GoodsVO;

public class GoodsCategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		
		GoodsDao gdao = GoodsDao.getInstance();
		ArrayList<GoodsVO> list = gdao.getGoodsCategoryList(kind);
		request.setAttribute("goodsCategoryList", list);
		
		String url = "goods/goodsCategory.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
