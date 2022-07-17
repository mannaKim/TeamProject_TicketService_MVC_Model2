package com.team2.ticket.controller.action.admin.goods;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dto.MemberVO;

public class AdminGoodsInsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "admin/goods/goodsInsert.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null || mvo.getAdmin()!=1) {
			url="ticket.do?command=loginForm";
		}else {
			String [] goodsKindList = {"문구","디지털","가방 · 파우치","취미용품","패션 · 잡화"};
			request.setAttribute("goodsKindList", goodsKindList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
