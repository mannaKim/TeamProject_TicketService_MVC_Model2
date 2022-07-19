package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.NoticeVO;

public class UpdateNoticeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao ndao = NoticeDao.getInstance();
		NoticeVO nvo = new NoticeVO();
		
		nvo.setContent(request.getParameter("content"));
		nvo.setId(request.getParameter("id"));
		nvo.setNtnum(Integer.parseInt(request.getParameter("ntnum")));
		nvo.setPass(request.getParameter("pass"));
		nvo.setTitle(request.getParameter("title"));
		
		ndao.updateNotice(nvo);
		
		String url = "ticket.do?command=noticeViewNoCount&ntnum=" + nvo.getNtnum();
		request.getRequestDispatcher(url).forward(request, response);

	}

}
