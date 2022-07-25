package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.GCartVO;
import com.team2.ticket.dto.GOrderVO;
import com.team2.ticket.util.Dbman;
import com.team2.ticket.util.Paging;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao itc = new OrderDao();
	public static OrderDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertOrder(ArrayList<GCartVO> list, String id) {
		int oseq = 0;
		con = Dbman.getConnection();
		
		//1. 주문번호(시퀀스자동입력)와 구매자 아이디로 orders테이블에 레코드 추가
		String sql = "insert into orders(oseq,id) values(orders_seq.nextVal,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//2. orders테이블에 시퀀스로 입력된 가장 마지막(방금추가한)주문 번호 조회
			sql = "select max(oseq) as max_oseq from orders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) oseq = rs.getInt("max_oseq");
			pstmt.close();
			
			//3. list의 카트 목록들을 orders에서 얻은 max_oseq와 함께 order_detail에 추가
			//반복실행을 이용하여 카트 목록을 하나씩 꺼내서 oseq와 함께 order_detail 테이블에 추가
			//odseq, quantity, oseq, gseq 
			sql = "insert into order_detail(odseq,quantity,oseq,gseq)"
					+ " values(order_detail_seq.nextVal,?,?,?)";
			for(GCartVO gcvo : list) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, gcvo.getQuantity());
				pstmt.setInt(2,oseq);
				pstmt.setInt(3, gcvo.getGseq());
				pstmt.executeUpdate();
			}
			
			//4. order_detail에 추가된 카트내용은 cart테이블에서 처리되었으므로 삭제
			GCartDao gcdao = GCartDao.getInstance();
			for(GCartVO gcvo : list) {
				gcdao.deleteCart(gcvo.getGcseq());
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return oseq;
	}

	public ArrayList<GOrderVO> selectOrderList(int oseq) {
		ArrayList<GOrderVO> list = new ArrayList<GOrderVO>();
		String sql = "select * from goods_order_view where oseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GOrderVO govo = new GOrderVO();
				govo.setOdseq(rs.getInt("odseq"));
				govo.setQuantity(rs.getInt("quantity"));
				govo.setResult(rs.getString("result"));
				govo.setOseq(rs.getInt("oseq"));
				govo.setIndate(rs.getTimestamp("indate"));
				govo.setId(rs.getString("id"));
				govo.setMname(rs.getString("mname"));
				govo.setZip_num(rs.getString("zip_num"));
				govo.setAddress1(rs.getString("address1"));
				govo.setAddress2(rs.getString("address2"));
				govo.setPhone(rs.getString("phone"));
				govo.setGseq(rs.getInt("gseq"));
				govo.setGname(rs.getString("gname"));
				govo.setPrice(rs.getInt("price"));
				govo.setImage(rs.getString("image"));
				list.add(govo);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}

	public int insertOrderOne(int gseq, int quantity, String id) {
		int oseq = 0;
		con = Dbman.getConnection();
		
		//1. 주문번호(시퀀스자동입력)와 구매자 아이디로 orders테이블에 레코드 추가
		String sql = "insert into orders(oseq,id) values(orders_seq.nextVal,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//2. orders테이블에 시퀀스로 입력된 가장 마지막(방금추가한)주문 번호 조회
			sql = "select max(oseq) as oseq from orders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) oseq = rs.getInt("oseq");
			pstmt.close();
			
			//3. 전달인수 quantity,gseq와 방금 얻은 oseq로 order_detail에 레코드 추가
			sql = "insert into order_detail(odseq,quantity,oseq,gseq)"
					+ " values(order_detail_seq.nextVal,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, oseq);
			pstmt.setInt(3, gseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return oseq;
	}

	public ArrayList<Integer> selectOseqList(String id) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select oseq from orders where id=? order by oseq desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("oseq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}
	
	public ArrayList<Integer> selectOseqList(String id, Paging paging) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, o.* from "
				+ "((select oseq from orders where id=? order by oseq desc) o)"
				+ ") where rn>=?"
				+ ") where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("oseq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}
	
	//admin 관련 메소드
	public ArrayList<Integer> selectAllOseqList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select oseq from orders"
				+ " order by oseq desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("oseq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}
	public ArrayList<Integer> selectAllOseqList(Paging paging) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, o.* from "
				+ "((select oseq from orders order by oseq desc) o)"
				+ ") where rn>=?"
				+ ") where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("oseq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
		return list;
	}

	public void changeResult(Integer odseq, String result) {
		String sql = "update order_detail set result=?"
				+ " where odseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, result);
			pstmt.setInt(2, odseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
	}

	public void changeResultAll(Integer oseq, String result) {
		String sql = "update order_detail set result=?"
				+ " where oseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, result);
			pstmt.setInt(2, oseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbman.close(con, pstmt, rs); 
		}
	}

	
}
