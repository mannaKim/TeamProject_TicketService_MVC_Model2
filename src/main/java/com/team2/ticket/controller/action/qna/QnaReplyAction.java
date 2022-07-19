package com.team2.ticket.controller.action.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.QnaDao;
import com.team2.ticket.dto.QreplyVO;

public class QnaReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		QreplyVO qrvo = new QreplyVO();

		int qnanum = Integer.parseInt( request.getParameter("qnanum") );
		
		qrvo.setId(request.getParameter("id"));
		qrvo.setContent(request.getParameter("content"));
		qrvo.setQnanum( qnanum );
		System.out.println(qnanum);
		
		QnaDao qdao = QnaDao.getInstance();
		qdao.insertReply(qrvo);

		// 게시물 번호와 함께 view로 전송
		response.sendRedirect("ticket.do?command=aqnaReView&qnanum="+qnanum);
	
	}

}
