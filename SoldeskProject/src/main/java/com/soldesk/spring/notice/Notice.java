package com.soldesk.spring.notice;

import java.math.BigDecimal;

public class Notice {
	private BigDecimal notice_number;
	private String notice_title;
	private String notice_text;
	private String notice_id;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(BigDecimal notice_number, String notice_title, String notice_text, String notice_id) {
		super();
		this.notice_number = notice_number;
		this.notice_title = notice_title;
		this.notice_text = notice_text;
		this.notice_id = notice_id;
	}

	public BigDecimal getNotice_number() {
		return notice_number;
	}

	public void setNotice_number(BigDecimal notice_number) {
		this.notice_number = notice_number;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_text() {
		return notice_text;
	}

	public void setNotice_text(String notice_text) {
		this.notice_text = notice_text;
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	
}
