package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.NoticeVO;

public class AdminNoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		int ntnum = Integer.parseInt(request.getParameter("ntnum"));
		
		NoticeDao ndao = NoticeDao.getInstance();
		
		NoticeVO nvo = ndao.selectnotice(ntnum);
		
		
		request.setAttribute("notice", nvo);
		request.getRequestDispatcher("admin/introduce/adminNoticeView.jsp").forward(request, response);

	}

}
