package com.team2.ticket.controller.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.MemberDao;
import com.team2.ticket.dto.AddressVO;

public class FindAddressAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dong=request.getParameter("dong");
		if(dong!=null) {
			//주소 검색 후 결과 list를 request에 담습니다.
			if(dong.equals("")==false) {
				MemberDao mdao = MemberDao.getInstance();
				ArrayList<AddressVO> list = mdao.selectAddress(dong);
				request.setAttribute("addressList", list);
			}
		}
		String url = "member/findAddress.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
