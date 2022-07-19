package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.NoticeVO;
import com.team2.ticket.util.Paging;

public class NoticeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao ndao = NoticeDao.getInstance();
		
		int p = 1;
		if(request.getParameter("page") != null ) {
			p = Integer.parseInt(request.getParameter("page"));
		}
		Paging paging = new Paging();
		paging.setPage(p);
		
		int count = ndao.getAllCount();
		paging.setTotalCount(count);
		
		ArrayList<NoticeVO> nlist = ndao.selectnotice(paging);
		request.setAttribute("paging", paging);
		
		request.setAttribute("noList", nlist);
		request.getRequestDispatcher("introduce/noticeForm.jsp").forward(request, response);

	}

}
