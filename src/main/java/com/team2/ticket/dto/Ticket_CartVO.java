package com.team2.ticket.dto;

import java.sql.Timestamp;

public class Ticket_CartVO {
	private Integer cseq;
	private String id;  
	private String mname;  
	private String pname;  
	private Timestamp choisdate;  
	private Integer tpseq;  
	private Integer quantity1;
	private Integer quantity2;
	
	
	public Timestamp getChoisdate() {
		return choisdate;
	}
	public void setChoisdate(Timestamp choisdate) {
		
		this.choisdate = choisdate;
	}
	private Timestamp indate;
	private String result;
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getCseq() {
		return cseq;
	}
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getTpseq() {
		return tpseq;
	}
	public void setTpseq(Integer tpseq) {
		this.tpseq = tpseq;
	}
	public Integer getQuantity1() {
		return quantity1;
	}
	public void setQuantity1(Integer quantity1) {
		this.quantity1 = quantity1;
	}
	public Integer getQuantity2() {
		return quantity2;
	}
	public void setQuantity2(Integer quantity2) {
		this.quantity2 = quantity2;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
