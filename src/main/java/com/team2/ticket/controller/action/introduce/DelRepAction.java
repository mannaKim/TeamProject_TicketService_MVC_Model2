package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;

public class DelRepAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String replynum = request.getParameter("replynum");
		String evnum = request.getParameter("evnum");
		
		EventDao edao = EventDao.getInstance();
		edao.deleteReply(replynum);
		
		String url = "ticket.do?command=eventDetailNoCount&evnum=" + evnum;
		request.getRequestDispatcher(url).forward(request, response);
	}

}
