package com.soldesk.spring.info.genre;

import java.math.BigDecimal;

public class Genre {
	private String genre_name;
	private BigDecimal code;
	
	public Genre() {
		// TODO Auto-generated constructor stub
	}

	public Genre(String genre_name, BigDecimal code) {
		super();
		this.genre_name = genre_name;
		this.code = code;
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
