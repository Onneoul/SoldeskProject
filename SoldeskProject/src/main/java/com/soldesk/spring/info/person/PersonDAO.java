package com.soldesk.spring.info.person;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.soldesk.spring.SiteOption;
import com.soldesk.spring.info.date_time.DateTimeMapper;
import com.soldesk.spring.info.theater.TheaterInfo;
import com.soldesk.spring.info.theater.TheaterMapper;
import com.soldesk.spring.info.theater.TheaterSelector;

@Service
public class PersonDAO {
	
	private int personCount;
	
	public int getPersonCount() {
		return personCount;
	}

	public void setPersonCount(int personCount) {
		this.personCount = personCount;
	}

	@Autowired
	private SqlSession ss;
	
    @Autowired
    private SiteOption so;
    
    public void searchPerson(TheaterSelector ts, HttpServletRequest req, HttpServletResponse rep) {
		req.getSession().setAttribute("search", ts);
	}

    
    public void getPersonDetail(int t, HttpServletRequest req, HttpServletResponse res) {	
    	
    	SimpleDateFormat sdf = null;
    	SimpleDateFormat sdf2 = null;
    	
    	try {
			
    		t = Integer.parseInt(req.getParameter("person_number"));
    		Person P = new Person();
    		P.setPerson_number(new BigDecimal(t));
    		
    		sdf = new SimpleDateFormat("yyyy");
			sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
    		
    		Person p = ss.getMapper(PersonMapper.class).getPersonInfo(P);
    		// person_number 파라메터 값으로 where person_number = #{person_number} 돌려서 person 구함
    		List<TheaterInfo> TL = ss.getMapper(PersonMapper.class).getPersonCast(p);
    		// 배우 페이지에 배우가 출연한 연극을 얻기 위해 위의 문장 실행
    		for (TheaterInfo ti : TL) {
    			ti.setTheater_date_time(ss.getMapper(DateTimeMapper.class).getTheaterDateTime(ti));
    			// 해당 연극의  date 얻음
    		}
    		p.setAge((Integer.parseInt(sdf.format(new Date()))) - (Integer.parseInt(sdf.format(p.getPerson_birth()))) + 1);
    		p.setPerson_cast(TL);
    		
    		req.setAttribute("p", p);
    		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    }
    
    public void personSearch(int page, HttpServletRequest req, HttpServletResponse res) {
    	
    	SimpleDateFormat sdf = null;
    	
    	try {
			
    		sdf = new SimpleDateFormat("yyyy");
    		
    		int count = so.getCountPerPage();
			int start = (page - 1) * count + 1;
			int end = start + (count - 1);
			
			TheaterSelector search = (TheaterSelector) req.getSession().getAttribute("search");
			
			int msgCount = 0;
			
			if (search == null) {
				search = new TheaterSelector("", new BigDecimal(start), new BigDecimal(end));
				;
				msgCount = personCount;
			} else {
				search.setStart(new BigDecimal(start));
				search.setEnd(new BigDecimal(end));
				msgCount = ss.getMapper(TheaterMapper.class).theaterCount(search);
			}
			List<Person> lp = ss.getMapper(PersonMapper.class).searchPerson(search);
			for (Person p : lp) {
				p.setAge((Integer.parseInt(sdf.format(new Date()))) - (Integer.parseInt(sdf.format(p.getPerson_birth()))) + 1);
			}
			TheaterInfo ti1 = new TheaterInfo();
			ti1.setTheater_number(new BigDecimal(req.getParameter("theater_number")));
			
			req.setAttribute("theater", ti1);
			req.setAttribute("person", lp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public void personWrite(Person p, HttpServletRequest req, HttpServletResponse res) {
    	
    	SimpleDateFormat sdf = null;
    	SimpleDateFormat sdf2 = null;
    	
    	try {
			
    		String path = req.getSession().getServletContext().getRealPath("resources/img/theaterPhoto");
    		MultipartRequest mr = null;
    		
    		try {
    			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
    		} catch (Exception e) {
    			e.printStackTrace();
    			return;
    		}
    		
    		String token = req.getParameter("token");
    		String successToken = (String) req.getSession().getAttribute("successToken");

    		if (successToken != null && token.equals(successToken)) {
    			return;
    		}
    		
    		sdf2 = new SimpleDateFormat("yyyy");
    		sdf = new SimpleDateFormat("yyyyMMdd");
    		Date d = new Date();
    		
    		String person_name = mr.getParameter("person_name");
    		Date person_birth = sdf.parse(mr.getParameter("person_birth"));
    		
    		String person_birthplace1 = mr.getParameter("person_place1");
    		String person_birthplace2 = mr.getParameter("person_place2");
    		String person_birthplace3 = mr.getParameter("person_place3");
    		String person_birthplace = person_birthplace1 + " " + person_birthplace2 + " " + person_birthplace3;
    		
    		String person_photo = mr.getFilesystemName("person_photo");
    		person_photo = URLEncoder.encode(person_photo, "utf-8");
    		person_photo = person_photo.replace("+", " ");
    		
    		p.setPerson_name(person_name);
    		p.setPerson_photo(person_photo);
    		p.setPerson_birth(person_birth);
    		p.setPerson_birthplace(person_birthplace);
    		p.setCode(new BigDecimal(2));
    		
    		ss.getMapper(PersonMapper.class).personWrite(p);
    		
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	
    }
    
    public void insertCasting (HttpServletRequest req, HttpServletResponse res) {
    	
    	try {
			
    		BigDecimal theater_number = new BigDecimal(req.getParameter("theater_number"));
    		BigDecimal person_number = new BigDecimal(req.getParameter("person_number"));
    		
    		Casting c = new Casting();
    		c.setTheater_number(theater_number);
    		c.setPerson_number(person_number);
    		
    		System.out.println(c.getPerson_number());
    		System.out.println(c.getTheater_number());
    		
    		ss.getMapper(PersonMapper.class).insertCasting(c);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void deleteCasting (HttpServletRequest req, HttpServletResponse res) {
    	
    	try {
			
    		Casting c = new Casting();
    		BigDecimal theater_number = new BigDecimal(req.getParameter("theater_number"));
    		BigDecimal person_number = new BigDecimal(req.getParameter("person_number"));
    		
    		c.setPerson_number(person_number);
    		c.setTheater_number(theater_number);
    		System.out.println(c.getPerson_number());
    		System.out.println(c.getTheater_number());
    		
    		ss.getMapper(PersonMapper.class).deleteCasting(c);
	
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}
