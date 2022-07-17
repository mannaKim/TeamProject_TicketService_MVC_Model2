package com.team2.ticket.controller.action.admin.goods;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.OrderDao;

public class ChangeOrderResultAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String result = request.getParameter("result");
		Integer oseq = Integer.parseInt(request.getParameter("oseq"));
		String url = "ticket.do?command=adminGoodsOrderModify&oseq="+oseq;
		
		OrderDao odao = OrderDao.getInstance();
		
		if(request.getParameter("odseq")==null) {
			odao.changeResultAll(oseq,result);
		}
		else {
			Integer odseq = Integer.parseInt(request.getParameter("odseq"));
			odao.changeResult(odseq,result);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
