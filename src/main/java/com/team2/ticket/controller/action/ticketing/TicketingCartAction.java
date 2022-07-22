package com.team2.ticket.controller.action.ticketing;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.Ticket_productVO;

public class TicketingCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		System.out.println(" TicketingCartAction 도착 ");
		String url = "ticketing/ticketingCart.jsp";
		// String tpseq = request.getParameter("tpseq");
		// System.out.println(tpseq);
		int tpseq = Integer.parseInt(request.getParameter("tpseq"));
		String choisDay = request.getParameter("selectedDate");

		SimpleDateFormat simpl = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpl.parse(choisDay);

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if (mvo == null) {
			url = "ticket.do?command=loginForm";
		} else {
			Ticket_productDao tpdao = Ticket_productDao.getInstance();
			Ticket_productVO tpvo = tpdao.getchoisDay(tpseq);

			// 문자열 date 타입으로 형변환... 
			String dates = tpvo.getSdate();
			String datee = tpvo.getEdate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date sdate = sdf.parse(dates);
			Date edate = sdf.parse(datee);
			
			request.setAttribute("sdate", sdate);
			request.setAttribute("edate", edate);
			
			
			Date c1 = sdate; // 시작날짜
			Date c2 = edate; // 마지막날짜
			Date c3 = date; // 선택날짜

			int sday = c1.compareTo(c3);
			int eday = c2.compareTo(c3);

			// 기간 체크.
			if (sday <= 0 && eday >= 0) {
				url = "ticketing/ticketingCart.jsp";
			} else {
				request.setAttribute("message", "기간 확인 후 날짜를 다시 선택해주세요.");
				url = "ticket.do?command=ticketingForm";
			}

			request.setAttribute("ticket_productVO", tpvo);
			request.setAttribute("choisDay", choisDay);

		}

		// System.out.println("TicketingCart 마지막단");
		request.getRequestDispatcher(url).forward(request, response);

	}

}
