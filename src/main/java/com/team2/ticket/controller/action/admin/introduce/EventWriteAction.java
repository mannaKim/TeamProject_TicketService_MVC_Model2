package com.team2.ticket.controller.action.admin.introduce;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.EventDao;
import com.team2.ticket.dto.EventVO;
import com.team2.ticket.dto.MemberVO;

public class EventWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "ticket.do?command=adminEvent";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			url = "ticket.do?command=index";
		} else {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath("ticket_image");
			
			MultipartRequest multi = new MultipartRequest(
				request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
					);
			EventVO evo = new EventVO();
			evo.setId(multi.getParameter("id"));
			evo.setEimage(multi.getFilesystemName("eimage"));
			evo.setEimage2(multi.getFilesystemName("eimage2"));
			evo.setTitle(multi.getParameter("title"));
			evo.setEvdate(multi.getParameter("evdate"));
			evo.setEvperson(multi.getParameter("evperson"));
			
			EventDao edao = EventDao.getInstance();
			edao.insertEvent(evo);
		}
		
		response.sendRedirect(url);
		

	}

}
