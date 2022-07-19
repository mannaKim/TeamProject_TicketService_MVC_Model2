package com.team2.ticket.controller.action.admin.ticket;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

public class Admin_ticketWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		String url = "ticket.do?command=admin_ticketList";
		
		System.out.println("Admin_ticketWriteAction 도착");
		
		HttpSession session = request.getSession();
		//AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		//if( avo == null) { 
		//	url = "ticket.do?command="; 
		//} else {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath("ticket_images");
			
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024,  "UTF-8", new DefaultFileRenamePolicy()
			);
			Ticket_productVO tpvo = new Ticket_productVO();
			
			tpvo.setName( multi.getParameter("name") ); // 이름 
			tpvo.setPrice1( Integer.parseInt( multi.getParameter("price1")) ); // 일반 가격
			tpvo.setPrice2( Integer.parseInt( multi.getParameter("price2")) ); // 어린이 가격
			tpvo.setPrice3( Integer.parseInt( multi.getParameter("price3")) ); // 할인금액
			tpvo.setAge( Integer.parseInt( multi.getParameter("age")) ); // 나이
			tpvo.setShowtime( multi.getParameter("showtime") ); // 나이
			tpvo.setContent( multi.getParameter("content") ); // 컨텐츠 소개
			tpvo.setPlace( multi.getParameter("place") ); // 장소 
			tpvo.setDaytime( multi.getParameter("daytime") ); // 공연시작시간
			tpvo.setSdate( multi.getParameter("sdate") ); // 공연시작 시간
			tpvo.setEdate( multi.getParameter("edate") ); // 공연끝나는 시간
			
			tpvo.setImage( multi.getFilesystemName("image") ); 
			
			Ticket_productDao tpdao = Ticket_productDao.getInstance();
			tpdao.insertProduct(tpvo);
			System.out.println("adao.insertProduct");
			
			
		//}
		response.sendRedirect(url);
	}

	

}
