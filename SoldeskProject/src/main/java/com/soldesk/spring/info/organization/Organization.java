package com.soldesk.spring.info.organization;

import java.math.BigDecimal;
import java.util.List;

import com.soldesk.spring.info.person.Person;
import com.soldesk.spring.info.theater.TheaterInfo;

public class Organization {
	private BigDecimal group_number;
	private String group_name;

	private List<Person> group_person;
	private List<TheaterInfo> group_theater;
	
	public Organization() {
		// TODO Auto-generated constructor stub
	}

	public Organization(BigDecimal group_number, String group_name, List<Person> group_person,
			List<TheaterInfo> group_theater) {
		super();
		this.group_number = group_number;
		this.group_name = group_name;
		this.group_person = group_person;
		this.group_theater = group_theater;
	}

	public BigDecimal getGroup_number() {
		return group_number;
	}

	public void setGroup_number(BigDecimal group_number) {
		this.group_number = group_number;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public List<Person> getGroup_person() {
		return group_person;
	}

	public void setGroup_person(List<Person> group_person) {
		this.group_person = group_person;
	}

	public List<TheaterInfo> getGroup_theater() {
		return group_theater;
	}

	public void setGroup_theater(List<TheaterInfo> group_theater) {
		this.group_theater = group_theater;
	}

	
	
}
