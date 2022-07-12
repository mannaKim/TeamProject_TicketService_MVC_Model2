package com.team2.ticket.controller.action.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dto.GoodsVO;

public class GoodsSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		if(search!=null) {
			if(search.equals("")==false) {
				GoodsDao gdao = GoodsDao.getInstance();
				ArrayList<GoodsVO> list = gdao.selectGoods(search);
				request.setAttribute("searchList", list);
			}
		}
		String url = "goods/goodsSearch.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
