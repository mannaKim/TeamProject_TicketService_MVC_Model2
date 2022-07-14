package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.EventVO;
import com.team2.ticket.dto.ReplyVO;
import com.team2.ticket.util.Dbman;

public class EventDao {
	private EventDao () {}
	private static EventDao itc = new EventDao();
	public static EventDao getInstance() {
		return itc;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<EventVO> getEventList() {
		ArrayList<EventVO> evlist = new ArrayList<EventVO>();
		String sql = "select * from event";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EventVO evo = new EventVO();
				evo.setEimage2(rs.getString("eimage2"));
				evo.setEimage(rs.getString("eimage"));
				evo.setEtitle(rs.getString("etitle"));
				evo.setEvdate(rs.getString("evdate"));
				evo.setEvnum(rs.getInt("evnum"));
				evo.setEvperson(rs.getString("evperson"));
				evo.setId(rs.getString("id"));
				evo.setIndate(rs.getTimestamp("indate"));
				evo.setPass(rs.getString("pass"));
				evo.setReadcount(rs.getInt("readcount"));
				
				evlist.add(evo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return evlist;
	}

	public EventVO getEvent(int evnum) {
		EventVO evo = null;
		String sql = "select * from event where evnum=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, evnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				evo = new EventVO();
				evo.setEimage2(rs.getString("eimage2"));
				evo.setEimage(rs.getString("eimage"));
				evo.setEtitle(rs.getString("etitle"));
				evo.setEvdate(rs.getString("evdate"));
				evo.setEvnum(rs.getInt("evnum"));
				evo.setEvperson(rs.getString("evperson"));
				evo.setId(rs.getString("id"));
				evo.setIndate(rs.getTimestamp("indate"));
				evo.setPass(rs.getString("pass"));
				evo.setReadcount(rs.getInt("readcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return evo;
	}

	public void readCountOne(int evnum) {
		String sql = "update event set readcount = readcount + 1 where evnum=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, evnum);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	public void updateEvent(EventVO evo) {
		String sql = "update event set etitle=?, evdate=?, evperson=?, eimage=?, eimage2=? where evnum=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, evo.getEtitle());
			pstmt.setString(2, evo.getEvdate());
			pstmt.setString(3, evo.getEvperson());
			pstmt.setString(4, evo.getEimage());
			pstmt.setString(5, evo.getEimage2());
			pstmt.setInt(6, evo.getEvnum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	public ArrayList<ReplyVO> eventReply(int evnum) {
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
		String sql = "select * from reply where evnum=? order by replynum desc";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, evnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setContent(rs.getString("content"));
				rvo.setEvnum(rs.getInt("evnum"));
				rvo.setId(rs.getString("id"));
				rvo.setRate(rs.getInt("rate"));
				rvo.setReplynum(rs.getInt("replynum"));
				rvo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(rvo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public void insertReply(ReplyVO rvo) {
		String sql = "insert into reply(replynum, evnum, id, content, rate) values(reply_seq.nextVal, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rvo.getEvnum());
			pstmt.setString(2, rvo.getId());
			pstmt.setString(3, rvo.getContent());
			pstmt.setInt(4, rvo.getRate());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		
	}

	public void deleteReply(String replynum) {
		String sql = "delete from reply where replynum=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(replynum));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
	
	
}
