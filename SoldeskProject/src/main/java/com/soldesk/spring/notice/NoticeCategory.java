package com.soldesk.spring.notice;

import java.math.BigDecimal;

public class NoticeCategory {
	private String search;
	private BigDecimal start;
	private BigDecimal end;
	private BigDecimal notice_category;
	
	public NoticeCategory() {
		// TODO Auto-generated constructor stub
	}

	public NoticeCategory(String search, BigDecimal start, BigDecimal end, BigDecimal notice_category) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
		this.notice_category = notice_category;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	public BigDecimal getNotice_category() {
		return notice_category;
	}

	public void setNotice_category(BigDecimal notice_category) {
		this.notice_category = notice_category;
	}
	
	
}
