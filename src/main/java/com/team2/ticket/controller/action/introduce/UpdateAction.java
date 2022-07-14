package com.team2.ticket.controller.action.introduce;

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

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("ticket_image");
		String evnum = "";
		EventVO evo = new EventVO();
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 20*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
					);
			
			evnum = multi.getParameter("evnum");
			evo.setEvnum(Integer.parseInt(evnum));
			evo.setEtitle(multi.getParameter("etitle"));
			evo.setEvdate(multi.getParameter("evdate"));
			evo.setEvperson(multi.getParameter("evperson"));
			
			if(multi.getFilesystemName("eimage") == null) {
				evo.setEimage(multi.getParameter("oldPicture1"));
			} else {
				evo.setEimage(multi.getFilesystemName("eimage"));
			}
			
			if(multi.getFilesystemName("eimage2") == null) {
				evo.setEimage2(multi.getParameter("oldPicture2"));
			} else {
				evo.setEimage2(multi.getFilesystemName("eimage2"));
			}
			
			EventDao edao = EventDao.getInstance();
			edao.updateEvent(evo);
		} catch(Exception e) {
			System.out.println("파일 업로드 실패 : " + e);
		}
		
		String url = "ticket.do?command=eventDetail&evnum=" + evnum;
		request.getRequestDispatcher(url).forward(request, response);

	}

}
