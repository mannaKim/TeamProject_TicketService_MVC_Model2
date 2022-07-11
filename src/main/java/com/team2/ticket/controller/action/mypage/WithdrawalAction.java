package com.team2.ticket.controller.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.MemberVO;

public class WithdrawalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ticket.do?command=index";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url = "ticket.do?command=loginForm";
		}else {
			MemberDao mdao = MemberDao.getInstance();
			mdao.deleteMember(mvo.getId());
			session.removeAttribute("loginUser");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
