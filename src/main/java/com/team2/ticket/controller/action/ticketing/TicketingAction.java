package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

public class TicketingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		int tpseq =  Integer.parseInt(request.getParameter("tpseq"));
		int quantity1 = Integer.parseInt(request.getParameter("quantity1"));
		int quantity2 = Integer.parseInt(request.getParameter("quantity2"));
		String chioceDay = request.getParameter("choisDay");
		
		Ticket_CartDao tcdao = Ticket_CartDao.getInstance();
		Ticket_CartVO tcvo = new Ticket_CartVO();
		
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String url = "ticketing/ticketing.jsp";
					    
		if(loginUser == null) {
			url = "ticket.do?command=loginForm";
		} else {
			Ticket_productDao tpdao = Ticket_productDao.getInstance();
			Ticket_productVO tpvo = tpdao.getTProduct( tpseq );
			
			ArrayList<Ticket_productVO> plist = tpdao.plistTicket( tpseq );
			
			System.out.println(tpseq + " = tpseq 값");
			System.out.println(quantity1 + " = quantity1 값" );
			System.out.println(quantity2 + " = quantity2 값" );
			System.out.println(loginUser.getId() + " = loginUser.getId() 값"  );
			
			tcdao.insertOrder(tpseq, chioceDay, quantity1, quantity2, loginUser.getId() );
			
			System.out.println( "sql 등록성공 ? ");
			
			ArrayList<Ticket_CartVO> tclist = tcdao.tclistTicket(tpseq);
			
			System.out.println( "Ticket_CartVO 리스트 불러오기 ? ");
			
			int totalPrice1 = 0;
			int totalPrice2 = 0;
			for( Ticket_productVO ptvo:plist) 
				totalPrice1 += ( ptvo.getPrice1() * quantity1 );
			
			for( Ticket_productVO ptvo:plist) 
				totalPrice2 += ( ptvo.getPrice2() * quantity2);
			
			int totalPrice3 = totalPrice1 + totalPrice2;
			int selecttotal = quantity1 + quantity2;
			
			request.setAttribute("totalPrice1", totalPrice1);
			request.setAttribute("totalPrice2", totalPrice2);
			request.setAttribute("totalPrice3", totalPrice3);
			request.setAttribute("selecttotal", selecttotal);
			
			request.setAttribute("chioceDay", chioceDay);
			request.setAttribute("ticket_productVO", tpvo);
			request.setAttribute("Ticket_CartVO", tclist);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
