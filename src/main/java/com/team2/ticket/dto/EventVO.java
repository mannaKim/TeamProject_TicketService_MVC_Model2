package com.team2.ticket.dto;

import java.sql.Timestamp;

public class EventVO {
	private int evnum;
	private String eimage;
	private String eimage2;
	private String etitle;
	private String evdate;
	private String evperson;
	private String pass;
	private int readcount;
	private Timestamp indate;
	private String id;
	
	
	public String getEimage2() {
		return eimage2;
	}
	public void setEimage2(String eimage2) {
		this.eimage2 = eimage2;
	}
	public int getEvnum() {
		return evnum;
	}
	public void setEvnum(int evnum) {
		this.evnum = evnum;
	}
	public String getEimage() {
		return eimage;
	}
	public void setEimage(String eimage) {
		this.eimage = eimage;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getEvdate() {
		return evdate;
	}
	public void setEvdate(String evdate) {
		this.evdate = evdate;
	}
	public String getEvperson() {
		return evperson;
	}
	public void setEvperson(String evperson) {
		this.evperson = evperson;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
