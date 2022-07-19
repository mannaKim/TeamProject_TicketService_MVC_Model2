package com.team2.ticket.controller.action.admin.qna;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dao.QnaDao;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.QnaVO;
import com.team2.ticket.util.Paging;

public class AQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
			String url = "admin/qna/aqnalist.jsp";  // 변경
			
			HttpSession session = request.getSession();
			MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
			
			if( mvo == null ) url = "ticket.do?command=loginForm"; 
			else if(mvo.getAdmin() != 1) { 
				url = "ticket.do?command=loginForm";
			} else {
				QnaDao qdao = QnaDao.getInstance();
				
				Paging paging = new Paging();
				paging.setDisplayPage(10);
				paging.setDisplayRow(10);
				
				if( request.getParameter("page")!=null) {
					paging.setPage( Integer.parseInt( request.getParameter("page") ) );
					session.setAttribute("page", Integer.parseInt( request.getParameter("page") ) );
				} else if( session.getAttribute("page") != null ) {
					paging.setPage( (Integer)session.getAttribute("page") );
				} else {
					paging.setPage(1);
					session.removeAttribute("page");
				}
				
//				int count = mdao.getAllCount(); // 변경. 검색 기능을 넣을거면 key를 쓰고 아니라면 아무것도 넣지 말기
//				paging.setTotalCount(count);
	
				int count = qdao.getAllCount();
				paging.setTotalCount(count);
				ArrayList<QnaVO> qnaList = qdao.listQna( paging);
				
				String rep = "";
				for( QnaVO qvo:qnaList) {
					System.out.println("getQseq : "+ qvo.getQseq());
					count = qdao.getReplycnt( qvo.getQseq() );
					qvo.setReplycnt( count );

					System.out.println("replycnt : " + qvo.getReplycnt());
					if (qvo.getReplycnt() == 0) {
						rep = "1";
					} else {
						rep = "2";
					}
					qvo.setRep(rep);
					System.out.println("rep : " + qvo.getRep());
				}
				
				request.setAttribute("qnalist", qnaList);  // 변경
				request.setAttribute("paging", paging);
			}
			request.getRequestDispatcher(url).forward(request, response);

	}

}
