package com.team2.ticket.dto;

import java.sql.Timestamp;

public class GCartVO {
	//c.gcseq, c.id, c.gseq, c.quantity, c.result, c.indate,
	//m.name as mname, g.name as gname, g.price2 as price
	private int gcseq;
	private int quantity;
	private String result;
	private Timestamp indate;
	private String id;
	private int gseq;
	private String mname;
	private String gname;
	private int price;
	private String image;
	
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
