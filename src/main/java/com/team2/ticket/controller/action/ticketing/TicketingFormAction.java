package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;

public class TicketingFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		//HttpSession session = request.getSession();
		//MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		//if( mvo == null ) {
		//	url = "ticket.do?command=loginForm";
		//} else {

		//}
		
		System.out.println(1);
		int tpseq = Integer.parseInt( request.getParameter("tpseq") );
		
		Ticket_productDao tpdao = Ticket_productDao.getInstance();
		Ticket_productVO tpvo = tpdao.getTProduct( tpseq );
		
		System.out.println(2);
		System.out.println(tpseq);
		
		request.setAttribute("ticket_productVO", tpvo);
		
		
		String url = "ticketing/ticketingForm.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
