package com.team2.ticket.controller.action.goods;

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

public class GoodsOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String url = "mypage/goodsOrderList.jsp";
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="ticket.do?command=loginForm";
		}else {
			OrderDao odao = OrderDao.getInstance();
			//goods_order_view에서 주문번호(oseq)로 검색
			ArrayList<GOrderVO> list = odao.selectOrderList(oseq);
			int totalPrice = 0;
			for(GOrderVO govo : list) totalPrice += govo.getPrice()*govo.getQuantity();
			
			request.setAttribute("goodsOrderList", list);
			request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
