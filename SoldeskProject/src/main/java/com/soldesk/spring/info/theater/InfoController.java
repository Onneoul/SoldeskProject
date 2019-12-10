package com.soldesk.spring.info.theater;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.member.MemberDAO;

@Controller
public class InfoController {

	private boolean firstConnect;
	
	@Autowired
	TheaterDAO idao;
	
	@Autowired
	MemberDAO mdao;
	
	@RequestMapping(value = "TheaterInfo.com.theater", method = RequestMethod.GET)
	public String getTheaterInfo(HttpServletRequest req, HttpServletResponse rep) {
		mdao.memberLoginCheck(req, rep);
		idao.getInfo(1, req, rep);
		req.setAttribute("content", "info/theater.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterDetail.Basic", method = RequestMethod.GET)
	public String getTheaterDetail(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("theater_number"));
		idao.getTheaterDetail(t, req, res);
		req.setAttribute("content", "info/ViewDetail/TheaterDetail.jsp");
		return "index";
	}
	
	
}
