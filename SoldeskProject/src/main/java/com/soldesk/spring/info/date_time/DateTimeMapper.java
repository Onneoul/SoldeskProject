package com.soldesk.spring.info.date_time;

import java.util.List;

import com.soldesk.spring.info.theater.TheaterInfo;

public interface DateTimeMapper {
	public abstract List<Date_time> getTheaterDateTime(TheaterInfo ti);
	public abstract Date_time getTheaterStartDate(TheaterInfo ti);
	public abstract Date_time getTheaterEndDate(TheaterInfo ti);
	
	public abstract int insertDate(Date_time dt);
	public abstract int insertTheaterDate(Theater_date_time tdt);
}
