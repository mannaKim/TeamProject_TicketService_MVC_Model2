package com.team2.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GoodsDao {
	private GoodsDao() {}
	private static GoodsDao itc = new GoodsDao();
	public static GoodsDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
}
