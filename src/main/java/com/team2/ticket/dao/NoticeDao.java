package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.NoticeVO;
import com.team2.ticket.util.Dbman;

public class NoticeDao {
	private NoticeDao () {}
	private static NoticeDao itc = new NoticeDao();
	public static NoticeDao getInstance() {
		return itc;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<NoticeVO> selectnotice() {
		ArrayList<NoticeVO> nlist = new ArrayList<NoticeVO>();
		String sql = "select * from notice order by ntnum desc";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO nvo = new NoticeVO();
				nvo.setContent(rs.getString("content"));
				nvo.setId(rs.getString("id"));
				nvo.setIndate(rs.getTimestamp("indate"));
				nvo.setNtnum(rs.getInt("ntnum"));
				nvo.setPass(rs.getString("pass"));
				nvo.setReadcount(rs.getInt("readcount"));
				nvo.setTitle(rs.getString("title"));
				
				nlist.add(nvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return nlist;
	}

	public void readCountOne(int ntnum) {
		String sql = "update notice set readcount = readcount + 1 where ntnum=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ntnum);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	public NoticeVO selectnotice(int ntnum) {
		NoticeVO nvo = null;
		String sql = "select * from notice where ntnum=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ntnum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nvo = new NoticeVO();
				nvo.setContent(rs.getString("content"));
				nvo.setId(rs.getString("id"));
				nvo.setIndate(rs.getTimestamp("indate"));
				nvo.setNtnum(rs.getInt("ntnum"));
				nvo.setPass(rs.getString("pass"));
				nvo.setReadcount(rs.getInt("readcount"));
				nvo.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return nvo;
	}

	public void updateNotice(NoticeVO nvo) {
		String sql = "update notice set content=?, id=?, pass=?, title=? where ntnum=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getContent());
			pstmt.setString(2, nvo.getId());
			pstmt.setString(3, nvo.getPass());
			pstmt.setString(4, nvo.getTitle());
			pstmt.setInt(5, nvo.getNtnum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	public NoticeVO delectNotice(int ntnum) {
		NoticeVO nvo = null;
		String sql = "delete notice where ntnum=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ntnum);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return nvo;
	}
	
	
}
