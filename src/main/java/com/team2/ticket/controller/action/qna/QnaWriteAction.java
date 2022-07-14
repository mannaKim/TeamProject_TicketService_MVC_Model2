package com.team2.ticket.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.QnaDao;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "ticket.do?command=qna"; // 목적지는  qnaList
		
		HttpSession session = request.getSession();
	    MemberVO mvo = (MemberVO) session.getAttribute("loginUser"); 
	    if (mvo == null) {
	    	url = "ticket.do?command=index";
	    }else{
	    	QnaVO qvo = new QnaVO();
	    	qvo.setSubject(request.getParameter("subject"));
	    	qvo.setContent(request.getParameter("content"));
	    	qvo.setKind(request.getParameter("kind"));
	    	qvo.setId( mvo.getId() );
	    	QnaDao qdao = QnaDao.getInstance();
	    	qdao.insertQna(qvo);
	    }
	    response.sendRedirect(url);
	}

}
