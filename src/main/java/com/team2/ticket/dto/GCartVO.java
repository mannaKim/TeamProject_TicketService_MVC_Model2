package com.team2.ticket.dto;

import java.sql.Timestamp;

public class GCartVO {
	private int gcseq;
	private int quantity;
	private String result;
	private Timestamp indate;
	private String id;
	private int gseq;
	
	public int getGcseq() {
		return gcseq;
	}
	public void setGcseq(int gcseq) {
		this.gcseq = gcseq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public int getGseq() {
		return gseq;
	}
	public void setGseq(int gseq) {
		this.gseq = gseq;
	}
}
