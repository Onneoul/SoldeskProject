package com.soldesk.spring.info.theater;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.soldesk.spring.SiteOption;
import com.soldesk.spring.info.date_time.DateTimeMapper;
import com.soldesk.spring.info.date_time.Date_time;
import com.soldesk.spring.info.date_time.Theater_date_time;
import com.soldesk.spring.info.genre.Genre;
import com.soldesk.spring.info.genre.TheaterGenre;
import com.soldesk.spring.info.organization.Organization;
import com.soldesk.spring.info.person.Person;
import com.soldesk.spring.info.person.PersonMapper;
import com.soldesk.spring.info.stage.Stage;
import com.soldesk.spring.member.Member;

@Service
public class TheaterDAO {
	
	private int allMsgCount;

	public int getAllMsgCount() {
		return allMsgCount;
	}

	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
    private SiteOption so;
	
	public void searchTheater(TheaterSelector ts, HttpServletRequest req, HttpServletResponse rep) {
		req.getSession().setAttribute("search", ts);
	}
	
	
    public void getInfo(int page, HttpServletRequest req, HttpServletResponse res) {
    	
    	SimpleDateFormat sdf = null;
    	SimpleDateFormat sdf2 = null;
    	
    	String path = req.getSession().getServletContext().getRealPath("resources/img/theaterPhoto");
    	
    	try {
    		int count = so.getCountPerPage();
			int start = (page - 1) * count + 1;
			int end = start + (count - 1);
			
			TheaterSelector search = (TheaterSelector) req.getSession().getAttribute("search");
			
			int msgCount = 0;
			
			if (search == null) {
				search = new TheaterSelector("", new BigDecimal(start), new BigDecimal(end));
				
				msgCount = allMsgCount;
			} else {
				search.setStart(new BigDecimal(start));
				search.setEnd(new BigDecimal(end));
				msgCount = ss.getMapper(TheaterMapper.class).theaterCount(search);
			}
			
			sdf = new SimpleDateFormat("yyyyMMdd");
			sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
			
			int start_number = 0;
			int end_number = 0;
			Date sys = new Date();
			
			List<TheaterInfo> lt = ss.getMapper(TheaterMapper.class).getTheater(search);
			for (TheaterInfo ti : lt) {
				theaterInfo(ti, req, res);
				ti.setTheater_photo(path+"\\"+ti.getTheater_photo());
				System.out.println(ti.getTheater_photo());
			}
			req.setAttribute("TheaterInfo", lt);
			
			// lt 에 들어있는 것 - List<Genre> theater_genre, List<Person> theater_person, Strat_date, End_date,
			// 					 rownum as rn, theater_number, theater_photo, theater_title, theater_time, theater_age
			// 					다만 rn은 사이트에 노출될 일은 없다.
			// 상세 페이지로 이동은 a 태그 통해서 컨트롤러로 요청 보내게 (jsp에서 작업), parameter로 theater_info의 theater_number 보내기
			
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void theaterInfo (TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
    	
    	try {
    		ti.setTheater_person(ss.getMapper(PersonMapper.class).getTheaterPerson(ti));
			ti.setTheater_date_time(ss.getMapper(TheaterMapper.class).getTheaterDateTime(ti));
			ti.setStart_date(ss.getMapper(DateTimeMapper.class).getTheaterStartDate(ti));
			ti.setEnd_date(ss.getMapper(DateTimeMapper.class).getTheaterEndDate(ti));
			ti.setTheater_genre(ss.getMapper(TheaterMapper.class).getTheaterGenre(ti));
			ti.setTheater_stage(ss.getMapper(TheaterMapper.class).getTheaterStage(ti));
			ti.setTheater_organization(ss.getMapper(TheaterMapper.class).getTheaterOrganization(ti));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
   
    public void getTheaterDetail(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
    	
    	try {
    		
    		ti.setTheater_number(new BigDecimal(req.getParameter("theater_number")));
    		TheaterInfo TI = ss.getMapper(TheaterMapper.class).getTheaterDetail(ti);
    		theaterInfo(TI, req, res);
    		
    		/*TI.setTheater_person(ss.getMapper(PersonMapper.class).getTheaterPerson(LT));
    		TI.setTheater_date_time(ss.getMapper(DateTimeMapper.class).getTheaterDateTime(LT));
    		TI.setTheater_genre(ss.getMapper(TheaterMapper.class).getTheaterGenre(LT));
    		TI.setTheater_stage(ss.getMapper(TheaterMapper.class).getTheaterStage(LT));
    		TI.setTheater_organization(ss.getMapper(TheaterMapper.class).getTheaterOrganization(LT));*/
    		
    		req.setAttribute("ti", TI);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
    
    public void getTheaterByGenre(int t, HttpServletRequest req, HttpServletResponse res) {
    	
    	try {
			
    		Genre g = new Genre();
    		g.setGenre_number(new BigDecimal(t));
    		Genre G = ss.getMapper(TheaterMapper.class).getGenreByNumber(g);
    		
    		List<TheaterInfo> ti = ss.getMapper(TheaterMapper.class).getTheaterByGenre(g);
    		
    		for (TheaterInfo TI : ti) {
    			TI.setTheater_person(ss.getMapper(PersonMapper.class).getTheaterPerson(TI));
    			TI.setTheater_date_time(ss.getMapper(DateTimeMapper.class).getTheaterDateTime(TI));
    			TI.setTheater_genre(ss.getMapper(TheaterMapper.class).getTheaterGenre(TI));
    			TI.setTheater_stage(ss.getMapper(TheaterMapper.class).getTheaterStage(TI));
    			TI.setTheater_organization(ss.getMapper(TheaterMapper.class).getTheaterOrganization(TI));
    		}
    		
    		req.setAttribute("genre", G);
    		req.setAttribute("theater", ti);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

	public void getTheaterByGroup(int t, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
    		Organization o = new Organization();
    		o.setGroup_number(new BigDecimal(t));
    		Organization O = ss.getMapper(TheaterMapper.class).getOrganizationByNumber(o);
    		O.setGroup_person(ss.getMapper(PersonMapper.class).getPersonByOrganization(o));
    		List<Person> lp = O.getGroup_person();
    		for (Person p : lp) {
    			p.setPerson_cast(ss.getMapper(PersonMapper.class).getPersonCast(p));
    		}
    		O.setGroup_person(lp);
    		
    		List<TheaterInfo> ti = ss.getMapper(TheaterMapper.class).getTheaterByOrganization(O);
    		
    		for (TheaterInfo TI : ti) {
    			TI.setTheater_person(ss.getMapper(PersonMapper.class).getTheaterPerson(TI));
    			TI.setTheater_date_time(ss.getMapper(DateTimeMapper.class).getTheaterDateTime(TI));
    			TI.setTheater_genre(ss.getMapper(TheaterMapper.class).getTheaterGenre(TI));
    			TI.setTheater_stage(ss.getMapper(TheaterMapper.class).getTheaterStage(TI));
    			TI.setTheater_organization(ss.getMapper(TheaterMapper.class).getTheaterOrganization(TI));
    		}
    		O.setGroup_theater(ti);

    		
    		req.setAttribute("o", O);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getStageDetail(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			Stage s = new Stage();
			s.setStage_number(new BigDecimal(req.getParameter("stage_number")));
			Stage S = ss.getMapper(TheaterMapper.class).getStageByNumber(s);
			
			List<TheaterInfo> ti = ss.getMapper(TheaterMapper.class).getTheaterByStage(S);
			
			for (TheaterInfo TI : ti) {
				theaterInfo(TI, req, res);
			}
			
			S.setStage_theater(ti);
			
			req.setAttribute("stage", S);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void theaterWrite(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/img/theaterPhoto");
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");

			if (successToken != null && token.equals(successToken)) {
				return;
			}
			
			String theater_title = mr.getParameter("theater_title");
			String theater_photo = mr.getFilesystemName("theater_photo");
			theater_photo = URLEncoder.encode(theater_photo, "utf-8");
			theater_photo = theater_photo.replace("+", " ");
			BigDecimal theater_time = new BigDecimal(mr.getParameter("theater_time"));
			BigDecimal theater_age = new BigDecimal(mr.getParameter("theater_age"));
			
			 ti.setTheater_title(theater_title);
			 ti.setTheater_photo(theater_photo);
			 ti.setTheater_time(theater_time);
			 ti.setTheater_age(theater_age);
			 
			 if(ss.getMapper(TheaterMapper.class).theaterWrite(ti) == 1) {
				 req.setAttribute("result", "성공");
				 req.getSession().setAttribute("successToken", token);
			 } else {
				 req.setAttribute("result", "실패");
			 }
			TheaterInfo li = (ss.getMapper(TheaterMapper.class).getTheaterByPhoto(ti));
			
			req.setAttribute("ti", li); 
			
		} catch (Exception e) {
			String fileName = mr.getFilesystemName("theater_photo");
			new File(path + "/" + fileName).delete();
			e.printStackTrace();
			req.setAttribute("result", "오류");
		}
	}
	
	public void theaterUpdate(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/img/theaterPhoto");
		MultipartRequest mr = null;
		//String oldFile = ti.getTheater_photo();
		//String newFile = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			//newFile = mr.getFilesystemName("member_photo");
			//if (newFile == null) {
			//	newFile = oldFile;
			//} else { 
			//	newFile = URLEncoder.encode(newFile, "utf-8");
			//	newFile = newFile.replace("+", " ");
			//}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			System.out.println("11");
			return;
		}
		
		
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");

			if (successToken != null && token.equals(successToken)) {
				return;
			}
			
			BigDecimal theater_number = new BigDecimal(req.getParameter("theater_number"));
			String theater_photo = mr.getFilesystemName("theater_photo");
			theater_photo = URLEncoder.encode(theater_photo, "utf-8");
			theater_photo = theater_photo.replace("+", " ");
			
			ti.setTheater_number(theater_number);
			ti.setTheater_title(mr.getParameter("theater_title"));
			ti.setTheater_photo(theater_photo);
			ti.setTheater_time(new BigDecimal(mr.getParameter("theater_time")));
			ti.setTheater_age(new BigDecimal(mr.getParameter("theater_age")));
			
			System.out.println(ti.getTheater_number());
			System.out.println(ti.getTheater_title());
			System.out.println(ti.getTheater_age());
			System.out.println(ti.getTheater_time());
			 
			 if(ss.getMapper(TheaterMapper.class).theaterUpadate(ti) == 1) {
				 req.setAttribute("result", "업데이트 성공");
				 req.getSession().setAttribute("successToken", token);
			 } else {
				 req.setAttribute("result", "업데이트 실패");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void theaterDelete(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			ss.getMapper(TheaterMapper.class).theaterDelete(ti);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertDate(Date_time dt, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			
			ss.getMapper(DateTimeMapper.class).insertDate(dt);
			Theater_date_time tdt = new Theater_date_time();
			tdt.setTheater_number(new BigDecimal(req.getParameter("theater_number")));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void genreSearch(int page, HttpServletRequest req, HttpServletResponse res) {
		
		try {
    		int count = so.getCountPerPage();
			int start = (page - 1) * count + 1;
			int end = start + (count - 1);
			
			TheaterSelector search = (TheaterSelector) req.getSession().getAttribute("search");
			
			int msgCount = 0;
			
			if (search == null) {
				search = new TheaterSelector("", new BigDecimal(start), new BigDecimal(end));
				
				msgCount = allMsgCount;
			} else {
				search.setStart(new BigDecimal(start));
				search.setEnd(new BigDecimal(end));
				msgCount = ss.getMapper(TheaterMapper.class).genreCount(search);
			}
			
			List<Genre> lg = ss.getMapper(TheaterMapper.class).getGenre(search);
			
			req.setAttribute("genre", lg);
			req.setAttribute("curPage", page);

			int pageCount = (int) Math.ceil(msgCount / (double) count);
			req.setAttribute("pageCount", pageCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertGenre(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			TheaterGenre g = new TheaterGenre();
			g.setTheater_number(new BigDecimal(req.getParameter("theater_number")));
			g.setGenre_number(new BigDecimal(req.getParameter("genre_number")));
			System.out.println(g.getTheater_number());
			System.out.println(g.getGenre_number());
			
			
			ss.getMapper(TheaterMapper.class).insertGenre(g);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
