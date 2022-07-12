package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team2.ticket.dto.GCartVO;
import com.team2.ticket.util.Dbman;

public class GCartDao {
	private GCartDao() {}
	private static GCartDao itc = new GCartDao();
	public static GCartDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertCart(GCartVO gcvo) {
		String sql = "insert into cart(gcseq,id,gseq,quantity)"
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
	
	
}
