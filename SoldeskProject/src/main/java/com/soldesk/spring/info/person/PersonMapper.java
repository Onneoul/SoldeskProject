package com.soldesk.spring.info.person;

import java.util.List;

import com.soldesk.spring.info.organization.Organization;
import com.soldesk.spring.info.theater.TheaterInfo;
import com.soldesk.spring.info.theater.TheaterSelector;

public interface PersonMapper {
	public abstract List<TheaterInfo> getPersonCast(Person p);
	
	public abstract List<Person> getTheaterPerson(TheaterInfo ti);
	public abstract List<Person> getPersonByOrganization(Organization o);
	public abstract List<Person> searchPerson(TheaterSelector ts);
	
	
	public abstract Person getPersonInfo(Person p);
	
	public abstract int personWrite(Person p);
	
	public abstract int insertCasting(Casting c);
	public abstract int deleteCasting(Casting c);
}
