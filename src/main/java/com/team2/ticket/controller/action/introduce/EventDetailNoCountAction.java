package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dto.EventVO;
import com.team2.ticket.dto.ReplyVO;

public class EventDetailNoCountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
	
		int evnum = Integer.parseInt(request.getParameter("evnum"));
		
		EventDao edao = EventDao.getInstance();
		EventVO evo = edao.getEvent(evnum);
		
		ArrayList<ReplyVO> rvo = edao.eventReply(evnum);
		
		request.setAttribute("eventRP", rvo);
		
		request.setAttribute("eventVO", evo);
		request.getRequestDispatcher("introduce/eventDetail.jsp").forward(request, response);
	}

}
