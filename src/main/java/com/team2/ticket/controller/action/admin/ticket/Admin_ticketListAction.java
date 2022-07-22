package com.team2.ticket.controller.action.admin.ticket;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;
import com.team2.ticket.util.Paging;

public class Admin_ticketListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		String url = "admin/ticket/admin_ticketList.jsp";
		HttpSession session = request.getSession();
		Ticket_productDao pdao = Ticket_productDao.getInstance();
		
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
		
		if( request.getParameter("key") != null ) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		}else if( session.getAttribute("key") != null ) {
			key = (String)session.getAttribute("key");
		} else {
			session.removeAttribute("key");
		}
		
		
		int count = pdao.getAllCount( "ticket_product",key );
		paging.setTotalCount(count);
		
		ArrayList<Ticket_productVO> list = pdao.adminlistTicket( paging, key );
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
		request.setAttribute("paging", paging);
		
		
		request.getRequestDispatcher(url).forward(request, response);

	}
}
