package com.team2.ticket.controller.action.admin.goods;

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

public class AdminGoodsOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "admin/goods/goodsOrderList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null || mvo.getAdmin()!=1) {
			url="ticket.do?command=loginForm";
		}else {
			//페이징
			Paging paging = new Paging();
			paging.setDisplayPage(5);
			paging.setDisplayRow(10);
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
			//결과를 담을 list 선언
			ArrayList<GOrderVO> list = new ArrayList<GOrderVO>();
			
			//paging의 setTotalCount를 위해 전체 oseq를 가져옴
			ArrayList<Integer> oseqListForPaging = odao.selectAllOseqList();
			int count = oseqListForPaging.size();
			paging.setTotalCount(count);
			//출력될 만큼만 oseq를 가져옴
			ArrayList<Integer> oseqList = odao.selectAllOseqList(paging);
			
			//각 order정보에 해당하는 detail정보를 가져옴
			for(Integer oseq : oseqList) {
				ArrayList<GOrderVO> orderListByOseq = odao.selectOrderList(oseq);
				GOrderVO govo = orderListByOseq.get(0);
				if(orderListByOseq.size()>1) {
					govo.setGname(govo.getGname()+" 외 "+(orderListByOseq.size()-1)+"건");
				}
				int totalPrice = 0;
				for(GOrderVO order : orderListByOseq)
					totalPrice += order.getPrice()*order.getQuantity();
				govo.setPrice(totalPrice);
				list.add(govo);
			}
			request.setAttribute("GoodsOrderList", list);
			request.setAttribute("paging", paging);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
