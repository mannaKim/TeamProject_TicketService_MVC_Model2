package com.team2.ticket.controller.action.qna;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;

public class QnaFnqAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		String url = "qna/qnafnq.jsp";
		
		int kind = Integer.parseInt( request.getParameter("kind") );
		System.out.println("kind = " + kind);
		if(kind==1) {
			// 전체 fnq 보기
		}else if(kind==2) {
			url = "qna/qnafnq2.jsp";
			// "전시"
		}else if(kind==3) {
			url = "qna/qnafnq3.jsp";
			// "회원안내"
		}else if(kind==4) {
			url = "qna/qnafnq4.jsp";
			// "관람/예약"
		} else {
			url = "qna/qnafnq5.jsp";
			// "굿즈"
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
