package com.soldesk.spring.info.stage;

import java.math.BigDecimal;
import java.util.Date;

public class Stage {
	private BigDecimal stage_number;
	private String stage_name;
	private String stage_place;
	private Date stage_date;
	private String stage_photo;
	
	public Stage() {
		// TODO Auto-generated constructor stub
	}

	public Stage(BigDecimal stage_number, String stage_name, String stage_place, Date stage_date, String stage_photo) {
		super();
		this.stage_number = stage_number;
		this.stage_name = stage_name;
		this.stage_place = stage_place;
		this.stage_date = stage_date;
		this.stage_photo = stage_photo;
	}

	public BigDecimal getStage_number() {
		return stage_number;
	}

	public void setStage_number(BigDecimal stage_number) {
		this.stage_number = stage_number;
	}

	public String getStage_name() {
		return stage_name;
	}

	public void setStage_name(String stage_name) {
		this.stage_name = stage_name;
	}

	public String getStage_place() {
		return stage_place;
	}

	public void setStage_place(String stage_place) {
		this.stage_place = stage_place;
	}

	public Date getStage_date() {
		return stage_date;
	}

	public void setStage_date(Date stage_date) {
		this.stage_date = stage_date;
	}

	public String getStage_photo() {
		return stage_photo;
	}

	public void setStage_photo(String stage_photo) {
		this.stage_photo = stage_photo;
	}
	
}
