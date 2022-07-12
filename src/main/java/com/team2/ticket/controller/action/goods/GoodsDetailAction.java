package com.team2.ticket.controller.action.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dto.GoodsVO;

public class GoodsDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gseq = Integer.parseInt(request.getParameter("gseq")); 
		
		GoodsDao gdao = GoodsDao.getInstance();
		GoodsVO gvo = gdao.getGoods(gseq);
		request.setAttribute("GoodsVO", gvo);
		
		String url = "goods/goodsDetail.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
