package com.team2.ticket.controller.action.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GCartDao;
import com.team2.ticket.dao.OrderDao;
import com.team2.ticket.dto.GCartVO;
import com.team2.ticket.dto.MemberVO;

public class GoodsOrderInsertListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="ticket.do?command=loginForm";
		}else {
			//지금 주문 처리할 목록을 먼저 조회합니다
			String [] gcseqArr = request.getParameterValues("gcseq");
			GCartDao gcdao = GCartDao.getInstance();
			ArrayList<GCartVO> list = new ArrayList<GCartVO>();
			for(String gcseq : gcseqArr)
				list.add(gcdao.selectCart(Integer.parseInt(gcseq)));
			
			//추출한 list와 주문자의 아이디를 갖고 OrderDao에 가서 오더와 오더디테일에 데이터 추가
			OrderDao odao = OrderDao.getInstance();
			//주문 추가 후 추가한 주문의 주문번호를 리턴받습니다.
			int oseq = odao.insertOrder(list, mvo.getId());
			
			//방금 주문에 성공한 주문번호를 갖고 오더리스트로 이동하여 주문번호로 주문내역을 다시 조회
			url = "ticket.do?command=goodsOrderList&oseq="+oseq;
		}
		response.sendRedirect(url);
	}

}
