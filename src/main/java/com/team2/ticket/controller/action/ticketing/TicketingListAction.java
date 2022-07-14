package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;



public class TicketingListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "ticketing/ticketingList.jsp";
		
		Ticket_productDao pdao = Ticket_productDao.getInstance();
		ArrayList<Ticket_productVO> list = pdao.listTicket();
		
		request.setAttribute("ticketList", list);
		
		
	    request.getRequestDispatcher(url).forward(request, response);	

	}

}
