package com.team2.ticket.controller.action.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;

public class GoodsMainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//굿즈 정보 리쿼스트에 담아가기
		
		
		request.getRequestDispatcher("goods/goodsMain.jsp").forward(request, response);

	}

}
