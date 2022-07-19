package com.team2.ticket.controller.action.admin.ticket;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;

public class Admin_ticketListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		String url = "admin/ticket/admin_ticketList.jsp";
		
		Ticket_productDao pdao = Ticket_productDao.getInstance();
		ArrayList<Ticket_productVO> list = pdao.listTicket();
		// 문자열 date 타입으로 형변환... 
		String dates= "";
		for( Ticket_productVO ptvo:list) 
			dates = ptvo.getSdate();
		
		String datee= "";
		for( Ticket_productVO ptvo:list) 
			datee = ptvo.getEdate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date sdate = sdf.parse(dates);
		Date edate = sdf.parse(datee);
					
		request.setAttribute("sdate", sdate);
		request.setAttribute("edate", edate);
					
		request.setAttribute("ticketList", list);
		
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
