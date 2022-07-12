package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.team2.ticket.dto.GoodsVO;
import com.team2.ticket.util.Dbman;

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
				gvo.setPrice2(rs.getInt("price2"));
				gvo.setImage(rs.getString("image"));
				gvo.setDetail_img(rs.getString("detail_img"));
				gvo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return gvo;
	}
}
