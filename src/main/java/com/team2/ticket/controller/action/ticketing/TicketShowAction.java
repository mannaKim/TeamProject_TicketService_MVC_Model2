package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;

public class TicketShowAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		System.out.println(request.getParameter("tpseq"));
		
		int tpseq = Integer.parseInt(request.getParameter("tpseq"));
		
		Ticket_productDao tdao = Ticket_productDao.getInstance();
		Ticket_productVO pvo = tdao.getTProduct(tpseq);
		
		
		// 문자열 date 타입으로 형변환... 추가됨
		String dates = pvo.getSdate();
		String datee = pvo.getEdate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse(dates);
		Date edate = sdf.parse(datee);
		request.setAttribute("sdate", sdate);
		request.setAttribute("edate", edate);
		
		
		request.setAttribute("ticketVO", pvo);
		request.getRequestDispatcher("ticketing/ticketShow.jsp").forward(request, response);
		
		

	}

}
