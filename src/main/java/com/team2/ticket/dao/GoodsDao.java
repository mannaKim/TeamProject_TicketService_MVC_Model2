package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
