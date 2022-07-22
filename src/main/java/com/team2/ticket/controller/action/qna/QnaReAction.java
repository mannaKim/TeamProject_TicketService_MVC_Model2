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

public class QnaReAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaMy.jsp";
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
			
			int count = qdao.getAllCount(mvo.getId());
			paging.setTotalCount(count);
			ArrayList<QnaVO> list = qdao.listQna(mvo.getId(), paging);

//			String [] kindList = { "전시", "회원안내", "관람/예약", "굿즈", "기타"};

			
			System.out.println("실행 확인");
			
//			request.setAttribute("rep", rep);
			request.setAttribute("qnalist", list);
//			request.setAttribute("kind", kindList[index]);
			request.setAttribute("paging", paging);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
