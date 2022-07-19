package com.team2.ticket.dto;

import java.sql.Timestamp;

public class Ticket_CartVO {
	private Integer cseq;
	private String id;  
	private String mname;  
	private String pname;  
	private Timestamp choisdate;  
	private Timestamp indate;  
	private Integer tpseq;  
	private Integer quantity1;
	private Integer quantity2;
	private Integer price1;
	private Integer price2;
	private Integer price3;
	private String result;
	private String daytime;
	private Timestamp edate;
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
	public Timestamp getChoisdate() {
		return choisdate;
	}
	public void setChoisdate(Timestamp choisdate) {
		this.choisdate = choisdate;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
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
	public Integer getPrice1() {
		return price1;
	}
	public void setPrice1(Integer price1) {
		this.price1 = price1;
	}
	public Integer getPrice2() {
		return price2;
	}
	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}
	public Integer getPrice3() {
		return price3;
	}
	public void setPrice3(Integer price3) {
		this.price3 = price3;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}
	public Timestamp getEdate() {
		return edate;
	}
	public void setEdate(Timestamp edate) {
		this.edate = edate;
	}  
	
	
}
