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
import com.team2.ticket.util.Paging;

public class AdminCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		MemberDao mdao = MemberDao.getInstance();
		int p = 1;
		
		if(request.getParameter("page") != null) {
			p = Integer.parseInt(request.getParameter("page"));
		}
		Paging paging = new Paging();
		paging.setPage(p);
		
		int count = mdao.getAllCount();
		paging.setTotalCount(count);
		
		ArrayList<MemberVO> mvoList = mdao.selectMember(paging);
		
		request.setAttribute("mList", mvoList);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher("admin/adminCheck.jsp").forward(request, response);
	}
}
