package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_CartDao;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.Ticket_CartVO;
import com.team2.ticket.dto.Ticket_productVO;

public class TicketingCartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		String url = "ticketing/ticketingCartList.jsp";  // 최종 목적지
		
		
		int tpseq = Integer.parseInt( request.getParameter("tpseq") );
		String choisDay = request.getParameter("choisDay");
		System.out.println(choisDay);
		
		int quantity1 = Integer.parseInt(request.getParameter("quantity1"));
		int quantity2 = Integer.parseInt(request.getParameter("quantity2"));
		
		/*
		if( quantity1 == 0 && quantity2 == 0){ 
			request.setAttribute("message","티켓 수량을 먼저 선택 해주세요.");
			url = "ticket.do?command=ticketingCart"; 
		}
		*/
		
		System.out.println(tpseq + " = tpseq 값");
		System.out.println(quantity1);
		System.out.println(quantity2);
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			url = "ticket.do?command=loginForm";
		} else {
			Ticket_productDao tpdao = Ticket_productDao.getInstance();
			Ticket_productVO tpvo = tpdao.getTProduct( tpseq );
			ArrayList<Ticket_productVO> list = tpdao.selectCart( tpseq );
			
			
			int totalPrice1 = 0;
			int totalPrice2 = 0;
			for( Ticket_productVO ptvo:list) 
				totalPrice1 += ( ptvo.getPrice1() * quantity1 );
			
			for( Ticket_productVO ptvo:list) 
				totalPrice2 += ( ptvo.getPrice2() * quantity2 );
			
			int totalPrice3 = totalPrice1 + totalPrice2;
			int selecttotal = quantity1 + quantity2;
			
			request.setAttribute("quantity1", quantity1);
			request.setAttribute("quantity2", quantity2);
			request.setAttribute("selecttotal", selecttotal);
			
			request.setAttribute("totalPrice1", totalPrice1);
			request.setAttribute("totalPrice2", totalPrice2);
			request.setAttribute("totalPrice3", totalPrice3);
			
			request.setAttribute("ticket_productVO", tpvo);
			request.setAttribute("choisDay", choisDay);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
