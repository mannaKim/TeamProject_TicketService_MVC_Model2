package com.team2.ticket.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.MemberVO;

public class FindPwdStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/findPwd.jsp";
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		if(mvo==null) {
			request.setAttribute("msg", "해당 아이디의 회원이 없습니다.");
		}else if(!name.equals(mvo.getName())) {
			request.setAttribute("id", id);
			request.setAttribute("msg", "이름이 일치하지 않습니다.");
		}else if(!phone.equals(mvo.getPhone())) {
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("msg", "전화번호가 일치하지 않습니다.");
		}else {
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			url = "member/findPwdConfirmNumber.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
