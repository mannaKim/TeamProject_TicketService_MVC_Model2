package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dto.ReplyVO;

public class EventReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		ReplyVO rvo = new ReplyVO();
		
		int evnum = Integer.parseInt(request.getParameter("evnum"));
		
		rvo.setId(request.getParameter("id"));
		rvo.setContent(request.getParameter("reply"));
		rvo.setRate(Integer.parseInt(request.getParameter("rate")));
		rvo.setEvnum(evnum);
		
		EventDao edao = EventDao.getInstance();
		edao.insertReply(rvo);
		
		request.getRequestDispatcher("ticket.do?command=eventReplyWitout&evnum=" + evnum).forward(request, response);

	}

}
