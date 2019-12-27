package com.soldesk.spring.info.theater;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.soldesk.spring.info.code.Code;
import com.soldesk.spring.info.date_time.Date_time;
import com.soldesk.spring.info.genre.Genre;
import com.soldesk.spring.info.organization.Organization;
import com.soldesk.spring.info.person.Person;
import com.soldesk.spring.info.stage.Stage;


public class TheaterInfo {
	private BigDecimal theater_number;
	private String theater_title;
	private BigDecimal theater_time;
	private BigDecimal theater_age;
	private String theater_photo;
	
	private Date_time start_date;
	private Date_time end_date;
	
	private List<Genre> theater_genre;
	private Stage theater_stage;
	private List<Person> theater_person;
	private List<Code> theater_code;
	private List<Date_time> theater_date_time;
	private Organization theater_organization;
	
	public TheaterInfo() {
		// TODO Auto-generated constructor stub
	}

	public TheaterInfo(BigDecimal theater_number, String theater_title, BigDecimal theater_time, BigDecimal theater_age,
			String theater_photo, Date_time start_date, Date_time end_date, List<Genre> theater_genre,
			Stage theater_stage, List<Person> theater_person, List<Code> theater_code,
			List<Date_time> theater_date_time, Organization theater_organization) {
		super();
		this.theater_number = theater_number;
		this.theater_title = theater_title;
		this.theater_time = theater_time;
		this.theater_age = theater_age;
		this.theater_photo = theater_photo;
		this.start_date = start_date;
		this.end_date = end_date;
		this.theater_genre = theater_genre;
		this.theater_stage = theater_stage;
		this.theater_person = theater_person;
		this.theater_code = theater_code;
		this.theater_date_time = theater_date_time;
		this.theater_organization = theater_organization;
	}

	public BigDecimal getTheater_number() {
		return theater_number;
	}

	public void setTheater_number(BigDecimal theater_number) {
		this.theater_number = theater_number;
	}

	public String getTheater_title() {
		return theater_title;
	}

	public void setTheater_title(String theater_title) {
		this.theater_title = theater_title;
	}

	public BigDecimal getTheater_time() {
		return theater_time;
	}

	public void setTheater_time(BigDecimal theater_time) {
		this.theater_time = theater_time;
	}

	public BigDecimal getTheater_age() {
		return theater_age;
	}

	public void setTheater_age(BigDecimal theater_age) {
		this.theater_age = theater_age;
	}

	public String getTheater_photo() {
		return theater_photo;
	}

	public void setTheater_photo(String theater_photo) {
		this.theater_photo = theater_photo;
	}

	public Date_time getStart_date() {
		return start_date;
	}

	public void setStart_date(Date_time start_date) {
		this.start_date = start_date;
	}

	public Date_time getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date_time end_date) {
		this.end_date = end_date;
	}

	public List<Genre> getTheater_genre() {
		return theater_genre;
	}

	public void setTheater_genre(List<Genre> theater_genre) {
		this.theater_genre = theater_genre;
	}

	public Stage getTheater_stage() {
		return theater_stage;
	}

	public void setTheater_stage(Stage theater_stage) {
		this.theater_stage = theater_stage;
	}

	public List<Person> getTheater_person() {
		return theater_person;
	}

	public void setTheater_person(List<Person> theater_person) {
		this.theater_person = theater_person;
	}

	public List<Code> getTheater_code() {
		return theater_code;
	}

	public void setTheater_code(List<Code> theater_code) {
		this.theater_code = theater_code;
	}

	public List<Date_time> getTheater_date_time() {
		return theater_date_time;
	}

	public void setTheater_date_time(List<Date_time> theater_date_time) {
		this.theater_date_time = theater_date_time;
	}

	public Organization getTheater_organization() {
		return theater_organization;
	}

	public void setTheater_organization(Organization theater_organization) {
		this.theater_organization = theater_organization;
	}
	
}
