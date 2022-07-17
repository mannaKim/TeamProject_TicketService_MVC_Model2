package com.team2.ticket.controller.action.admin.goods;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.OrderDao;
import com.team2.ticket.dto.GOrderVO;
import com.team2.ticket.dto.MemberVO;

public class AdminGoodsOrderModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "admin/goods/goodsOrderModify.jsp";
		
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null || mvo.getAdmin()!=1) {
			url="ticket.do?command=loginForm";
		}else {
			OrderDao odao = OrderDao.getInstance();
			ArrayList<GOrderVO> orderList = odao.selectOrderList(oseq);
			request.setAttribute("goodsOrderList", orderList);
			
			int totalPrice = 0;
			for(GOrderVO govo : orderList)
				totalPrice += govo.getPrice()*govo.getQuantity();
			request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
