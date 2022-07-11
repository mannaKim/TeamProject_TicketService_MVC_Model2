package com.team2.ticket.controller.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.ticket.controller.action.Action;

public class MypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//최근 예매내역(3개월 동안의 구매내역 --> 뷰생성)
		//최근 구매내역(3개월 동안의 구매내역 --> 뷰생성)
		//회원 등급 정보? --> 최근 삼개월간 얼마 이상 구매시 무슨 등급
		String url = "mypage/mypage.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
