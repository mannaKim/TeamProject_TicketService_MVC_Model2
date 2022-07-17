package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.GoodsVO;
import com.team2.ticket.util.Dbman;
import com.team2.ticket.util.Paging;

public class GoodsDao {
	private GoodsDao() {}
	private static GoodsDao itc = new GoodsDao();
	public static GoodsDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<GoodsVO> getBestList() {
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from best_goods_view";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO gvo = new GoodsVO();
				//화면에 표시할 내용만 받아가기
				gvo.setGseq(rs.getInt("gseq"));
				gvo.setName(rs.getString("name"));
				gvo.setPrice2(rs.getInt("price2"));
				gvo.setImage(rs.getString("image"));
				list.add(gvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<GoodsVO> getNewList() {
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from new_goods_view";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO gvo = new GoodsVO();
				//화면에 표시할 내용만 받아가기
				gvo.setGseq(rs.getInt("gseq"));
				gvo.setName(rs.getString("name"));
				gvo.setPrice2(rs.getInt("price2"));
				gvo.setImage(rs.getString("image"));
				list.add(gvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<GoodsVO> getGoodsCategoryList(String kind) {
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from goods where kind=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO gvo = new GoodsVO();
				//화면에 표시할 내용만 받아가기
				gvo.setGseq(rs.getInt("gseq"));
				gvo.setName(rs.getString("name"));
				gvo.setPrice2(rs.getInt("price2"));
				gvo.setImage(rs.getString("image"));
				gvo.setContent(rs.getString("content"));
				list.add(gvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public GoodsVO getGoods(int gseq) {
		GoodsVO gvo = null;
		String sql = "select * from goods where gseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				gvo = new GoodsVO();
				gvo.setGseq(rs.getInt("gseq"));
				gvo.setName(rs.getString("name"));
				gvo.setKind(rs.getString("kind"));
				gvo.setPrice1(rs.getInt("price1"));
				gvo.setPrice2(rs.getInt("price2"));
				gvo.setPrice3(rs.getInt("price3"));
				gvo.setImage(rs.getString("image"));
				gvo.setDetail_img(rs.getString("detail_img"));
				gvo.setContent(rs.getString("content"));
				gvo.setUseyn(rs.getString("useyn"));
				gvo.setBestyn(rs.getString("bestyn"));
				gvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return gvo;
	}

	public ArrayList<GoodsVO> selectGoods(Paging paging, String key) {
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, g.* from "
				+ "((select * from goods where name like '%'||?||'%' order by gseq desc) g)"
				+ ") where rn>=?"
				+ ") where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO gvo = new GoodsVO();
				gvo.setGseq(rs.getInt("gseq"));
				gvo.setName(rs.getString("name"));
				gvo.setKind(rs.getString("kind"));
				gvo.setPrice1(rs.getInt("price1"));
				gvo.setPrice2(rs.getInt("price2"));
				gvo.setPrice3(rs.getInt("price3"));
				gvo.setImage(rs.getString("image"));
				gvo.setDetail_img(rs.getString("detail_img"));
				gvo.setContent(rs.getString("content"));
				gvo.setUseyn(rs.getString("useyn"));
				gvo.setBestyn(rs.getString("bestyn"));
				gvo.setIndate(rs.getTimestamp("indate"));
				list.add(gvo);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}
	
	
	//admin 관련 메서드
	//paging에 setTotalCount()을 위한 출력개수 계산
	public int getGoodsCount(String key) {
		int count = 0;
		String sql="select count(*) as cnt from goods"
				+ " where name like '%'||?||'%'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return count;
	}
	//goods분류(kind)별 setTotalCount()을 위한 출력개수 계산
	//getGoodsCount 메서드 오버라이딩
	public int getGoodsCount(String key, String kind) {
		int count = 0;
		String sql="select count(*) as cnt from goods"
				+ " where name like '%'||?||'%'"
				+ " and kind=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, kind);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return count;
	}
	
	//goods분류(kind)별로 보여지는 페이지를 위해 selectGoods 메서드 오버라이딩
	public ArrayList<GoodsVO> selectGoods(Paging paging, String key, String kind) {
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, g.* from "
				+ "((select * from goods where name like '%'||?||'%' and kind=? order by gseq desc) g)"
				+ ") where rn>=?"
				+ ") where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, kind);
			pstmt.setInt(3, paging.getStartNum());
			pstmt.setInt(4, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO gvo = new GoodsVO();
				gvo.setGseq(rs.getInt("gseq"));
				gvo.setName(rs.getString("name"));
				gvo.setKind(rs.getString("kind"));
				gvo.setPrice1(rs.getInt("price1"));
				gvo.setPrice2(rs.getInt("price2"));
				gvo.setPrice3(rs.getInt("price3"));
				gvo.setImage(rs.getString("image"));
				gvo.setDetail_img(rs.getString("detail_img"));
				gvo.setContent(rs.getString("content"));
				gvo.setUseyn(rs.getString("useyn"));
				gvo.setBestyn(rs.getString("bestyn"));
				gvo.setIndate(rs.getTimestamp("indate"));
				list.add(gvo);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}

	public void insertGoods(GoodsVO gvo) {
		String sql = "insert into goods(gseq,kind,name,price1,price2,price3,content,image,detail_img)"
				+ " values(goods_seq.nextVal,?,?,?,?,?,?,?,?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gvo.getKind());
			pstmt.setString(2, gvo.getName());
			pstmt.setInt(3, gvo.getPrice1());
			pstmt.setInt(4, gvo.getPrice2());
			pstmt.setInt(5, gvo.getPrice3());
			pstmt.setString(6, gvo.getContent());
			pstmt.setString(7, gvo.getImage());
			pstmt.setString(8, gvo.getDetail_img());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public void updateGoods(GoodsVO gvo) {
		String sql = "update goods"
				+ "	set kind=?,name=?,"
				+ "price1=?,price2=?,price3=?,"
				+ "content=?,useyn=?,bestyn=?,"
				+ "image=?,detail_img=?"
				+ " where gseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gvo.getKind());
			pstmt.setString(2, gvo.getName());
			pstmt.setInt(3, gvo.getPrice1());
			pstmt.setInt(4, gvo.getPrice2());
			pstmt.setInt(5, gvo.getPrice3());
			pstmt.setString(6, gvo.getContent());
			pstmt.setString(7, gvo.getUseyn());
			pstmt.setString(8, gvo.getBestyn());
			pstmt.setString(9, gvo.getImage());
			pstmt.setString(10, gvo.getDetail_img());
			pstmt.setInt(11, gvo.getGseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
}
