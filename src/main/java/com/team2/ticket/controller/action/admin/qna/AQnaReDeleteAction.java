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
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.QnaVO;
import com.team2.ticket.dto.QreplyVO;

public class AQnaReDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "ticket.do?command=aqnaView";
		
		int renum = Integer.parseInt( request.getParameter("renum") );
		int qnanum = Integer.parseInt( request.getParameter("qseq") );
		
		// QnaDao 에 추가될 메서드 이름 getQna
		HttpSession session = request.getSession();
	    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	    
	    if (mvo == null) {
	        url = "ticket.do?command=loginForm";
	    } else {	
	    	QnaDao qdao = QnaDao.getInstance();
	    	QnaVO qvo = qdao.getQna( qnanum );
	    	qdao.deleteReply(renum);
	    	System.out.println("수정 확인");
	    	ArrayList<QreplyVO> list  = qdao.selectReply( qnanum );
			request.setAttribute("replylist", list);  
	    }
		request.getRequestDispatcher(url).forward(request, response);

}

}
