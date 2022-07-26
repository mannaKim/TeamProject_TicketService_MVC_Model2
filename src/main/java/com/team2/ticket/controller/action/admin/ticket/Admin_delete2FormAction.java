package com.team2.ticket.controller.action.admin.ticket;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_CartDao;

public class Admin_delete2FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		int cseq = Integer.parseInt(request.getParameter("cseq"));
		
		Ticket_CartDao tcdao = Ticket_CartDao.getInstance();
		
		tcdao.deleteTicket_productr_cart( cseq );
		
		String url = "ticket.do?command=adminticketOrderlistForm";
		request.getRequestDispatcher(url).forward(request, response);

	}
}
