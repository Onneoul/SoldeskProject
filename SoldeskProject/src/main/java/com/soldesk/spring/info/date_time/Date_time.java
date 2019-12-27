package com.soldesk.spring.info.date_time;

import java.math.BigDecimal;
import java.util.Date;

public class Date_time {
	private Date theater_date;
	private BigDecimal date_number;
	
	public Date_time() {
		// TODO Auto-generated constructor stub
	}

	public Date_time(Date theater_date, BigDecimal date_number) {
		super();
		this.theater_date = theater_date;
		this.date_number = date_number;
	}

	public Date getTheater_date() {
		return theater_date;
	}

	public void setTheater_date(Date theater_date) {
		this.theater_date = theater_date;
	}

	public BigDecimal getDate_number() {
		return date_number;
	}

	public void setDate_number(BigDecimal date_number) {
		this.date_number = date_number;
	}

	
	
}
