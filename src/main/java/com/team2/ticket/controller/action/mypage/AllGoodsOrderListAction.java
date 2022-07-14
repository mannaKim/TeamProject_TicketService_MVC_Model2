package com.team2.ticket.controller.action.mypage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.OrderDao;
import com.team2.ticket.dto.GOrderVO;
import com.team2.ticket.dto.MemberVO;

public class AllGoodsOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String url = "mypage/allGoodsOrderList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url = "ticket.do?command=loginForm";
		}else {
			OrderDao odao = OrderDao.getInstance();
			
			//메서드의 리턴값이 될 list
			ArrayList<GOrderVO> list = new ArrayList<GOrderVO>();
			
			//주문번호들의 리스트(중복을 없앤)
			ArrayList<Integer> oseqList = odao.selectOseqList(mvo.getId());
			for(Integer oseq : oseqList) {
				//주문번호에 해당하는 상품 리스트를 리턴받음
				ArrayList<GOrderVO> orderListByOseq = odao.selectOrderList(oseq);
				//리턴된 리스트의 첫번째 상품을 govo로 저장
				GOrderVO govo = orderListByOseq.get(0); 
				
				//govo의 이름을 '[현재상품의 상품명] 외 n건' 으로 변경
				if(orderListByOseq.size()>1) {
					govo.setGname(govo.getGname()+" 외 "+(orderListByOseq.size()-1)+"건");
				}
				//주문 총 금액을 계산
				int totalPrice = 0;
				for(GOrderVO order : orderListByOseq)
					totalPrice += order.getPrice()*order.getQuantity();
				//계산한 총 금액을 govo의 price에 저장
				govo.setPrice(totalPrice);
				
				//모든 변경을 마친 govo를 리턴될 list에 add.
				list.add(govo);
			}
			request.setAttribute("allGoodsOrderList", list);
			request.setAttribute("title", mvo.getName()+"님의 주문 내역");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
