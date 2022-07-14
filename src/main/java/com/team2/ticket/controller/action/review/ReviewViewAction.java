package com.team2.ticket.controller.action.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;

public class ReviewViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaView.jsp";
		int qseq = Integer.parseInt( request.getParameter("qseq") );
		
//		HttpSession session = request.getSession();
//	    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
//	    if (mvo == null) {
//	        url = "shop.do?command=loginForm";
//	    } else {	
//	    	ReviewDao qdao = ReviewDao.getInstance();
//	    	ReviewVO qvo = qdao.getQna( qseq );
//	    	request.setAttribute("qnaVO", qvo);
//	    }
//		request.getRequestDispatcher(url).forward(request, response);
//	}

	}

}
