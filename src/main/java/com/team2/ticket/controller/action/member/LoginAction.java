package com.team2.ticket.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = "ticket.do?command=loginForm";
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		if(mvo==null) {
			request.setAttribute("message", "일치하는 아이디가 없습니다.");
		}else if(mvo.getPwd()==null) {
			request.setAttribute("message", "시스템 오류. 관리자에게 문의하세요.");
		}else if(!mvo.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}else if(mvo.getPwd().equals(pwd)) {
			url = "ticket.do?command=index";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
		}else {
			request.setAttribute("message", "시스템 오류. 관리자에게 문의하세요.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
