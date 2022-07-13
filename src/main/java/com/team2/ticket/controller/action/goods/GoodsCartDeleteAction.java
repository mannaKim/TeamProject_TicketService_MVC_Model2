package com.team2.ticket.controller.action.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GCartDao;

public class GoodsCartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] gcseqArr = request.getParameterValues("gcseq");
		
		GCartDao gcdao = GCartDao.getInstance();
		
		for(String gcseq : gcseqArr)
			gcdao.deleteCart(Integer.parseInt(gcseq));
		
		response.sendRedirect("ticket.do?command=goodsCartList");
	}

}
