package com.soldesk.spring.info.person;

import java.math.BigDecimal;

public class Casting {
	private BigDecimal theater_number;
	private BigDecimal person_number;
	
	public Casting() {
		// TODO Auto-generated constructor stub
	}

	public Casting(BigDecimal theater_number, BigDecimal person_number) {
		super();
		this.theater_number = theater_number;
		this.person_number = person_number;
	}

	public BigDecimal getTheater_number() {
		return theater_number;
	}

	public void setTheater_number(BigDecimal theater_number) {
		this.theater_number = theater_number;
	}

	public BigDecimal getPerson_number() {
		return person_number;
	}

	public void setPerson_number(BigDecimal person_number) {
		this.person_number = person_number;
	}
	
}
