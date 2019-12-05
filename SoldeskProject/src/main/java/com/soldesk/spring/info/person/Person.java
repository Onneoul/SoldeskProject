package com.soldesk.spring.info.person;

import java.math.BigDecimal;
import java.util.Date;

public class Person {
	private BigDecimal person_number;
	private String person_name;
	private Date person_birth;
	private String person_birthplace;
	private String person_photo;
	private BigDecimal code;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(BigDecimal person_number, String person_name, Date person_birth, String person_birthplace,
			String person_photo, BigDecimal code) {
		super();
		this.person_number = person_number;
		this.person_name = person_name;
		this.person_birth = person_birth;
		this.person_birthplace = person_birthplace;
		this.person_photo = person_photo;
		this.code = code;
	}

	public BigDecimal getPerson_number() {
		return person_number;
	}

	public void setPerson_number(BigDecimal person_number) {
		this.person_number = person_number;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public Date getPerson_birth() {
		return person_birth;
	}

	public void setPerson_birth(Date person_birth) {
		this.person_birth = person_birth;
	}

	public String getPerson_birthplace() {
		return person_birthplace;
	}

	public void setPerson_birthplace(String person_birthplace) {
		this.person_birthplace = person_birthplace;
	}

	public String getPerson_photo() {
		return person_photo;
	}

	public void setPerson_photo(String person_photo) {
		this.person_photo = person_photo;
	}

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}
	
	
}
