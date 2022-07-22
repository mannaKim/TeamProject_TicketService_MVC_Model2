package com.team2.ticket.controller.action.admin.ticket;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_CartDao;
import com.team2.ticket.dto.Ticket_CartVO;
import com.team2.ticket.util.Paging;

public class AdminticketOrderlistFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "admin/ticket/adminticketOrderlist.jsp";
		
		HttpSession session = request.getSession();
		Ticket_CartDao tcdao = Ticket_CartDao.getInstance();
		

		Paging paging = new Paging();
		
		paging.setDisplayPage(10);
		paging.setDisplayRow(10);
		
		if( request.getParameter("page") != null ) {
			paging.setPage( Integer.parseInt( request.getParameter("page") ) );
			session.setAttribute("page", Integer.parseInt( request.getParameter("page") ) );
		} else if ( session.getAttribute("page") != null ) {
			paging.setPage( (Integer)session.getAttribute("page") );
		} else {
			paging.setPage(1);
			session.removeAttribute("page");
		}

		String key = "";

		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		} else if (session.getAttribute("key") != null) {
			key = (String) session.getAttribute("key");
		} else {
			session.removeAttribute("key");
		}
		
		int count = tcdao.getAllCount( "ticket_product" ,key);
		paging.setTotalCount(count);
		
		ArrayList<Ticket_CartVO> list = tcdao.listTicketCart( paging,key );
		
		request.setAttribute("TicketCartList", list);
		request.setAttribute("paging", paging);
		
	    request.getRequestDispatcher(url).forward(request, response);
		

	}

}
