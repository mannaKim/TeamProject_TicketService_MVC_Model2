package com.team2.ticket.controller.action.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GCartDao;
import com.team2.ticket.dto.GCartVO;
import com.team2.ticket.dto.MemberVO;

public class GoodsCartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ticket.do?command=goodsCartList";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			url="ticket.do?command=loginForm";
		}else {
			GCartDao gcdao = GCartDao.getInstance();
			String id = mvo.getId();
			System.out.println("gseq:"+request.getParameter("gseq"));
			int gseq = Integer.parseInt(request.getParameter("gseq"));
			System.out.println("수량:"+request.getParameter("quantity"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			//goods_cart 테이블에 처리가 아직 안된(result=='1'인) 동일한 상품이 있다면
			//quantity만 +해주도록 하는 메서드 checkQuantity
			int oldQuantity = gcdao.checkQuantity(id,gseq,quantity);
			//유저 id, 현재 장바구니에 넣을 상품의 gseq, quantity를 매개변수로 전달하여
			//id,gseq가 일치하는 상품은 quantity만 전달된 quantity만큼 +하여 업데이트,
			//일치하는 상품이 없다면 0을 반환, 반환값이 0이라면 아래처럼 insert 명령
			
			if(oldQuantity == 0) {
				GCartVO gcvo = new GCartVO();
				gcvo.setId(id);
				gcvo.setGseq(gseq);
				gcvo.setQuantity(quantity);
				gcdao.insertCart(gcvo);
			} 
		}
		response.sendRedirect(url);
	}

}
