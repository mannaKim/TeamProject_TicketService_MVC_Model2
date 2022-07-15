package com.team2.ticket.controller.action.admin.goods;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dto.GoodsVO;
import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.util.Paging;

public class AdminGoodsListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "admin/goods/goodsList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null || mvo.getAdmin()!=1) {
			url="ticket.do?command=loginForm";
		}else {
			//페이징 기능 추가
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
			
			//검색 키워드 key
			String key = "";
			if(request.getParameter("key")!=null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			}else if(session.getAttribute("key")!=null) {
				key = (String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
			}
			
			GoodsDao gdao = GoodsDao.getInstance();
			ArrayList<GoodsVO> goodsList = null;
			//kind 파라미터가 전달된 경우 - 메서드 전달인수에 kind를 추가
			if(request.getParameter("kind")!=null) {
				//key값과 kind값을 전달해서 해당하는 goods만 goodsList에 담음
				String kind = request.getParameter("kind");
				int count = gdao.getGoodsCount(key, kind);
				//보여줄 goods의 개수를 얻어서 paging에 전달
				paging.setTotalCount(count);
				goodsList = gdao.selectGoods(paging, key, kind);
			}
			//kind 파라미터가 전달되지 않은 경우
			else {
				//검색 key를 전달해서 name에 key가 포함되는 goods만 goodsList에 담음
				int count = gdao.getGoodsCount(key);
				//보여줄 goods의 개수를 얻어서 paging에 전달
				paging.setTotalCount(count);
				goodsList = gdao.selectGoods(paging, key);
			}
			String [] goodsKindList = {"","문구","디지털","가방 · 파우치","취미용품","패션 · 잡화"};
			request.setAttribute("goodsList", goodsList);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);
			request.setAttribute("goodsKindList", goodsKindList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
