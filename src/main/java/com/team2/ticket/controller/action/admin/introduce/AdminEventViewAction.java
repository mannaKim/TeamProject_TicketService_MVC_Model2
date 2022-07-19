package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dto.EventVO;

public class AdminEventViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		int evnum = Integer.parseInt(request.getParameter("evnum"));
		
		EventDao edao = EventDao.getInstance();
		EventVO evo = edao.getEvent(evnum);
		
		request.setAttribute("event", evo);
		
		request.getRequestDispatcher("admin/introduce/adminEventView.jsp").forward(request, response);

	}

}
