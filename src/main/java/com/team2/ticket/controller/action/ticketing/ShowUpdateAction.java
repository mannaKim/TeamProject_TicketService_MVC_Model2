package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;

public class ShowUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		int tpseq = Integer.parseInt(request.getParameter("tpseq"));
		
		Ticket_productDao pdao = Ticket_productDao.getInstance();
		Ticket_productVO pvo = pdao.getTProduct(tpseq);
		
		request.setAttribute("ticketVO", pvo);
		request.getRequestDispatcher("ticketing/showUpdateForm.jsp").forward(request, response);
	}

}
