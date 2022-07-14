package com.team2.ticket.controller.action.ticketing;

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
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.Ticket_productVO;

public class TicketShowUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("ticket_image");
		String tpseq = "";
		Ticket_productVO pvo = new Ticket_productVO();
		//try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 20*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
					);
			tpseq = multi.getParameter("tpseq");
			pvo.setTpseq(Integer.parseInt(tpseq));
			pvo.setName(multi.getParameter("name"));
			pvo.setDaytime(multi.getParameter("daytime"));
			pvo.setPlace(multi.getParameter("place"));
			pvo.setAge(Integer.parseInt(multi.getParameter("age")));
			pvo.setShowtime(multi.getParameter("showtime"));
			pvo.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			pvo.setPrice2(Integer.parseInt(multi.getParameter("price2")));
			pvo.setContent(multi.getParameter("content"));
			
			if(multi.getFilesystemName("image") == null) {
				pvo.setImage(multi.getParameter("oldPicture"));
			} else {
				pvo.setImage(multi.getFilesystemName("image"));
			}
			
			Ticket_productDao pdao = Ticket_productDao.getInstance();
			pdao.updateShow(pvo);
//		} catch(Exception e) {
//			System.out.println("파일 업로드 실패 : " + e);
//		}
		
		String url = "ticket.do?command=ticketshow&tpseq=" + tpseq;
		request.getRequestDispatcher(url).forward(request, response);

	}

}
