package com.team2.ticket.controller.action.admin.goods;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.ticket.controller.action.Action;
import com.team2.ticket.dao.GoodsDao;
import com.team2.ticket.dto.GoodsVO;
import com.team2.ticket.dto.MemberVO;

public class AdminGoodsUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String url = "ticket.do?command=adminGoodsDetail&gseq=";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null || mvo.getAdmin()!=1) {
			url="ticket.do?command=loginForm";
		}else {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath("goods/goods_images");
			MultipartRequest multi = new MultipartRequest(
					request,path,5*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
			
			GoodsVO gvo = new GoodsVO();
			gvo.setGseq(Integer.parseInt(multi.getParameter("gseq")));
			gvo.setKind(multi.getParameter("kind"));
			gvo.setName(multi.getParameter("name"));
			gvo.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			gvo.setPrice2(Integer.parseInt(multi.getParameter("price2")));
			gvo.setPrice3(Integer.parseInt(multi.getParameter("price3")));
			gvo.setContent(multi.getParameter("content"));
			gvo.setUseyn(multi.getParameter("useyn"));
			gvo.setBestyn(multi.getParameter("bestyn"));
			if(multi.getFilesystemName("image")==null)
				gvo.setImage(multi.getParameter("oldImage"));
			else gvo.setImage(multi.getFilesystemName("image"));
			if(multi.getFilesystemName("detail_img")==null)
				gvo.setDetail_img(multi.getParameter("oldDetail_img"));
			else gvo.setDetail_img(multi.getFilesystemName("detail_img"));
			
			GoodsDao gdao = GoodsDao.getInstance();
			gdao.updateGoods(gvo);
			url += gvo.getGseq();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
