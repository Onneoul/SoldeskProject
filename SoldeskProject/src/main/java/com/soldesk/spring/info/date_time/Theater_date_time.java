package com.soldesk.spring.info.date_time;

import java.math.BigDecimal;

public class Theater_date_time {
	private BigDecimal theater_number;
	private BigDecimal date_number;
	
	public Theater_date_time() {
		// TODO Auto-generated constructor stub
	}

	public Theater_date_time(BigDecimal theater_number, BigDecimal date_number) {
		super();
		this.theater_number = theater_number;
		this.date_number = date_number;
	}

	public BigDecimal getTheater_number() {
		return theater_number;
	}

	public void setTheater_number(BigDecimal theater_number) {
		this.theater_number = theater_number;
	}

	public BigDecimal getDate_number() {
		return date_number;
	}

	public void setDate_number(BigDecimal date_number) {
		this.date_number = date_number;
	}
	
}
