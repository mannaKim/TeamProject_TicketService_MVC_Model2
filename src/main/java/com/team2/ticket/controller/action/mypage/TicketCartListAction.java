package com.team2.ticket.controller.action.mypage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.Ticket_CartDao;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.Ticket_CartVO;
import com.team2.ticket.util.Paging;

public class TicketCartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "mypage/ticketCartList.jsp";  // 최종 목적지
		
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			url = "ticket.do?command=loginForm";
		} else {
			// 로그인 유저의 아이디로 티켓카트 리스트 를 검색해서 리턴
			Ticket_CartDao tcdao = Ticket_CartDao.getInstance();
			
			// 페이징 

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
			
			int count = tcdao.getAllCount( "ticket_cart_view" );
			paging.setTotalCount(count);
		
			
			ArrayList<Ticket_CartVO> list = tcdao.selectCart( mvo.getId(), paging );
			
			request.setAttribute("TicketCartList", list);
			request.setAttribute("paging", paging);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
