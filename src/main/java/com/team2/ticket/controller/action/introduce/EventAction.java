package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dto.EventVO;

public class EventAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventDao edao = EventDao.getInstance();
		ArrayList<EventVO> evo = edao.getEventList();
		
		request.setAttribute("event", evo);
		request.getRequestDispatcher("introduce/eventForm.jsp").forward(request, response);

	}

}
