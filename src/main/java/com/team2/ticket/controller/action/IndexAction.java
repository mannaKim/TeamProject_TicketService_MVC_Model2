package com.team2.ticket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.GoodsVO;
import com.team2.ticket.dto.Ticket_productVO;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. main에 띄울 굿즈 정보 request에 담기
		GoodsDao gdao = GoodsDao.getInstance();
		//ArrayList<GoodsVO> goodsList = gdao.getGoodsList();
		//request.setAttribute("goodsList", goodsList);
		
		//2. main에 띄울 전시 정보 request에 담기
		Ticket_productDao tdao = Ticket_productDao.getInstance();
		ArrayList<Ticket_productVO> ticketList = tdao.getTicketList();
		request.setAttribute("ticketList", ticketList);

		//main.jsp로 이동
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
