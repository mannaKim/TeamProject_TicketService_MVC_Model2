package com.team2.ticket.controller.action.introduce;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.IntroduceDao;
import com.team2.ticket.dto.IntroduceVO;

public class IntroduceAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntroduceDao idao = IntroduceDao.getInstance();
		ArrayList<IntroduceVO> ivlist = idao.selectIntroduce();
		
		request.setAttribute("itList", ivlist);
		request.getRequestDispatcher("introduce/introduceForm.jsp").forward(request, response);
	}

}
