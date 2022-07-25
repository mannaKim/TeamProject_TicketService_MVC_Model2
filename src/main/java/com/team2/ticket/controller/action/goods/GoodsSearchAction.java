package com.team2.ticket.controller.action.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dto.GoodsVO;
import com.team2.ticket.util.Paging;

public class GoodsSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		HttpSession session = request.getSession();
		
		Paging paging = new Paging();
		paging.setDisplayPage(5);
		paging.setDisplayRow(5);
		if(request.getParameter("page")!=null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
			session.setAttribute("page",Integer.parseInt(request.getParameter("page")));
		}else if(session.getAttribute("page")!=null) {
			paging.setPage((Integer)session.getAttribute("page"));
		}else {
			paging.setPage(1);
			session.removeAttribute("page");
		}
		
		GoodsDao gdao = GoodsDao.getInstance();
		int count = gdao.getGoodsCount(key);
		paging.setTotalCount(count);
		
		ArrayList<GoodsVO> list = gdao.selectGoods(paging, key);
		request.setAttribute("searchList", list);
		request.setAttribute("paging", paging);
		request.setAttribute("key", key);
			
		String url = "goods/goodsSearch.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
