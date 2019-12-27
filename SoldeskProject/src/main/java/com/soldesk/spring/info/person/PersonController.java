package com.soldesk.spring.info.person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.info.theater.TheaterDAO;
import com.soldesk.spring.info.theater.TheaterInfo;
import com.soldesk.spring.member.MemberDAO;

@Controller
public class PersonController {

	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private PersonDAO pdao;
	
	@Autowired
	private TheaterDAO tdao;
	
	@RequestMapping(value = "TheaterInfo.com.personDetail.Basic", method = RequestMethod.GET)
	public String getPersonBasic(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("person_number"));
		pdao.getPersonDetail(t, req, res);
		req.setAttribute("content", "info/ViewDetail/PersonDetail.jsp");
		req.setAttribute("PersonDetailInfo", "personDetail/Basic.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.personDetail.Cast", method = RequestMethod.GET)
	public String getPersonCast(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("person_number"));
		pdao.getPersonDetail(t, req, res);
		req.setAttribute("content", "info/ViewDetail/PersonDetail.jsp");
		req.setAttribute("PersonDetailInfo", "personDetail/Cast.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.personDetail.Detail", method = RequestMethod.GET)
	public String getPersonDetail(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("person_number"));
		pdao.getPersonDetail(t, req, res);
		req.setAttribute("content", "info/ViewDetail/PersonDetail.jsp");
		req.setAttribute("PersonDetailInfo", "personDetail/Detail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.writePerson", method = RequestMethod.GET) 
	public String writePerson(Person p, HttpServletRequest req, HttpServletResponse res) {
		return "info/Write/person/personWrite";
	}
	
	@RequestMapping(value = "TheaterInfo.com.personResist", method = RequestMethod.POST) 
	public String personResist(Person p, HttpServletRequest req, HttpServletResponse res) {
		pdao.personWrite(p, req, res);
		pdao.personSearch(1, req, res);
		return "info/Write/person/personSearch";
	}
	
	
	@RequestMapping(value = "TheaterInfo.com.searchPerson", method = RequestMethod.GET) 
	public String searchPerson(HttpServletRequest req, HttpServletResponse res) {
		pdao.personSearch(1, req, res);
		return "info/Write/person/personSearch";
	}
	
	@RequestMapping(value = "TheaterInfo.com.searchPersonPage", method = RequestMethod.GET) 
	public String searchPersonPage(HttpServletRequest req, HttpServletResponse res) {
		int p = Integer.parseInt(req.getParameter("page"));
		req.setAttribute("theater_number", req.getParameter("theater_number"));
		pdao.personSearch(p, req, res);
		return "info/Write/person/personSearch";
	}
	
	@RequestMapping(value = "TheaterInfo.com.insertCasting", method = RequestMethod.GET) 
	public String insertCasting(HttpServletRequest req, HttpServletResponse res) {
		pdao.insertCasting(req, res);
		pdao.personSearch(1, req, res);
		//req.setAttribute("content", "info/Write/detailWrite.jsp");
		return "info/Write/person/personSearch";
	}
	
	@RequestMapping(value = "TheaterInfo.com.deleteCasting", method = RequestMethod.GET) 
	public String deleteCasting(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		System.out.println("연결 성공");
		pdao.deleteCasting(req, res);
		System.out.println("casting delete 성공");
		//ti.setTheater_number(new BigDecimal(req.getParameter("theater_number")));
		//tdao.getTheaterDetail(ti, req, res);
		System.out.println("theaterDetail얻기 성공");
		req.setAttribute("content", "info/Write/detailWrite.jsp");
		return "index";
	}
}
