package com.team2.ticket.controller.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.MemberVO;

public class CheckPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ticket.do?command=checkPwdForm";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		if(mvo.getPwd()==null) {
			request.setAttribute("message", "비밀번호 오류. 관리자에게 문의하세요.");
		} else if(pwd.equals(mvo.getPwd())) {
			url = "ticket.do?command="+request.getParameter("purpose");
		} else {
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
