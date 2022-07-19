package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.NoticeVO;
import com.team2.ticket.util.Paging;

public class AdminNoticeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		String url ="admin/introduce/adminNotice.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			url = "ticket.do?command=index";
		} else {
			NoticeDao ndao = NoticeDao.getInstance();
			
			Paging paging = new Paging();
			paging.setDisplayPage(10);
			paging.setDisplayRow(10);
			
			paging.setPage(1);
			// 받아온 page값이 null이 아니면, 받아온 page로 이동하고, session에 저장.
			if(request.getParameter("page") != null) {
				paging.setPage(Integer.parseInt(request.getParameter("page")));
				session.setAttribute("page", Integer.parseInt(request.getParameter("page")));
			} else if(session.getAttribute("page") != null){
				// 기존에 page가 저장되어 있으면, 저장되어있던 page값으로 이동.
				paging.setPage((Integer)session.getAttribute("page"));
			} else {
				// 받아온 page값이 없으면, 1번 페이지 보이게 세팅하고
				// session에 남아있는 page는 삭제.
				paging.setPage(1);
				session.removeAttribute("page");
			}
			
			String key = "";
			if(request.getParameter("key") != null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if(session.getAttribute("key") != null) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
			}
			
			int count = ndao.getNoticeAllCount("notice", key);
			paging.setTotalCount(count);
			
			ArrayList<NoticeVO> noticeList = ndao.listNotice(paging, key);
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
