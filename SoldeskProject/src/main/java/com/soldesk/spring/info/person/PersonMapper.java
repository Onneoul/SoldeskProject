package com.soldesk.spring.info.person;

import java.util.List;

import com.soldesk.spring.info.theater.TheaterInfo;

public interface PersonMapper {
	public abstract List<TheaterInfo> getPersonTheater(Person p);
	public abstract List<Person> getTheaterPerson(TheaterInfo ti);
	public abstract Person getPersonInfo(Person p);
}
