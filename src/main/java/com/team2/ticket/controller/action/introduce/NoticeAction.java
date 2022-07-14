package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.NoticeVO;

public class NoticeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao ndao = NoticeDao.getInstance();
		ArrayList<NoticeVO> nlist = ndao.selectnotice();
		
		request.setAttribute("noList", nlist);
		request.getRequestDispatcher("introduce/noticeForm.jsp").forward(request, response);

	}

}
