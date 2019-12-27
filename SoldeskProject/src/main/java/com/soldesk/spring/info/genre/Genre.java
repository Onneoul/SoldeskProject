package com.soldesk.spring.info.genre;

import java.math.BigDecimal;

public class Genre {
	private BigDecimal genre_number;
	private String genre_name;
	private BigDecimal code;
	
	public Genre() {
		// TODO Auto-generated constructor stub
	}

	public Genre(BigDecimal genre_number, String genre_name, BigDecimal code) {
		super();
		this.genre_number = genre_number;
		this.genre_name = genre_name;
		this.code = code;
	}

	public BigDecimal getGenre_number() {
		return genre_number;
	}

	public void setGenre_number(BigDecimal genre_number) {
		this.genre_number = genre_number;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	

}
