package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team2.ticket.dto.IntroduceVO;
import com.team2.ticket.util.Dbman;

public class IntroduceDao {
	private IntroduceDao () {}
	private static IntroduceDao itc = new IntroduceDao();
	public static IntroduceDao getInstance() {
		return itc;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<IntroduceVO> selectIntroduce() {
		ArrayList<IntroduceVO> ivlist = new ArrayList<IntroduceVO>();
		String sql = "select * from introduce";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IntroduceVO ivo = new IntroduceVO();
				ivo.setContent(rs.getString("content"));
				ivo.setId(rs.getString("id"));
				ivo.setImage(rs.getString("image"));
				ivo.setIndate(rs.getTimestamp("indate"));
				ivo.setPass(rs.getString("pass"));
				ivo.setTitle(rs.getString("title"));
				
				ivlist.add(ivo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return ivlist;
	}

	
	
	
	
}
