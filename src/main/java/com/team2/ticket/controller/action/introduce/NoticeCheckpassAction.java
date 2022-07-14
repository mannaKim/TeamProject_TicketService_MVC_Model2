package com.team2.ticket.controller.action.introduce;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.NoticeDao;
import com.team2.ticket.dto.NoticeVO;

public class NoticeCheckpassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int ntnum = Integer.parseInt(request.getParameter("ntnum"));
		String pass = request.getParameter("pass");
		
		NoticeDao ndao = NoticeDao.getInstance();
		NoticeVO nvo = ndao.selectnotice(ntnum);
		
		String url = null;
		
		if(nvo.getPass() == null) {
			request.setAttribute("message", "비밀번호 오류, 관리자에게 문의하세요");
			url = "introduce/noticecheckForm.jsp";
		} else if(nvo.getPass().equals(pass)) {
			url = "introduce/checkSuccess.jsp";
		} else {
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
			url = "introduce/noticecheckForm.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
