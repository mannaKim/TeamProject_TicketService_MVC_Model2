package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.team2.ticket.dto.Ticket_CartVO;
import com.team2.ticket.util.Dbman;


public class Ticket_CartDao {
	
	private Ticket_CartDao() {}
	private static Ticket_CartDao itc = new Ticket_CartDao();
	public static Ticket_CartDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int insertOrderOne(int tpseq, Date sqlDate, int quantity1, int quantity2, String id) {
		int oseq = 0;
		con = Dbman.getConnection();
		String sql = "insert into orders(oseq, id) values( orders_seq.nextVal , ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			pstmt.executeUpdate();
			pstmt.close();			
			
			sql = "select max(oseq) as moseq from orders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next() ) oseq = rs.getInt( "moseq" );
			pstmt.close();
			
			sql = "insert into t_order_detail(todseq, oseq, date, tpseq, quantity1, quantity2) "
					+ " values( t_order_detail_todseq.nextVal, ? , ?, ?, ?, ? )";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			pstmt.setInt(2, tpseq );
			pstmt.setTimestamp(3, (Timestamp)sqlDate );
			pstmt.setInt(3, quantity1 );
			pstmt.setInt(4, quantity2 );
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);	}
		return oseq;
		
	}

	public void insertOrder(int tpseq, String chioceDay, int quantity1, int quantity2, String id  ) {
		con = Dbman.getConnection();
		String sql = "insert into ticket_cart( cseq, choisdate, tpseq, quantity1, quantity2, id ) "
				+ " values( ticket_cart_cseq.nextVal, ?,?,?,?,?)";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, chioceDay );
			pstmt.setInt(2, tpseq);
			pstmt.setInt(3, quantity1 );
			pstmt.setInt(4, quantity2 );
			pstmt.setString(5, id );
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);	}
		
	}

	public ArrayList<Ticket_CartVO> tclistTicket(int tpseq) {
		ArrayList<Ticket_CartVO> list = new ArrayList<Ticket_CartVO>();
		String sql = "select * from ticket_cart where tpseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tpseq );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ticket_CartVO ctvo = new Ticket_CartVO();
				ctvo.setCseq(rs.getInt("cseq") );
				ctvo.setTpseq(rs.getInt("tpseq") );
				ctvo.setTpseq(rs.getInt("cseq") );
				ctvo.setQuantity1(rs.getInt("quantity1") );
				ctvo.setQuantity2(rs.getInt("quantity2") );
				ctvo.setChoisdate(rs.getTimestamp("choisdate") );
				list.add(ctvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}


}
