package com.soldesk.spring.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private String reply_user; // 기존 number_id
	private BigDecimal reply_number; // 기존 sns_number
	private Date reply_date;
	private String reply_text;
	private BigDecimal reply_number_num; // 기존 reply_number
	
	public SNSReply() {
		// TODO Auto-generated constructor stub
	}

	public SNSReply(String reply_user, BigDecimal reply_number, Date reply_date, String reply_text,
			BigDecimal reply_number_num) {
		super();
		this.reply_user = reply_user;
		this.reply_number = reply_number;
		this.reply_date = reply_date;
		this.reply_text = reply_text;
		this.reply_number_num = reply_number_num;
	}

	public String getReply_user() {
		return reply_user;
	}

	public void setReply_user(String reply_user) {
		this.reply_user = reply_user;
	}

	public BigDecimal getReply_number() {
		return reply_number;
	}

	public void setReply_number(BigDecimal reply_number) {
		this.reply_number = reply_number;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public String getReply_text() {
		return reply_text;
	}

	public void setReply_text(String reply_text) {
		this.reply_text = reply_text;
	}

	public BigDecimal getReply_number_num() {
		return reply_number_num;
	}

	public void setReply_number_num(BigDecimal reply_number_num) {
		this.reply_number_num = reply_number_num;
	}
	
}
