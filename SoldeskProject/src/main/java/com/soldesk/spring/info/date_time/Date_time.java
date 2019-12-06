package com.soldesk.spring.info.date_time;

import java.math.BigDecimal;
import java.util.Date;

public class Date_time {
	private BigDecimal theater_number;
	private Date theater_date;
	private BigDecimal date_number;
	
	public Date_time() {
		// TODO Auto-generated constructor stub
	}

	public Date_time(BigDecimal theater_number, java.util.Date theater_date, BigDecimal date_number) {
		super();
		this.theater_number = theater_number;
		this.theater_date = theater_date;
		this.date_number = date_number;
	}

	public BigDecimal getTheater_number() {
		return theater_number;
	}

	public void setTheater_number(BigDecimal theater_number) {
		this.theater_number = theater_number;
	}

	public java.util.Date getTheater_date() {
		return theater_date;
	}

	public void setTheater_date(java.util.Date theater_date) {
		this.theater_date = theater_date;
	}

	public BigDecimal getDate_number() {
		return date_number;
	}

	public void setDate_number(BigDecimal date_number) {
		this.date_number = date_number;
	}
	
}
