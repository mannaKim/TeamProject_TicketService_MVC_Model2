package com.team2.ticket.controller.action.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GCartDao;
import com.team2.ticket.dto.GCartVO;
import com.team2.ticket.dto.MemberVO;

public class GoodsCartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "goods/goodsCartList.jsp"; 
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="ticket.do?command=loginForm";
		}else {
			//goods_cart_view에서 로그인유저 아이디로 select한 리스트 리턴해서 request에 담기
			GCartDao gcdao = GCartDao.getInstance();
			ArrayList<GCartVO> list = gcdao.selectCartList(mvo.getId());
			request.setAttribute("goodsCartList", list);
			
			//총 금액 계산해서 request에 담기
			int totalPrice = 0;
			for(GCartVO gcvo:list) 
				totalPrice += (gcvo.getPrice()*gcvo.getQuantity());
			request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
