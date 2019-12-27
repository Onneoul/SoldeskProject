package com.soldesk.spring.info.theater;

import java.util.List;

import com.soldesk.spring.info.date_time.Date_time;
import com.soldesk.spring.info.genre.Genre;
import com.soldesk.spring.info.genre.TheaterGenre;
import com.soldesk.spring.info.organization.Organization;
import com.soldesk.spring.info.person.Person;
import com.soldesk.spring.info.stage.Stage;

public interface TheaterMapper {
	public abstract Integer theaterCount(TheaterSelector ts);
	public abstract int theaterWrite(TheaterInfo ti);
	public abstract List<TheaterInfo> getTheater(TheaterSelector ts);
	public abstract TheaterInfo getTheaterDetail(TheaterInfo ti);
	
	public abstract Organization getTheaterOrganization(TheaterInfo ti);
	public abstract Stage getTheaterStage(TheaterInfo ti);
	public abstract List<Genre> getTheaterGenre(TheaterInfo ti);
	public abstract List<Date_time> getTheaterDateTime(TheaterInfo ti);

	public abstract Stage getStageByNumber(Stage s);
	public abstract Genre getGenreByNumber(Genre g);
	public abstract Organization getOrganizationByNumber(Organization o);
	
	public abstract List<Genre> getGenre(TheaterSelector ts);
	public abstract Integer genreCount(TheaterSelector ts);
	public abstract int insertGenre(TheaterGenre g);
	
	public abstract int theaterUpadate(TheaterInfo ti);
	public abstract int theaterDelete(TheaterInfo ti);
	
	public abstract List<TheaterInfo> getTheaterByOrganization(Organization o);
	public abstract List<TheaterInfo> getTheaterByPerson(Person p);
	public abstract List<TheaterInfo> getTheaterByGenre(Genre g);
	public abstract List<TheaterInfo> getTheaterByStage(Stage s);
	public abstract TheaterInfo getTheaterByPhoto(TheaterInfo ti);
}
