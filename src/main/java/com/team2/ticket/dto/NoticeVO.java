package com.team2.ticket.dto;

import java.sql.Timestamp;

public class NoticeVO {
	private int ntnum;
	private String title;
	private Timestamp indate;
	private String content;
	private int readcount;
	private String pass;
	private String id;
	public int getNtnum() {
		return ntnum;
	}
	public void setNtnum(int ntnum) {
		this.ntnum = ntnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
