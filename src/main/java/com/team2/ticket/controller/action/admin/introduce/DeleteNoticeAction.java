package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;

public class DeleteNoticeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ntnum = Integer.parseInt(request.getParameter("ntnum"));
		
		NoticeDao ndao = NoticeDao.getInstance();
		ndao.delectNotice(ntnum);
		
		request.getRequestDispatcher("ticket.do?command=adminNotice").forward(request, response);
	}

}
