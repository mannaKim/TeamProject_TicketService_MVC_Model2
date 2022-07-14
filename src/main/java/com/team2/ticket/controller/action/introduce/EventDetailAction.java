package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dto.EventVO;
import com.team2.ticket.dto.ReplyVO;

public class EventDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int evnum = Integer.parseInt(request.getParameter("evnum"));
		
		EventDao edao = EventDao.getInstance();
		
		edao.readCountOne(evnum);
		EventVO evo = edao.getEvent(evnum);

		ArrayList<ReplyVO> rvo = edao.eventReply(evnum);
		request.setAttribute("eventRP", rvo);
		
		
		request.setAttribute("eventVO", evo);
		
		String url = "introduce/eventDetail.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
