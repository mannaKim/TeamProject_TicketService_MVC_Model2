package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.GCartVO;
import com.team2.ticket.util.Dbman;

public class GCartDao {
	private GCartDao() {}
	private static GCartDao itc = new GCartDao();
	public static GCartDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int checkQuantity(String id, int gseq, int quantity) {
		int oldQuantity = 0;
		String sql = "select quantity from goods_cart"
				+ " where id=? and gseq=? and result='1'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, gseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				oldQuantity = rs.getInt("quantity");
				pstmt.close();
				
				sql = "update goods_cart set quantity=?,indate=sysdate"
						+ " where id=? and gseq=? and result='1'";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, oldQuantity+quantity);
				pstmt.setString(2, id);
				pstmt.setInt(3, gseq);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs);
		}
		return oldQuantity;
	}
	
	public void insertCart(GCartVO gcvo) {
		String sql = "insert into goods_cart(gcseq,id,gseq,quantity)"
				+ " values(goods_cart_seq.nextVal,?,?,?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gcvo.getId());
			pstmt.setInt(2, gcvo.getGseq());
			pstmt.setInt(3, gcvo.getQuantity());
			pstmt.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs);
		}
	}

	public ArrayList<GCartVO> selectCartList(String id) {
		ArrayList<GCartVO> list = new ArrayList<GCartVO>();
		String sql = "select * from goods_cart_view"
				+ " where id=? and result='1'"
				+ " order by indate desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GCartVO gcvo = new GCartVO();
				gcvo.setGcseq(rs.getInt("gcseq"));
				gcvo.setGseq(rs.getInt("gseq"));
				gcvo.setQuantity(rs.getInt("quantity"));
				gcvo.setPrice(rs.getInt("price"));
				gcvo.setId(rs.getString("id"));
				gcvo.setMname(rs.getString("mname"));
				gcvo.setGname(rs.getString("gname"));
				gcvo.setIndate(rs.getTimestamp("indate"));
				gcvo.setImage(rs.getString("image"));
				list.add(gcvo);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}

	public void deleteCart(int gcseq) {
		String sql = "update goods_cart set result='0' where gcseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gcseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
	}

}
