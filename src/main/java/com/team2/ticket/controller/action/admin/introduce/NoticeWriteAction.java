package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.NoticeVO;

public class NoticeWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		NoticeDao ndao = NoticeDao.getInstance();
		NoticeVO nvo = new NoticeVO();
		
		nvo.setId(request.getParameter("id"));
		nvo.setPass(request.getParameter("pass"));
		nvo.setTitle(request.getParameter("title"));
		nvo.setContent(request.getParameter("content"));
		
		ndao.noticeInsert(nvo);
		
		response.sendRedirect("ticket.do?command=adminNotice");

	}

}
