package com.soldesk.spring.info.theater;

import java.util.List;

import com.soldesk.spring.info.date_time.Date_time;
import com.soldesk.spring.info.genre.Genre;
import com.soldesk.spring.info.organization.Organization;
import com.soldesk.spring.info.person.Person;
import com.soldesk.spring.info.stage.Stage;

public interface TheaterMapper {
	public abstract Integer theaterCount(TheaterSelector ts);
	public abstract int theaterWrite(TheaterInfo ti);
	public abstract List<TheaterInfo> getTheater(TheaterSelector ts);
	public abstract List<Person> getTheaterPerson(TheaterInfo ti);
	public abstract List<Organization> getTheaterOrganization(TheaterInfo ti);
	public abstract List<Stage> getTheaterStage(TheaterInfo ti);
	public abstract List<Genre> getTheaterGenre(TheaterInfo ti);
	public abstract List<Date_time> getTheaterDatetime(TheaterInfo ti);
	
	
}
