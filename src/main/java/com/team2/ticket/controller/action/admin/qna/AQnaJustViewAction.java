package com.team2.ticket.controller.action.admin.qna;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.QnaDao;
import com.team2.ticket.dao.Ticket_productDao;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.QnaVO;
import com.team2.ticket.dto.QreplyVO;

public class AQnaJustViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
			String url = "admin/qna/aqnaView.jsp";
			int qnanum = Integer.parseInt( request.getParameter("qseq") );
			System.out.println("qnanum = " + qnanum);
			
			// QnaDao 에 추가될 메서드 이름 getQna
			HttpSession session = request.getSession();
		    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		    if (mvo == null) {
		        url = "ticket.do?command=loginForm";
		    } else {	
		    	QnaDao qdao = QnaDao.getInstance();
		    	QnaVO qvo = qdao.getQna( qnanum );
		    	System.out.println("content test"+qvo.getContent());
		    	
		    	ArrayList<QreplyVO> list  = qdao.selectReply( qnanum );
				request.setAttribute("replylist", list);  
		    	
	//			String [] kindList = { "전시", "회원안내", "관람/예약", "굿즈", "기타"};
	//			int index = Integer.parseInt( qvo.getKind() ); 
	//			request.setAttribute("kind", kindList[index]);
				System.out.println("getKind = " + qvo.getKind());
		    	request.setAttribute("qnaVO", qvo);
		    }
			request.getRequestDispatcher(url).forward(request, response);

	}

}
