package com.team2.ticket.controller.action.goods;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.OrderDao;
import com.team2.ticket.dto.MemberVO;

public class GoodsOrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String url = "";
		
		int gseq = Integer.parseInt(request.getParameter("gseq"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="ticket.do?command=loginForm";
		}else {
			OrderDao odao = OrderDao.getInstance();
			int oseq = odao.insertOrderOne(gseq,quantity,mvo.getId());
			
			url = "ticket.do?command=goodsOrderList&oseq="+oseq;
		}
		response.sendRedirect(url);
	}

}
