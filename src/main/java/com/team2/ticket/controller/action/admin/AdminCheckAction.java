package com.team2.ticket.controller.action.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.MemberVO;

public class AdminCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberVO> mvo = mdao.selectMember();
		
		request.setAttribute("mList", mvo);
		request.getRequestDispatcher("admin/adminCheck.jsp").forward(request, response);

	}

}
