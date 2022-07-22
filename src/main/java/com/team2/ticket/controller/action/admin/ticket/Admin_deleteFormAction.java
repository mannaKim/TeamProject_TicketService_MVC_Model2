package com.team2.ticket.controller.action.admin.ticket;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;

public class Admin_deleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		
		int tpseq = Integer.parseInt(request.getParameter("tpseq"));
		
		Ticket_productDao tpdao = Ticket_productDao.getInstance();
		
		tpdao.deleteTicket_productr_cart( tpseq );
		tpdao.deleteTicket_productr( tpseq );
		
		String url = "ticket.do?command=admin_ticketList";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
