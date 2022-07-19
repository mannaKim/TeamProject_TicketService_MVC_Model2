package com.team2.ticket.controller.action.qna;

import java.io.IOException;
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

public class QnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaList.jsp";
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			url = "ticket.do?command=loginForm";
		} else {
			QnaDao qdao = QnaDao.getInstance();
			Paging paging = new Paging();
			
			int page=1;
			if( request.getParameter("page") != null ) { // 파라미터 page가 있을 때 
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			} else if(session.getAttribute("page") != null) { // 파라미터 페이지가 없고, 세션에 페이지가 있을 때 
				page =(Integer) session.getAttribute("page");
			} else { //파라미터에도 세션에도 페이지가 없을 때
				session.removeAttribute("page"); // 세션에서 페이지 삭제
			}
			paging.setPage(page);
			
			int count = qdao.getAllCount();
			paging.setTotalCount(count);
			ArrayList<QnaVO> list = qdao.listQna( paging);
			// ArrayList<QnaVO> list = qdao.listQna(mvo.getId(), paging);
			// 해당 아이디로 쓴 글만 보이게 하는 경우 위의 것 사용

			String rep = "";
			for( QnaVO qvo:list) {
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

//			QnaVO qvo = qdao.getKind( mvo.getId());
//			String [] kindList = { "전시", "회원안내", "관람/예약", "굿즈", "기타"};
//			int index = Integer.parseInt(qvo.getKind() ); 
//			System.out.println("replycnt : " + qvo.getReplycnt());
			
//			request.setAttribute("rep", rep);
			request.setAttribute("qnalist", list);
//			request.setAttribute("kind", kindList[index]);
			request.setAttribute("paging", paging);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
