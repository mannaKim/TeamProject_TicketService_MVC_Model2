package com.team2.ticket.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.QnaVO;

public class QnaWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaWrite.jsp";		
		HttpSession session = request.getSession();
	    MemberVO mvo= (MemberVO) session.getAttribute("loginUser"); 
//	    QnaVO qvo = new QnaVO();
	    if (mvo == null)
	    	url = "ticket.do?command=loginForm";	 
	    else  {
	    	
			String [] kindList = {"전시", "회원안내", "관람/예약", "굿즈", "기타"};
//			int index = Integer.parseInt( qvo.getKind() ); 

			request.setAttribute("kindList", kindList);
	    }
	    	
	    request.getRequestDispatcher(url).forward(request, response);

	}

}
