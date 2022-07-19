package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.NoticeVO;
import com.team2.ticket.util.Dbman;
import com.team2.ticket.util.Paging;

public class NoticeDao {
	private NoticeDao () {}
	private static NoticeDao itc = new NoticeDao();
	public static NoticeDao getInstance() {
		return itc;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<NoticeVO> selectnotice(Paging paging) {
		ArrayList<NoticeVO> nlist = new ArrayList<NoticeVO>();
		//String sql = "select * from notice order by ntnum desc";
		String sql = "select * from(select * from(select rownum as rn, b.* from((select * from notice order by ntnum desc)b))where rn>=? )where rn <= ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
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

	public void noticeInsert(NoticeVO nvo) {
		String sql = "insert into notice(ntnum, id, pass, title, content) values(ntnum_seq.nextVal, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getId());
			pstmt.setString(2, nvo.getPass());
			pstmt.setString(3, nvo.getTitle());
			pstmt.setString(4, nvo.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}	
		
	}

	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) as cnt from notice";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return count;
	}
	
	public int getNoticeAllCount(String noticeName, String key) {
		int count=0;
		String sql = "select count(*) as cnt from " + noticeName + " where title like '%'||?||'%'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return count;
	}
	
	public ArrayList<NoticeVO> listNotice(Paging paging, String key) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		String sql = "select * from ( select * from( select rownum as rn, p.* from ((select * from notice where title like '%'||?||'%' order by ntnum desc) p)) where rn>=?) where rn<=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
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
				
				list.add(nvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}
	
	
}
