package com.team2.ticket.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.MemberVO;

public class FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/findId.jsp";
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMemberByname(name,phone);
		//이름과 전화번호로 검색해서 일치하는 회원이 있으면 인증번호 입력창으로 이동
		//일치하는 회원이 없으면 이름과 전화번호 입력창으로 돌아갑니다.
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		
		if(mvo==null) {
			request.setAttribute("msg", "일치하는 회원이 없습니다.");
		}else {
			request.setAttribute("MemberVO", mvo);
			url = "member/completeFindId.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
