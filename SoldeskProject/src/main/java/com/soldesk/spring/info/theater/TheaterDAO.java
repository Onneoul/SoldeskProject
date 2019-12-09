package com.soldesk.spring.info.theater;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk.spring.SiteOption;
import com.soldesk.spring.info.date_time.Date_time;

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
	
	public void searchNotice(TheaterSelector ts, HttpServletRequest req, HttpServletResponse rep) {
		req.getSession().setAttribute("search", ts);
	}
	
	
    public void getInfo(int page, HttpServletRequest req, HttpServletResponse rep) {
    	
    	SimpleDateFormat sdf = null;
    	SimpleDateFormat sdf2 = null;
    	
    	try {
    		int count = so.getSnsCountPerPage();
			int start = (page - 1) * count + 1;
			int end = start + (count - 1);
			
			TheaterSelector search = (TheaterSelector) req.getSession().getAttribute("search");
			
			int msgCount = 0;
			
			if (search == null) {
				search = new TheaterSelector("", new BigDecimal(start), new BigDecimal(end));
				;
				msgCount = allMsgCount;
			} else {
				search.setStart(new BigDecimal(start));
				search.setEnd(new BigDecimal(end));
				msgCount = ss.getMapper(TheaterMapper.class).theaterCount(search);
			}
			
			sdf = new SimpleDateFormat("yyyyMMdd");
			sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
			
			List<String> dl = null;
			List<Integer>dl2 = null;
			int start_number = 0;
			int end_number = 0;
			
			List<TheaterInfo> lt = ss.getMapper(TheaterMapper.class).getTheater(search);
			for (TheaterInfo ti : lt) {
				//ti.setTheater_genre(ss.getMapper(TheaterMapper.class).getTheaterGenre(ti));
				ti.setTheater_person(ss.getMapper(TheaterMapper.class).getTheaterPerson(ti));
				/*ti.setTheater_date_time(ss.getMapper(TheaterMapper.class).getTheaterDatetime(ti)); // date_time 리스트 생성
				for (Date_time dt : ti.getTheater_date_time()) { // For 문 돌려서 공연 시작 날짜와 끝나는 날짜 구하기
					dl.add(sdf.format(dt.getTheater_date())); // Date_time의 Theater_date를 String List dl에 추가
					for (int i = 0; i <= dl.size(); i++) {
						dl2.add(Integer.parseInt(dl.get(i))); // dl에 추가된 값을 integer로 형변환 해서 출력
					}
					start_number = Collections.min(dl2); // dl2의 최솟값 구하기 (제일 오래된 날짜?)
					end_number = Collections.max(dl2); // dl2의 최댓값 구하기 (제일 최근 날짜)
				}
				ti.setStart_date(sdf2.format((""+ start_number))); // sdf2로 형변환 후 Start_date에 set
				ti.setEnd_date(sdf2.format((""+ end_number))); */
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
    
}
