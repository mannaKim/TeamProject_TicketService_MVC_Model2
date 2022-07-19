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
		String choisDay = request.getParameter("choisDay");
		Ticket_CartDao tcdao = Ticket_CartDao.getInstance();
		//Ticket_CartVO tcvo = new Ticket_CartVO();
		int selectevent = Integer.parseInt(request.getParameter("selectevent")); // select 값  
		System.out.println(selectevent+" = selectevent값");
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
			
			tcdao.insertOrder(tpseq, choisDay, quantity1, quantity2, loginUser.getId() );
			
			System.out.println( "sql 등록성공 ? ");
			
			ArrayList<Ticket_CartVO> tclist = tcdao.tclistTicket(tpseq);
			
			System.out.println( "Ticket_CartVO 리스트 불러오기 ? ");
			
			int totalPrice1 = 0; // 어른 티켓 * 표값
			for( Ticket_productVO ptvo:plist) 
				totalPrice1 += ( ptvo.getPrice1() * quantity1 );
			
			int totalPrice2 = 0; // 어린이 티켓 * 표값
			for( Ticket_productVO ptvo:plist) 
				totalPrice2 += ( ptvo.getPrice2() * quantity2);
			
			int totalPrice3 = totalPrice1 + totalPrice2; // 어른 + 어린이 표값
			int selecttotal = quantity1 + quantity2; // 어른+어린이 티켓수
			
			int setotal = totalPrice3 - selectevent;
			
			request.setAttribute("totalPrice1", totalPrice1); // 어른 티켓 * 표값 
			request.setAttribute("totalPrice2", totalPrice2); // 어린이 티켓 * 표값
			request.setAttribute("totalPrice3", totalPrice3); // 어른 + 어린이 표값
			request.setAttribute("selecttotal", selecttotal); // 총 구매 티켓 수 ( 어른+어린이 티켓수 )
			request.setAttribute("selectevent", selectevent); // 셀렉값 (이전페이지 이벤트값)
			request.setAttribute("setotal", setotal); // 총 구매티켓 - 셀렉값 
			
			request.setAttribute("choisDay", choisDay); // 선택날짜
			request.setAttribute("ticket_productVO", tpvo);
			request.setAttribute("Ticket_CartVO", tclist);
			
			request.setAttribute("quantity1", quantity1);
			request.setAttribute("quantity2", quantity2);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
