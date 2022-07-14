package com.team2.ticket.dto;

import java.sql.Timestamp;

public class Ticket_productVO {
	
	private Integer tpseq;
	private String name;
	private String showtime;
	private Integer age;
	private String image;
	private String place;
	private String daytime;
	private Integer price1;
	private Integer price2;
	private Integer price3;
	private String content;
	private String bestyn;
	private Timestamp sdate;
	private Timestamp edate;
	private Timestamp indate;
	
	public Integer getTpseq() {
		return tpseq;
	}
	public void setTpseq(Integer tpseq) {
		this.tpseq = tpseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBestyn() {
		return bestyn;
	}
	public void setBestyn(String bestyn) {
		this.bestyn = bestyn;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}
	public Timestamp getEdate() {
		return edate;
	}
	public void setEdate(Timestamp edate) {
		this.edate = edate;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
}
