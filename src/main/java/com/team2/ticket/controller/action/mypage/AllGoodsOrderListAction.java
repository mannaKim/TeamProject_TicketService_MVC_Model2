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
import com.team2.ticket.util.Paging;

public class AllGoodsOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String url = "mypage/allGoodsOrderList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url = "ticket.do?command=loginForm";
		}else {
			Paging paging = new Paging();
			paging.setDisplayPage(5);
			paging.setDisplayRow(5);
			if(request.getParameter("page")!=null) {
				paging.setPage(Integer.parseInt(request.getParameter("page")));
				session.setAttribute("page",Integer.parseInt(request.getParameter("page")));
			}else if(session.getAttribute("page")!=null) {
				paging.setPage((Integer)session.getAttribute("page"));
			}else {
				paging.setPage(1);
				session.removeAttribute("page");
			}
			
			OrderDao odao = OrderDao.getInstance();
			//메서드의 리턴값이 될 list
			ArrayList<GOrderVO> list = new ArrayList<GOrderVO>();
			
			//paging의 setTotalCount를 위해 전체 oseq를 가져옴
			ArrayList<Integer> oseqListForPaging = odao.selectOseqList(mvo.getId());
			int count = oseqListForPaging.size();
			paging.setTotalCount(count);
			//출력될 만큼만 oseq를 가져옴
			ArrayList<Integer> oseqList = odao.selectOseqList(mvo.getId(),paging);
			
			//회원마다 본인의 주문내역 개수에 맞춰 주문번호 적용
			int orderNum = oseqListForPaging.size()-((paging.getPage()-1)*paging.getDisplayRow());
			
			for(Integer oseq : oseqList) {
				//주문번호에 해당하는 상품 리스트를 리턴받음
				ArrayList<GOrderVO> orderListByOseq = odao.selectOrderList(oseq);
				//리턴된 리스트의 첫번째 상품을 govo로 저장
				GOrderVO govo = orderListByOseq.get(0); 
				
				//주문번호 - oseq는 orderDetail로 이동하기 위해 필요하므로, odseq에 저장
				govo.setOdseq(orderNum);
				orderNum--;
				
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
			request.setAttribute("paging", paging);
			request.setAttribute("title", mvo.getName()+"님의 주문 내역");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
