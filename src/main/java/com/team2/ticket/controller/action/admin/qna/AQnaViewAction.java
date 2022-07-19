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

public class AQnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
			String url = "admin/qna/aqnaView.jsp";
			
			int qnanum = Integer.parseInt( request.getParameter("qnanum") );
			
			QnaDao qdao = QnaDao.getInstance();
			
			// QnaDao 에 추가될 메서드 이름 getQna
			HttpSession session = request.getSession();
		    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		    
		    if (mvo == null) {
		        url = "ticket.do?command=loginForm";
		    } else {	
		    	
		    	//QnaVO qvo = qdao.getQna( qseq );
	//			QreplyVO qrvo = new QreplyVO();
	//			qrvo.setId(request.getParameter("id"));
	//			qrvo.setContent(request.getParameter("content"));
	//			qrvo.setBoardnum( qseq );
	//	    	
	//	    	request.setAttribute("qnaVO", qvo);
	//	    	qdao.insertReply(qrvo);
		    	
		    	QnaVO qvo = qdao.getQna( qnanum );
		    	request.setAttribute("qnaVO", qvo);
		    	
		    	ArrayList<QreplyVO> list  = qdao.selectReply( qnanum );
				request.setAttribute("replylist", list); 
				//request.setAttribute("id", mvo.getId());
		
		    }
			request.getRequestDispatcher(url).forward(request, response);

	}

}
