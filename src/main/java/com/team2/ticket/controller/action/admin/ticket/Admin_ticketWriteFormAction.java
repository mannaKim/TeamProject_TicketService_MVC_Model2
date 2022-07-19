package com.team2.ticket.controller.action.admin.ticket;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;

public class Admin_ticketWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "admin/ticket/admin_ticketWrite.jsp";
		/*
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null)  
			url = "ticket.do?command=login";
		*/	
		request.getRequestDispatcher(url).forward(request, response);
	}

}
