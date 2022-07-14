package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;

public class showDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		int tpseq = Integer.parseInt(request.getParameter("tpseq"));
		
		Ticket_productDao pdao = Ticket_productDao.getInstance();
		pdao.deleteShow(tpseq);
		
		request.getRequestDispatcher("ticket.do?command=ticketingList").forward(request, response);
	}

}
