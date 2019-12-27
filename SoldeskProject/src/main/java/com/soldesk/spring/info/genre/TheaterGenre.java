package com.soldesk.spring.info.genre;

import java.math.BigDecimal;

public class TheaterGenre {
	private BigDecimal theater_number;
	private BigDecimal genre_number;
	
	public TheaterGenre() {
		// TODO Auto-generated constructor stub
	}

	public TheaterGenre(BigDecimal theater_number) {
		super();
		this.theater_number = theater_number;
	}
	
	public BigDecimal getTheater_number() {
		return theater_number;
	}

	public void setTheater_number(BigDecimal theater_number) {
		this.theater_number = theater_number;
	}

	public BigDecimal getGenre_number() {
		return genre_number;
	}

	public void setGenre_number(BigDecimal genre_number) {
		this.genre_number = genre_number;
	}
	
}
