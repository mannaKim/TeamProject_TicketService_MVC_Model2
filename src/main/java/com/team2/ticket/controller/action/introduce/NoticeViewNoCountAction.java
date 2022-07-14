package com.team2.ticket.controller.action.introduce;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.NoticeVO;

public class NoticeViewNoCountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ntnum = Integer.parseInt(request.getParameter("ntnum"));
		
		NoticeDao ndao = NoticeDao.getInstance();
		NoticeVO nvo = ndao.selectnotice(ntnum);
		
		request.setAttribute("notice", nvo);
		
		request.getRequestDispatcher("introduce/noticeView.jsp").forward(request, response);
	}

}
