package com.team2.ticket.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.MemberVO;

public class ResetPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디와 패스워드를 전달받아서
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
				
		//패스워드를 수정하고
		MemberDao mdao = MemberDao.getInstance();
		mdao.resetPwd(mvo);
				
		//패스워드 리셋 완료 페이지로 이동
		String url = "member/completeResetPwd.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
