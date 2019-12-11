package com.soldesk.spring.info.person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.info.theater.TheaterDAO;
import com.soldesk.spring.member.MemberDAO;

@Controller
public class PersonController {

	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private PersonDAO pdao;
	
	@Autowired
	private TheaterDAO tdao;
	
	@RequestMapping(value = "TheaterInfo.com.personSearch" )
	public String searchPerson(HttpServletRequest req, HttpServletResponse res) {
		
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterDetail.ViewPerson", method = RequestMethod.GET)
	public String getPersonDetail(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("t"));
		pdao.getPersonDetail(t, req, res);
		
		req.setAttribute("content", "info/ViewDetail/PersonDetail.jsp");
		
		return "index";
	}
	
}
