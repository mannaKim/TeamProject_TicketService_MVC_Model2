package com.team2.ticket.controller.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dto.MemberVO;

public class MypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ticket.do?command=goodsCartList";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url = "ticket.do?command=loginForm";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
