package com.team2.ticket.controller.action.admin;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;

public class EditAdminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
	
		String id = request.getParameter("id");
		String admin = request.getParameter("admin");
		
		if(admin.equals("1")) {
			admin = "0";
		} else {
			admin = "1";
		}
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.adminMember(id, admin);
		
		String url = "ticket.do?command=adminCheck";
		request.getRequestDispatcher(url).forward(request, response);
		
	
		
		

	}

}
