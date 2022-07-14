package com.team2.ticket.dto;

import java.sql.Timestamp;

public class ReviewVO {
		
	private Integer rseq; 
	private String subject;
	private String content;
	private String reply;
	private String id; 
	private String rep;
	private Timestamp indate;
	
	public Integer getRseq() {
		return rseq;
	}
	public void setRseq(Integer rseq) {
		this.rseq = rseq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
}
