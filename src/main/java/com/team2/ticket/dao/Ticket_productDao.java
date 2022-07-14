package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.MemberVO;
import com.team2.ticket.dto.Ticket_CartVO;
import com.team2.ticket.dto.Ticket_productVO;
import com.team2.ticket.util.Dbman;

public class Ticket_productDao {
	
	private Ticket_productDao() {}
	private static Ticket_productDao itc = new Ticket_productDao();
	public static Ticket_productDao getInstance() {	return itc; }

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	public ArrayList<Ticket_productVO> listTicket() {
		ArrayList<Ticket_productVO> list = new ArrayList<Ticket_productVO>();
		String sql = "select * from ticket_product order by tpseq desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ticket_productVO tpvo = new Ticket_productVO();
				tpvo.setTpseq(rs.getInt("tpseq"));
				tpvo.setName(rs.getString("name"));
				tpvo.setShowtime(rs.getString("showtime"));
				tpvo.setAge(rs.getInt("age"));
				tpvo.setImage(rs.getString("image"));
				tpvo.setPlace(rs.getString("place"));
				tpvo.setDaytime(rs.getString("daytime"));
				tpvo.setPrice1(rs.getInt("price1"));
				tpvo.setPrice2(rs.getInt("price2"));
				tpvo.setPrice3(rs.getInt("price3"));
				tpvo.setBestyn(rs.getString("bestyn"));
				tpvo.setIndate(rs.getTimestamp("indate"));
				tpvo.setEdate(rs.getTimestamp("edate"));
				tpvo.setSdate(rs.getTimestamp("sdate"));
				list.add(tpvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}


	public Ticket_productVO getTProduct(int tpseq) {
		Ticket_productVO tpvo = null;
		String sql = "select * from ticket_product where tpseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tpseq);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				tpvo = new Ticket_productVO();
				tpvo.setTpseq(rs.getInt("tpseq"));
				tpvo.setName(rs.getString("name"));
				tpvo.setShowtime(rs.getString("showtime"));
				tpvo.setAge(rs.getInt("age"));
				tpvo.setImage(rs.getString("image"));
				tpvo.setPlace(rs.getString("place"));
				tpvo.setDaytime(rs.getString("daytime"));
				tpvo.setPrice1(rs.getInt("price1"));
				tpvo.setPrice2(rs.getInt("price2"));
				tpvo.setPrice3(rs.getInt("price3"));
				tpvo.setBestyn(rs.getString("bestyn"));
				tpvo.setIndate(rs.getTimestamp("indate"));
				tpvo.setEdate(rs.getTimestamp("edate"));
				tpvo.setSdate(rs.getTimestamp("sdate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return tpvo;
	}


	public Ticket_productVO getchoisDay(int tpseq) {
		Ticket_productVO tpvo = null;
		String sql = "select * from ticket_product where tpseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tpseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tpvo = new Ticket_productVO();
				tpvo.setEdate(rs.getTimestamp("edate"));
				tpvo.setSdate(rs.getTimestamp("sdate"));
				tpvo.setTpseq(rs.getInt("tpseq"));
				tpvo.setName(rs.getString("name"));
				tpvo.setShowtime(rs.getString("showtime"));
				tpvo.setAge(rs.getInt("age"));
				tpvo.setImage(rs.getString("image"));
				tpvo.setPlace(rs.getString("place"));
				tpvo.setDaytime(rs.getString("daytime"));
				tpvo.setPrice1(rs.getInt("price1"));
				tpvo.setPrice2(rs.getInt("price2"));
				tpvo.setPrice3(rs.getInt("price3"));
				tpvo.setBestyn(rs.getString("bestyn"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return tpvo;
	}


	public ArrayList<Ticket_productVO> selectCart(int tpseq) {
		ArrayList<Ticket_productVO> list = new ArrayList<Ticket_productVO>();
		String sql = "select * from ticket_product where tpseq=?";

		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tpseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ticket_productVO tpvo = new Ticket_productVO();
				tpvo.setTpseq(rs.getInt("tpseq"));
				tpvo.setName(rs.getString("name"));
				tpvo.setShowtime(rs.getString("showtime"));
				tpvo.setAge(rs.getInt("age"));
				tpvo.setImage(rs.getString("image"));
				tpvo.setPlace(rs.getString("place"));
				tpvo.setDaytime(rs.getString("daytime"));
				tpvo.setPrice1(rs.getInt("price1"));
				tpvo.setPrice2(rs.getInt("price2"));
				tpvo.setPrice3(rs.getInt("price3"));
				tpvo.setBestyn(rs.getString("bestyn"));
				tpvo.setIndate(rs.getTimestamp("indate"));
				tpvo.setEdate(rs.getTimestamp("edate"));
				tpvo.setSdate(rs.getTimestamp("sdate"));
				list.add(tpvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}


	public ArrayList<Ticket_CartVO> selectCartVO(int tpseq) {
		ArrayList<Ticket_CartVO> list = new ArrayList<Ticket_CartVO>();
		String sql = "select * from ticket_Cart where cseq=?";

		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tpseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ticket_CartVO tcvo = new Ticket_CartVO();
				tcvo.setCseq(rs.getInt("cseq"));
				tcvo.setId(rs.getString("id"));
				tcvo.setMname(rs.getString("mname"));
				tcvo.setPname(rs.getString("pname"));
				tcvo.setTpseq(rs.getInt("tpseq"));
				tcvo.setQuantity1(rs.getInt("quantity1"));
				tcvo.setQuantity2(rs.getInt("quantity1"));
				list.add(tcvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}


	public ArrayList<Ticket_productVO> plistTicket(int tpseq) {
		ArrayList<Ticket_productVO> list = new ArrayList<Ticket_productVO>();
		String sql = "select * from ticket_product where tpseq=?";

		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tpseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ticket_productVO tpvo = new Ticket_productVO();
				tpvo.setTpseq(rs.getInt("tpseq"));
				tpvo.setName(rs.getString("name"));
				tpvo.setShowtime(rs.getString("showtime"));
				tpvo.setAge(rs.getInt("age"));
				tpvo.setImage(rs.getString("image"));
				tpvo.setPlace(rs.getString("place"));
				tpvo.setDaytime(rs.getString("daytime"));
				tpvo.setPrice1(rs.getInt("price1"));
				tpvo.setPrice2(rs.getInt("price2"));
				tpvo.setPrice3(rs.getInt("price3"));
				tpvo.setBestyn(rs.getString("bestyn"));
				tpvo.setIndate(rs.getTimestamp("indate"));
				tpvo.setEdate(rs.getTimestamp("edate"));
				tpvo.setSdate(rs.getTimestamp("sdate"));
				list.add(tpvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}
	
	public void updateShow(Ticket_productVO pvo) {
		String sql = "update ticket_product set name=?, daytime=?, place=?, age=?, showtime=?, price1=?, price2=?, content=?, image=? where tpseq=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getName());
			pstmt.setString(2, pvo.getDaytime());
			pstmt.setString(3, pvo.getPlace());
			pstmt.setInt(4, pvo.getAge());
			pstmt.setString(5, pvo.getShowtime());
			pstmt.setInt(6, pvo.getPrice1());
			pstmt.setInt(7, pvo.getPrice2());
			pstmt.setString(8, pvo.getContent());
			pstmt.setString(9, pvo.getImage());
			pstmt.setInt(10, pvo.getTpseq());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public void deleteShow(int tpseq) {
		String sql = "delete from ticket_product where tpseq=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tpseq);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
	
}
