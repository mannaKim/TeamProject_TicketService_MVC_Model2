package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.QnaVO;
import com.team2.ticket.dto.QreplyVO;
import com.team2.ticket.util.Dbman;
//import com.team2.ticket.util.Paging;
import com.team2.ticket.util.Paging;


public class QnaDao {
	
	private QnaDao() { }
	private static QnaDao ist = new QnaDao();
	public static QnaDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public void insertQna(QnaVO qvo) {
		
		String sql = "insert into qna(qseq, subject, content, kind, id)"
				+ " values(qna_seq.nextval, ?, ?, ?, ? )";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			

//			pstmt.setString(1, "test");
//			pstmt.setString(2, "test");
//		    pstmt.setString(3, "2");
//		    pstmt.setString(4, "scott"); 
			
			pstmt.setString(1, qvo.getSubject());
		    pstmt.setString(2, qvo.getContent());
		    pstmt.setString(3, qvo.getKind());
		    pstmt.setString(4, qvo.getId()); 
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally {  Dbman.close(con, pstmt, rs);  }
		
	}


	public QnaVO getQna(int qseq) {
		QnaVO qvo = new QnaVO();
		String sql = "select * from qna where qseq = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qvo.setQseq(qseq);
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				qvo.setKind(rs.getString("kind"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}
		return qvo;
	}


	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) as cnt from qna";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
	} catch (SQLException e) { e.printStackTrace();
	} finally { Dbman.close(con, pstmt, rs);
	} return count;
	}


	public ArrayList<QnaVO> listQna(String id, Paging paging) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, q.*from ((select * from qna where id=? order by qseq desc) q) "
				+ " ) where rn>=?"
				+ " ) where rn<=?";
//		String sql = "select * from qna where id =?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setKind(rs.getString("kind"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));

				list.add(qvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		return list;
	}



	public ArrayList<QreplyVO> selectReply(int qseq) {
		ArrayList<QreplyVO> list = new ArrayList<QreplyVO>();
		
		String sql = "select * from qreply where qnanum =?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  qseq);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				QreplyVO qrvo = new QreplyVO();
				qrvo.setRenum(rs.getInt("renum"));
				qrvo.setQnanum( rs.getInt("qnanum") );
				qrvo.setId(rs.getString("id"));
				qrvo.setIndate(rs.getTimestamp("indate") );
				qrvo.setContent(rs.getNString("content"));
				list.add(qrvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);   }
		
		return list;
	}


	public void insertReply(QreplyVO qrvo) {
		String sql = "insert into qreply( renum, qnanum, id, content ) "
				+ " values( qreply_seq.nextVal, ? , ? , ? )";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,  qrvo.getQnanum());
			pstmt.setString(2, qrvo.getId());
			pstmt.setString(3, qrvo.getContent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		
	}


	public int getReplycnt(Integer qseq) {
		int count=0;
		String sql = "select count(*) as cnt from qreply where qnanum=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) count = rs.getInt("cnt");
		} catch (SQLException e) {  e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		
		return count;
	}


	
	public QnaVO getKind(String id) {
		QnaVO qvo = null;
		String sql = "select * from qna where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				qvo = new QnaVO();
				qvo.setKind(rs.getString("kind"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setRep(rs.getString("rep"));
				qvo.setReply(rs.getString("reply"));
				qvo.setReplycnt(rs.getInt("replycnt"));
				qvo.setSubject(rs.getString("subject"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return qvo;
	}


	public ArrayList<QnaVO> listQna(Paging paging) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, q.* from "
				+ " ((select * from qna order by qseq desc) q) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  paging.getStartNum()) ;
			pstmt.setInt(2,  paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setKind(rs.getString("kind"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				qvo.setReplycnt(rs.getInt("replycnt"));
				list.add(qvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {  Dbman.close(con, pstmt, rs);   }
		return list;
	}


	public int getAllCount(String id) {
		int count = 0;
		String sql = "select count(*) as cnt from qna where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
	} catch (SQLException e) { e.printStackTrace();
	} finally { Dbman.close(con, pstmt, rs);
	} return count;
	}


		
	}


	
