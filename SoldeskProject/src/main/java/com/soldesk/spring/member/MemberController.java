package com.soldesk.spring.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "member.join.go", method = RequestMethod.GET)
	public String memberJoinGo(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("SiteMain", "member/join.jsp");	
		return "index";
	}
	
	@RequestMapping(value = "member.join", method = RequestMethod.POST)
	public String memberJoin(Member m,
			HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		mDAO.join(m, req, res);
		req.setAttribute("SiteMain", "home.jsp");	
		return "index";
	}
	
	@RequestMapping(value = "member.login.go", method = RequestMethod.GET)
	public String memberLoginGo(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("SiteMain", "member/loginForm.jsp");	
		return "index";
	}
	
	@RequestMapping(value = "member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.login(m, req, res);
		mDAO.loginCheck(req, res);
		req.setAttribute("SiteMain", "home.jsp");	
		return "index";
	}
	
}
