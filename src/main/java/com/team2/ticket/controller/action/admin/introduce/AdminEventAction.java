package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dto.EventVO;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.util.Paging;

public class AdminEventAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "admin/introduce/adminEventForm.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			url = "ticket.do?command=index";
		} else {
			EventDao edao = EventDao.getInstance();
			
			Paging paging = new Paging();
			paging.setDisplayPage(10);
			paging.setDisplayRow(10);
			
			paging.setPage(1);
			if(request.getParameter("page") != null) {
				paging.setPage(Integer.parseInt(request.getParameter("page")));
				session.setAttribute("page", Integer.parseInt(request.getParameter("page")));
			} else if(session.getAttribute("page") != null) {
				paging.setPage((Integer)session.getAttribute("page"));
			} else {
				paging.setPage(1);
				session.getAttribute("page");
			}
			
			
			int count = edao.getEventAllCount("event");
			paging.setTotalCount(count);
			
			ArrayList<EventVO> eventList = edao.listEvent(paging);
			request.setAttribute("eventList", eventList);
			request.setAttribute("paging", paging);
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
